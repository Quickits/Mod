import org.gradle.BuildListener
import org.gradle.BuildResult
import org.gradle.api.Project
import org.gradle.api.ProjectEvaluationListener
import org.gradle.api.ProjectState
import org.gradle.api.initialization.Settings
import org.gradle.api.invocation.Gradle

class GradleBuildHooker implements BuildListener, ProjectEvaluationListener {

    void hook(Gradle g) {
        DependencyManager.initDependencies()
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
        DependencyManager.genDep(gradle)
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
        for (Map.Entry<String, DependencyInfo> entry : DependencyManager.localDependencies.entrySet()) {
            settings.include entry.value.localPath
        }
    }

}