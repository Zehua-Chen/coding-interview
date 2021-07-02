plugins {
    java
    `java-library`
    application
}

dependencies {
    api(project(":utils"))
}

application {
    mainClass.set("cci.s2.p5.Program")
    applicationDefaultJvmArgs = listOf("-enableassertions")
}
