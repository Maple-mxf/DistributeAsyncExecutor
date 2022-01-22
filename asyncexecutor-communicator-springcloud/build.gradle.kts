plugins {
    java
    id("org.springframework.boot") version "2.4.4"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
}

group = "io.asyncexecutor"
version = "1.0"
java.sourceCompatibility = JavaVersion.VERSION_1_8

extra["springCloudVersion"] = "2021.0.0"

repositories {
    mavenCentral()
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
    }
}

dependencies {
    testCompile("junit", "junit", "4.12")
}
