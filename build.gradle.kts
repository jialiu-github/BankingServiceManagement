plugins {
    java
    id("org.springframework.boot") version "2.7.10"
    id("io.spring.dependency-management") version "1.0.15.RELEASE"
    kotlin("jvm")
}

group = "cc.unitmesh.untitled"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.json:json:20231013")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.12.5")

    testImplementation("junit:junit:4.13.1")

    developmentOnly("org.springframework.boot:spring-boot-devtools")

    implementation("org.flywaydb:flyway-core")

    implementation("io.swagger:swagger-annotations:1.6.11")
    compileOnly("org.projectlombok:lombok:1.18.28")
    annotationProcessor("org.projectlombok:lombok:1.18.22")
    // h2
    implementation("com.h2database:h2")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    implementation(kotlin("stdlib-jdk8"))
}

tasks.withType<Test> {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(11)
}