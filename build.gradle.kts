import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import org.jetbrains.kotlin.utils.addToStdlib.ifTrue

plugins {
    id("java")
    kotlin("jvm")
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

kotlin {
    jvmToolchain(17)
}

group = "cc.mcyx.arona"
version = "1.0"

val aronaVersion = "1.0.0"
val arona = "cc.mcyx:Arona"

fun aronaModule(modelName: String, version: String = aronaVersion): String {
    return "cc.mcyx:${modelName}:${version}"
}

repositories {
    mavenCentral()
    mavenLocal()
    maven("https://repo.papermc.io/repository/maven-public/")
}
val inAronaModule = listOf(
    aronaModule("Arona"),
    aronaModule("Arona-GUI"),
    aronaModule("Arona-NMS"),
)
dependencies {
    inAronaModule.forEach { implementation(it) }
    compileOnly("io.papermc.paper:paper-api:1.20.1-R0.1-SNAPSHOT")
}


val fastDev = true
val devDir = "E:\\Desktop\\Desktop\\MinecraftServers\\spigot1.20.1\\plugins"
tasks.withType<ShadowJar> {
    dependencies { inAronaModule.forEach { include(dependency(it)) } }
    doLast {
        fastDev.ifTrue {
            archiveFile.get().asFile.also {
                it.renameTo(File(devDir, it.name).apply { delete() })
            }
        }
    }
}