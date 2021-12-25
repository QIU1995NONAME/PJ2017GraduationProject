fun ktor(id: String, version: String = Versions.Kotlin.ktor) =
    "io.ktor:ktor-$id:$version"

fun kotlinx(id: String, version: String = "+") =
    "org.jetbrains.kotlinx:kotlinx-$id:$version"

