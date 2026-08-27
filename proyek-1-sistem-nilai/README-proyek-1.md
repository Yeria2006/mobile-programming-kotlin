# Sistem Nilai Mahasiswa

Program konsol Kotlin yang mengolah data nilai beberapa mahasiswa: menerima nilai mentah (String), mengonversinya ke angka, menghitung rata-rata dan status kelulusan KKM, menentukan grade huruf, lalu mencetak laporan per mahasiswa dan ringkasan akhir.

## Fitur

- Validasi input nilai yang tidak berupa angka, tanpa menghentikan program
- Perhitungan rata-rata dan status kelulusan (KKM ≥ 70)
- Penentuan grade huruf (A/B/C/D) berdasarkan rata-rata
- Penanganan data opsional (catatan mahasiswa) yang boleh kosong
- Ringkasan akhir: daftar grade unik dan jumlah mahasiswa per grade

## Konsep yang digunakan

- Variabel (`val`/`var`) dan tipe data
- Operator aritmatika, perbandingan, dan logika
- Konversi tipe data (`String` ke `Int`)
- Exception handling (`try-catch`)
- Nullable type dan Elvis operator (`?:`)
- Collections: `List`, `MutableList`, `Set`, `Map`
- Percabangan (`when`) dan perulangan (`for`)

## Cara menjalankan

1. Copy isi `Project1.kt`
2. Paste ke [play.kotlinlang.org](https://play.kotlinlang.org)
3. Klik Run
