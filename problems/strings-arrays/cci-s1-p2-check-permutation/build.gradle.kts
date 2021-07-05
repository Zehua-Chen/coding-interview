plugins {
    java
    application
}

application {
    mainClass.set("cci.s1.p2.Program")
    applicationDefaultJvmArgs = listOf("-enableassertions")
}