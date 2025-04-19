package dev.the_nerd2.oksidation

import org.gradle.api.Plugin
import org.gradle.api.Project

class OksidationPlugin: Plugin<Project> {
    override fun apply(project: Project) {
        println("Test")
    }
}