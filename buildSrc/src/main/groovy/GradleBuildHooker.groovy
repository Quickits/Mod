import org.gradle.BuildListener
import org.gradle.BuildResult
import org.gradle.api.Project
import org.gradle.api.ProjectEvaluationListener
import org.gradle.api.ProjectState
import org.gradle.api.initialization.Settings
import org.gradle.api.invocation.Gradle

class GradleBuildHooker implements BuildListener, ProjectEvaluationListener {

    void hook(Gradle g) {
        g.addBuildListener(this)
    }

    // BuildListener
    @Override
    void buildStarted(Gradle gradle) {
        println "buildStarted"
    }

    @Override
    void settingsEvaluated(Settings settings) {
        println "settingsEvaluated"
        includeModule(settings)
    }

    @Override
    void projectsLoaded(Gradle gradle) {
        println "projectsLoaded"
        gradle.addProjectEvaluationListener(this)
    }

    @Override
    void projectsEvaluated(Gradle gradle) {
        println "projectsEvaluated"
    }

    @Override
    void buildFinished(BuildResult buildResult) {
        println "buildFinished"
    }


    // ProjectEvaluationListener
    @Override
    void beforeEvaluate(Project project) {
        if (project.subprojects.isEmpty()) {
            println(project.name)
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


    private static includeModule(Settings settings) {
        settings.include ':app'

        settings.include ':core:base', ':core:common'

        settings.include ':features:featureA:pkg', ':features:featureA:export', ':features:featureA:app'

        settings.include ':features:featureB:pkg', ':features:featureB:export', ':features:featureB:app'
    }

}