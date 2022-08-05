plugins {
    id("java")
    id("org.jetbrains.intellij") version "1.7.0"
}

group = "com.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

// 添加的依赖
dependencies {
    // https://mvnrepository.com/artifact/org.jdom/jdom2
    implementation("org.jdom:jdom2:2.0.6.1")
    // https://mvnrepository.com/artifact/org.springframework/spring-web
    implementation("org.springframework:spring-web:5.3.22")
    implementation("org.springframework:spring-core:5.3.22")
    implementation("org.springframework:spring-beans:5.3.22")



}
// Configure Gradle IntelliJ Plugin
// Read more: https://plugins.jetbrains.com/docs/intellij/tools-gradle-intellij-plugin.html
intellij {
    version.set("2022.2")
    type.set("IC") // Target IDE Platform

    plugins.set(listOf(/* Plugin Dependencies */))
}

tasks {
    // Set the JVM compatibility versions
    withType<JavaCompile> {
        sourceCompatibility = "17"
        targetCompatibility = "17"
    }

    patchPluginXml {
        sinceBuild.set("213")
        untilBuild.set("223.*")
    }

    signPlugin {
        certificateChain.set(System.getenv("CERTIFICATE_CHAIN"))
        privateKey.set(System.getenv("PRIVATE_KEY"))
        password.set(System.getenv("PRIVATE_KEY_PASSWORD"))
    }

    publishPlugin {
        token.set(System.getenv("PUBLISH_TOKEN"))
    }
}
