import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

version = "0.0.1"

plugins {
    kotlin("jvm") version "1.3.60"
    id("org.openjfx.javafxplugin") version "0.0.8"
    id("org.beryx.jlink") version "2.17.0"
}

repositories {
    jcenter() // or maven central
    maven("https://oss.sonatype.org/content/repositories/snapshots") // this is the important one
}

dependencies {
    implementation("no.tornado:tornadofx:2.0.0-SNAPSHOT")
}

val compileKotlin: KotlinCompile by tasks
val compileJava: JavaCompile by tasks
compileJava.destinationDir = compileKotlin.destinationDir

application {
    mainClassName = "test.module/de.sampleTfx.Main"
}

javafx {
    modules("javafx.controls", "javafx.fxml", "javafx.media", "javafx.web", "javafx.swing")
}

jlink {
    launcher {
        name = "hello"
    }
    addExtraDependencies("javafx")
    imageZip.set(project.file("${project.buildDir}/image-zip/hello-image.zip"))
}