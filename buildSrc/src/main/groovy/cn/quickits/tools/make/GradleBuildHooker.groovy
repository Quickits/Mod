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
        if (project.subprojects.isEmpty()) {
            println(project.path)
            switch (project.name) {
                case "app":
                    project.apply {
                        from "${project.rootDir.path}/buildApp.gradle"
                    }
                    break

                default:
                    project.apply {
                        from "${project.rootDir.path}/buildLibrary.gradle"
                    }
                    break
            }
        }
    }

    @Override
    void afterEvaluate(Project project, ProjectState projectState) {

    }

}