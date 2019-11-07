import org.gradle.api.invocation.Gradle

class DependencyManager {

    private static def allDependencies = [:]

    static def pluginDependencies = [:]

    static def testDependencies = [:]

    static def androidTestDependencies = [:]

    static def localDependencies = [:]

    static def pkgDependencies = [:]

    static def exportDependencies = [:]

    static def moduleDependencies = [:]

    static def initDependencies() {
        allDependencies = genAllDependencies("", Config.deps)

        for (Map.Entry<String, DependencyInfo> entry : allDependencies.entrySet()) {
            def (name, value) = [entry.getKey(), entry.getValue()]
            if (name.startsWith("plugin.")) {
                pluginDependencies.put(name, value)
            } else if (name.startsWith("test.")) {
                testDependencies.put(name, value)
            } else if (name.startsWith("androidTest.")) {
                androidTestDependencies.put(name, value)
            } else {
                if (value.isUseLocal()) {
                    localDependencies.put(name, value)
                }

                if (name.endsWith(".pkg")) {
                    pkgDependencies.put(name, value)
                } else if (name.endsWith(".export")) {
                    exportDependencies.put(name, value)
                } else if (!value.isUseLocal()) {
                    moduleDependencies.put(name, value)
                }
            }
        }

        println("====== pluginDependencies ======")
        printDependencies(pluginDependencies)

        println("====== testDependencies ======")
        printDependencies(testDependencies)

        println("====== androidTestDependencies ======")
        printDependencies(androidTestDependencies)

        println("====== localDependencies ======")
        printDependencies(localDependencies)

        println("====== pkgDependencies ======")
        printDependencies(pkgDependencies)

        println("====== exportDependencies ======")
        printDependencies(exportDependencies)

        println("====== moduleDependencies ======")
        printDependencies(moduleDependencies)
    }

    private static printDependencies(Map map) {
        for (Map.Entry<String, DependencyInfo> entry : map.entrySet()) {
            def (name, value) = [entry.getKey(), entry.getValue()]
            println(name + " " + value)
        }
        println()
    }

    static def genDep(Gradle gradle) {
        for (Map.Entry<String, DependencyInfo> entry : allDependencies.entrySet()) {
            def value = entry.getValue()
            if (value.useLocal) {
                value.dep = gradle.rootProject.findProject(value.localPath)
            } else {
                value.dep = value.remotePath
            }
        }
    }

    private static genAllDependencies(String namePrefix, Map map) {
        def linearList = [:]
        for (Map.Entry entry : map.entrySet()) {
            def (name, value) = [entry.getKey(), entry.getValue()]
            if (value instanceof Map) {
                namePrefix += (name + '.')
                linearList.putAll(genAllDependencies(namePrefix, value))
                namePrefix -= (name + '.')
                continue
            }
            linearList.put(namePrefix + name, value)
        }
        return linearList
    }

}