plugins {
    java
    `java-library`
    application
}

application {
    mainClass.set("cci.s1.p4.Program")
    applicationDefaultJvmArgs = listOf("-enableassertions")
}