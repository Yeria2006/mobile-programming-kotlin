/**
 * Sistem Nilai Mahasiswa
 *
 * Mengolah data nilai mentah beberapa mahasiswa: mengonversi nilai ujian
 * dari String ke angka, menghitung rata-rata dan status kelulusan (KKM),
 * menentukan grade huruf, lalu mencetak laporan per mahasiswa dan
 * ringkasan akhir.
 *
 * Author: Yeria Yedija Juwita Sari Bunga
 */

fun main() {

    val namaKelas: String = "Mobile Programming - IBDA"
    var semester: Int = 5

    println("=== SISTEM NILAI MAHASISWA ===")
    println("Kelas: $namaKelas | Semester: $semester")
    println("==============================================")
    println()

    // Nilai ujian disimpan sebagai String untuk mensimulasikan input mentah
    // yang belum tentu valid (kosong atau bukan angka) — divalidasi saat konversi.
    val namaMahasiswa = mutableListOf("Yeria", "Josep", "Citra", "Sera", "Jordan")

    val nilaiMentah = mutableListOf(
        listOf("95", "100", "98"),
        listOf("60", "abc", "70"),
        listOf("", "88", "92"),
        listOf("95", "80", "90"),
        listOf("50", "40", "abc")
    )

    val catatanMahasiswa: MutableList<String?> = mutableListOf(
        "Aktif organisasi",
        null,
        "Izin sakit minggu ke-3",
        null,
        "Perlu bimbingan tambahan"
    )

    val semuaGrade = mutableListOf<String>()
    var jumlahLulusKKM = 0

    for ((i, nama) in namaMahasiswa.withIndex()) {
        val nilaiAngka = mutableListOf<Int>()
        var semuaValid = true

        // Nilai yang gagal dikonversi (kosong / bukan angka) dianggap 0
        // dan ditandai tidak valid, tanpa menghentikan program.
        for (n in nilaiMentah[i]) {
            try {
                nilaiAngka.add(n.toInt())
            } catch (e: NumberFormatException) {
                println("Peringatan: nilai '$n' milik $nama tidak valid, dianggap 0")
                nilaiAngka.add(0)
                semuaValid = false
            }
        }

        // Lulus KKM hanya jika rata-rata memenuhi syarat DAN semua nilainya valid
        // (bukan hasil "penyelamatan" dari nilai kosong/rusak).
        val rataRata = nilaiAngka.sum() / nilaiAngka.size.toDouble()
        val lulusKKM = rataRata >= 70 && semuaValid

        val catatanTampil = catatanMahasiswa[i] ?: "(tanpa catatan)"

        val grade = when {
            rataRata >= 85 -> "A"
            rataRata >= 70 -> "B"
            rataRata >= 55 -> "C"
            else -> "D"
        }

        semuaGrade.add(grade)
        if (lulusKKM) jumlahLulusKKM++

        println("Nama       : $nama")
        println("Nilai      : $nilaiAngka")
        println("Rata-rata  : %.2f".format(rataRata))
        println("Status KKM : ${if (lulusKKM) "Lulus" else "Tidak Lulus"}")
        println("Grade      : $grade")
        println("Catatan    : $catatanTampil")
        println("--------------------------------")
    }

    val gradeUnik = semuaGrade.toSet()

    val jumlahPerGrade = mutableMapOf<String, Int>()
    for (g in semuaGrade) {
        jumlahPerGrade[g] = (jumlahPerGrade[g] ?: 0) + 1
    }

    println()
    println("=== RINGKASAN AKHIR ===")
    println("Grade yang muncul : $gradeUnik")
    println("Jumlah per grade  :")
    for ((g, jumlah) in jumlahPerGrade) {
        println("  $g -> $jumlah mahasiswa")
    }
    println("Total lulus KKM   : $jumlahLulusKKM dari ${namaMahasiswa.size} mahasiswa")
}
