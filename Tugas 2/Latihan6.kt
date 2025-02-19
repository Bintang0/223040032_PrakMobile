fun main() {
    val greet = { name: String -> greeting(name)}
    greeting("Kotlin")
}

fun greeting(name: String) {
    println("Halo $name")
}