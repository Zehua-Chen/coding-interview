plugins {
    java
    `java-library`
    application
}

application {
    mainClass.set("leetcode.p0037.Program")
    applicationDefaultJvmArgs = listOf("-enableassertions")
}