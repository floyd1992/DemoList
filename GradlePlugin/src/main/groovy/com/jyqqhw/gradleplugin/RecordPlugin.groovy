package com.jyqqhw.gradleplugin

import org.gradle.api.Plugin
import org.gradle.api.Project;

class RecordPlugin implements Plugin<Project>{

    @Override
    void apply(Project project) {
        println("hahaha, i am a plugin")
    }
}