import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    application
    id("com.github.johnrengelman.shadow") version "5.1.0"
    kotlin("jvm") version "1.3.40"
}

group = "io.lab"
version = "1.0-SNAPSHOT"


repositories {
    mavenCentral()
}

dependencies {
    compile(kotlin("stdlib-jdk8"))
    compile("io.javalin:javalin:3.5.0")
    compile("org.apache.xmlgraphics:batik-all:1.11")
    compile("org.scilab.forge:jlatexmath:1.0.7")
    compile("org.scilab.forge:jlatexmath-fop:1.0.7")
    compile("org.scilab.forge:jlatexmath-font-greek:1.0.7")
    compile("org.scilab.forge:jlatexmath-font-cyrillic:1.0.7")
    compile("org.slf4j:slf4j-simple:1.7.26")
}

application {
    this.mainClassName = "io.lab.AppKt"
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}










