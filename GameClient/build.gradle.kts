plugins {
    kotlin("jvm")
}

kotlin { jvmToolchain(17) }

dependencies {
    api("com.badlogicgames.gdx:gdx-freetype:1.12.1")
    api("com.badlogicgames.gdx:gdx-box2d:1.12.1")
    api("com.badlogicgames.gdx:gdx:1.12.1")

    api("com.fasterxml.jackson.module:jackson-module-kotlin:2.15.0")
    api("com.esotericsoftware:kryo:5.4.0")

    testImplementation(kotlin("test"))
}