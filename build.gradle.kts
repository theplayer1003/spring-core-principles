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
    implementation("org.springframework:spring-context:6.1.4")
    //implementation("org.springframework:boot:spring-boot-starter-aop:3.2.3")
    implementation("org.aspectj:aspectjweaver:1.9.22")
    implementation("org.springframework.boot:spring-boot-starter-web:3.2.3")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    testImplementation("org.assertj:assertj-core:$assertjversion")
}

tasks.test {
    useJUnitPlatform()
}