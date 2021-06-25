plugins {
    java
    `java-library`
    application
}

application {
    mainClass.set("cci.s1.p6.Program")
    applicationDefaultJvmArgs = listOf("-enableassertions")
}