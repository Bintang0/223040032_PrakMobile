class indeksNilaiMatkul(val nilai: Int) {
    fun hitungIndeks(): String {
        return when {
            nilai in 90..10 -> "A"
            nilai in 70..89 -> "B"
            nilai in 60..69 -> "C"
            nilai in 0..59 -> "D"
            else -> "Nilai diluar jangkauan"
        }
    }
}

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        println("Kosong Nilai harus diisi")
        return
    }

    val nilai: Int? = args[0].toIntOrNull()

    if (nilai == null) {
        println("Kosong Nilai harus diisi")
    } else {
        val indeksNilai = indeksNilaiMatkul(nilai)
        val hasil = indeksNilai.hitungIndeks()
        println("Input: $nilai")
        println("Output: $hasil")
    }
}