package dev.the_nerd2.oksidation

import org.gradle.api.DefaultTask
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.file.Directory
import org.gradle.api.provider.Provider
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction

@Suppress("unused")
class OksidationPlugin: Plugin<Project> {
    override fun apply(project: Project) {
        val config = project.extensions.create("oksidation", OksidationExtension::class.java)
        val generationTask = project.tasks.register("generateBindings", GenerateBindingsTask::class.java) {
            it.crates = config.crates
            it.reExports = config.reExports
            it.outputDir = project.layout.buildDirectory.dir("oksidationBindings")
        }
        project.tasks.named("compileKotlin") {
            it.dependsOn(generationTask)
        }
    }
}

open class OksidationExtension {
    var crates: List<String> = emptyList()
    var reExports: List<String> = emptyList()
}

open class GenerateBindingsTask: DefaultTask() {
    @get:Input
    lateinit var crates: List<String>
    @get:Input
    lateinit var reExports: List<String>
    @get:OutputDirectory
    lateinit var outputDir: Provider<Directory>
    @TaskAction
    fun generate() {
        println("crates: $crates")
        println("reExports: $reExports")
        println("outputDir: ${outputDir.get()}")
    }
}
