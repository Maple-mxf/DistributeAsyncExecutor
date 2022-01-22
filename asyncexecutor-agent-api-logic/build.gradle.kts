plugins {
    java
}

group = "io.asyncexecutor.agent.api.logic"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    testCompile("junit", "junit", "4.12")
    implementation(group = "com.google.guava", name = "guava", version = "29.0-jre")
    implementation(project(":asyncexecutor-context"))
    implementation(project(":asyncexecutor-agent-api"))
}
