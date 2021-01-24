package cn.quickits.tools.make


import org.gradle.api.Project
import org.gradle.api.ProjectEvaluationListener
import org.gradle.api.ProjectState
import org.gradle.api.invocation.Gradle

class GradleBuildHooker implements ProjectEvaluationListener {

    void hook(Gradle gradle) {
        DpdManager.initDependencies()
        DpdManager.genDep(gradle)
        gradle.addProjectEvaluationListener(this)
    }

    // ProjectEvaluationListener
    @Override
    void beforeEvaluate(Project project) {
        println(">> " + project.path)

        if (project.subprojects.isEmpty()) {
            if (project.name == "app" || project.name.endsWith("_app")) {
                project.apply {
                    from "${project.rootDir.path}/buildScript/buildApp.gradle"
                }
            } else {
                project.apply {
                    from "${project.rootDir.path}/buildScript/buildLibrary.gradle"
                }
            }
        }
    }

    @Override
    void afterEvaluate(Project project, ProjectState projectState) {
        println("<< " + project.path)
    }

}