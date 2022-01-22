plugins {
    java
    id("org.springframework.boot") version "2.4.4"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
}

group = "io.asyncexecutor.agent.springcloud"
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

    implementation(project(":asyncexecutor-context"))
    implementation(project(":asyncexecutor-agent-api"))
    implementation(project(":asyncexecutor-agent-api-logic"))

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.cloud:spring-cloud-starter-gateway")
    implementation("org.springframework.cloud:spring-cloud-starter-openfeig")

    testImplementation("junit", "junit", "4.12")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

}


