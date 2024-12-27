import dev.kordex.gradle.plugins.docker.file.*
import dev.kordex.gradle.plugins.kordex.DataCollection

plugins {
    val kotlinVersion = "2.0.21"
    val kordexVersion = "1.6.0"

    kotlin("jvm") version kotlinVersion
    kotlin("plugin.serialization") version kotlinVersion
    id("dev.kordex.gradle.kordex") version kordexVersion
    id("dev.kordex.gradle.docker") version kordexVersion
}

group = "live.einfachgustaf"
version = "1.0"
description = "A Discord bot for the EinfachGustaf community"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.github.cdimascio:dotenv-kotlin:6.5.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.1")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.8.0-RC")
    implementation("org.mongodb:mongodb-driver-kotlin-coroutine:5.2.1")
    implementation("org.slf4j:slf4j-simple:2.0.16")
    implementation("io.github.oshai:kotlin-logging-jvm:7.0.0")
    implementation("dev.kord:kord-core:0.15.0")
}

kotlin {
    jvmToolchain(21)
}


kordEx {
    bot {
        dataCollection(DataCollection.None)

        mainClass = "live.einfachgustaf.sharkbot.EntrypointKt"
    }
}

docker {
    file(rootProject.file("Dockerfile"))

    commands {
        from("openjdk:21-jdk-slim")
        emptyLine()
        runShell("mkdir -p /bot/plugins")
        emptyLine()
        copy("build/libs/sharkbot.jar", "/bot/sharkbot.jar")
        emptyLine()
        volume("/bot/plugins")
        emptyLine()
        workdir("/bot")
        emptyLine()
        entryPointExec(
            "java", "-Xmx1G",
            "-jar", "/bot/sharkbot.jar"
        )
    }
}

tasks {
    withType<Jar> {
        archiveFileName.set("sharkbot.jar")
    }
}