plugins {
    java
    `java-library`
    application
}

application {
    mainClass.set("cci.s1.p5.Program")
    applicationDefaultJvmArgs = listOf("-enableassertions")
}