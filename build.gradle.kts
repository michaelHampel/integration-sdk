plugins {
    java
}

subprojects {
    apply(plugin = "java")
    apply(plugin = "application")

    repositories {
        mavenLocal()
        mavenCentral()
    }

    dependencies {
        implementation("dev.restate:sdk-api:2.7.0-SNAPSHOT")
        implementation("dev.restate:sdk-http-vertx:2.7.0-SNAPSHOT")
        implementation("dev.restate:sdk-serde-jackson:2.7.0-SNAPSHOT")
        implementation("org.slf4j:slf4j-simple:2.0.12")
    }

    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(21))
        }
    }
}
