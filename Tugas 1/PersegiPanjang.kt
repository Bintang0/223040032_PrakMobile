class PersegiPanjang(val panjang: Int, val lebar: Int) {
    // Properti untuk menghitung luas
    val luas: Int
        get() = panjang * lebar

    // Properti untuk menghitung keliling
    val keliling: Int
        get() = 2 * (panjang + lebar)
}

fun main(args: Array<String>) {
    // Validasi jumlah argumen
    if (args.size < 2) {
        println("Program membutuhkan 2 argumen: panjang dan lebar")
        return
    }

    // Deklarasi variabel dan parsing argumen
    val panjang = args[0].toInt()
    val lebar = args[1].toInt()

    // Pembuatan objek PersegiPanjang
    val persegi = PersegiPanjang(panjang, lebar)

    // Output hasil
    println("Panjang: $panjang")
    println("Lebar: $lebar")
    println("Luas: ${persegi.luas}")
    println("Keliling: ${persegi.keliling}")
}
