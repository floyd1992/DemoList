package com.jyqqhw.gradleplugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.Copy;

class RecordPlugin implements Plugin<Project>{

    @Override
    void apply(Project project) {
        println("hahaha, i am a plugin")
        project.task("checkPostCommitFile"){
            type:Copy
            from "$rootDir\\post-commit"
            into "$rootDir\\.git\\hooks"
        }
    }

}