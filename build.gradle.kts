plugins {
    val kotlinVersion = "2.1.0"

    kotlin("jvm") version kotlinVersion
    kotlin("plugin.serialization") version kotlinVersion
    // id("dev.kordex.gradle.kordex") version "1.5.8"
}

group = "live.einfachgustaf"
version = "1.0"
description = "A Discord bot for the EinfachGustaf community"

repositories {
    mavenCentral()

    maven {
        name = "KordEx (Releases)"
        url = uri("https://repo.kordex.dev/releases")
    }

    maven {
        name = "KordEx (Snapshots)"
        url = uri("https://repo.kordex.dev/snapshots")
    }

    maven {
        name = "Sonatype Snapshots (Legacy)"
        url = uri("https://oss.sonatype.org/content/repositories/snapshots")
    }
}

dependencies {
    implementation("io.github.cdimascio:dotenv-kotlin:6.5.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.1")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.8.0-RC")
    implementation("org.mongodb:mongodb-driver-kotlin-coroutine:5.2.1")
    implementation("org.slf4j:slf4j-simple:2.0.16")
    implementation("io.github.oshai:kotlin-logging-jvm:7.0.0")
    implementation("dev.kord:kord-core:0.15.0")
    implementation("dev.kordex:kord-extensions:2.3.1-SNAPSHOT") // TODO: remove when plugin is working
}

kotlin {
    jvmToolchain(21)
}

/*
kordEx {
    bot {
        dataCollection(DataCollection.Standard)

        mainClass = "live.einfachgustaf.sharkbot.EntrypointKt"
    }
}
 */