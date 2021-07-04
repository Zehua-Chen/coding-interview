fun includeDir(dir: String) {
    val subProjects = File(dir).listFiles() ?: return

    for (subProject in subProjects) {
        if (File(subProject.path, "build.gradle.kts").exists()) {
            include("${dir}:${subProject.name}")
        }
    }
}

include("utils")

includeDir("general")
includeDir("greedy")
includeDir("strings-arrays")
includeDir("linked-lists")
includeDir("recursion-dp")
