package cn.quickits.tools.make

import org.gradle.api.invocation.Gradle

/**
 * Dependence Manager
 *
 * @author Gavin Liu
 *
 * Created on 2019/11/7.
 */
class DpdManager {

    private static def allDependencies = [:]

    public static def pluginDependencies = [:]

    public static def testDependencies = [:]

    public static def androidTestDependencies = [:]

    public static def localDependencies = [:]

    public static def pkgDependencies = [:]

    public static def exportDependencies = [:]

    static def initDependencies() {
        allDependencies = genAllDependencies("", Config.deps)

        for (Map.Entry<String, DpdInfo> entry : allDependencies.entrySet()) {
            def (name, value) = [entry.getKey(), entry.getValue()]

            if (value.isUseLocal()) {
                localDependencies.put(name, value)
            }

            if (name.startsWith("plugin.")) {
                pluginDependencies.put(name, value)
            } else if (name.startsWith("test.")) {
                testDependencies.put(name, value)
            } else if (name.startsWith("androidTest.")) {
                androidTestDependencies.put(name, value)
            } else if (name.endsWith("_pkg")) {
                pkgDependencies.put(name, value)
            } else if (name.endsWith("_export")) {
                exportDependencies.put(name, value)
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

    }

    private static printDependencies(Map map) {
        for (Map.Entry<String, DpdInfo> entry : map.entrySet()) {
            def (name, value) = [entry.getKey(), entry.getValue()]
            println(name + " " + value)
        }
        println()
    }

    static def genDep(Gradle gradle) {
        for (Map.Entry<String, DpdInfo> entry : allDependencies.entrySet()) {
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