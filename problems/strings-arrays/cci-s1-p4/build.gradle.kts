plugins {
    java
    `java-library`
    application
}

dependencies {
    api(project(":utils"))
}

application {
    mainClass.set("cci.s1.p4.Program")
    applicationDefaultJvmArgs = listOf("-enableassertions")
}