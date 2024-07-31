plugins {
    kotlin("jvm")
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

kotlin { jvmToolchain(17) }

tasks{
    shadowJar {
        manifest {
            attributes["Main-Class"] = "GameClientDesktop.src.main.kotlin.gigcreator.game.desktop.MainKt"
        }
    }
}

dependencies {
    api(project(":GameClient"))

    api("com.badlogicgames.gdx:gdx-box2d-platform:1.12.1:natives-desktop")
    api("com.badlogicgames.gdx:gdx-freetype-platform:1.12.1:natives-desktop")
    api("com.badlogicgames.gdx:gdx-platform:1.12.1:natives-desktop")
    api("com.badlogicgames.gdx:gdx-backend-lwjgl3:1.12.1")

    testImplementation(kotlin("test"))
}