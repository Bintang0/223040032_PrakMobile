class IndeksNilaiMatkul(val nilai: Int) {
    fun hitungIndeks(): String {
        return when (nilai) {
            in 80..100 -> "A"
            in 70..79 -> "AB"
            in 60..69 -> "B"
            in 50..59 -> "BC"
            in 40..49 -> "C"
            in 30..39 -> "D"
            in 0..29 -> "E"
            else -> "Nilai di luar jangkauan"
        }
    }
}

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        println("Silakan masukkan nilai sebagai argument.")
        return
    }

    for (arg in args) {
        try {
            val input = arg.toInt()
            if (input < 0 || input > 100) {
                println("Input: $input, Output: Nilai di luar jangkauan")
            } else {
                val indeks = IndeksNilaiMatkul(input)
                println("Input: $input, Output: ${indeks.hitungIndeks()}")
            }
        } catch (e: NumberFormatException) {
            println("Input: $arg, Output: Nilai harus diisi")
        }
    }
}
