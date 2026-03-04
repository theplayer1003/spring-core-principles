plugins {
    id("java")
}

group = "myproject"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val assertjversion = "3.27.7";

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    testImplementation("org.assertj:assertj-core:$assertjversion")
}

tasks.test {
    useJUnitPlatform()
}