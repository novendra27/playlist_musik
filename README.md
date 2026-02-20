# Playify - Aplikasi Playlist Musik

## Deskripsi Aplikasi

**Playify** adalah aplikasi manajemen playlist musik berbasis konsol yang dibangun menggunakan Java dengan penerapan struktur data **Hash Table Separate Chaining (Circular Doubly Linked-List)**. Aplikasi ini memungkinkan pengguna untuk membuat, mengelola, dan memutar playlist musik layaknya aplikasi streaming musik seperti Spotify.

### Fokus Struktur Data

Aplikasi ini dibangun dengan fokus pada implementasi struktur data:
- **Hash Table dengan Separate Chaining**: Menggunakan Circular Doubly Linked-List untuk menangani collision
- **Circular Doubly Linked-List**: Memungkinkan navigasi bidirectional (Next/Previous) dan pemutaran berulang otomatis
- **Sorted Circular Linked-List**: Untuk pengurutan data playlist secara otomatis

### Fitur Utama

1. **Manajemen Playlist**
   - Membuat playlist baru
   - Menampilkan daftar semua playlist
   - Menghapus playlist

2. **Manajemen Musik**
   - Menambah musik baru (judul dan artis)
   - Menampilkan daftar semua musik
   - Menghapus musik

3. **Manajemen Isi Playlist**
   - Menambah musik ke dalam playlist tertentu
   - Menghapus musik dari playlist
   - Menampilkan isi playlist

4. **Pemutar Musik**
   - Memutar playlist
   - Navigasi lagu (Next/Previous)
   - Stop pemutaran

### Arsitektur Aplikasi

Aplikasi ini dibangun menggunakan pola arsitektur **MVC (Model-View-Controller)**:

- **Model**: Merepresentasikan data (Playlist, Musik, Judul Playlist)
- **View**: Menangani tampilan dan interaksi dengan pengguna (AppView)
- **Controller**: Mengatur logika bisnis dan komunikasi antara Model dan View
- **Repository**: Mengelola koneksi dan operasi database
- **Service**: Layer tambahan untuk mengelola logika bisnis
- **Util**: Struktur data custom (Hash Table, Circular Linked List, Sorted Circular Linked List)

### Struktur Data yang Digunakan

#### 1. Hash Table dengan Separate Chaining
- **Implementasi**: Menggunakan array of Sorted Circular Doubly Linked-List
- **Fungsi Hash**: `hashFunc(IDJudulPlaylist)` - menggunakan substring ID untuk menghitung index
- **Collision Handling**: Separate Chaining - setiap bucket berisi Circular Doubly Linked-List
- **Kegunaan**: Menyimpan dan mengorganisir playlist berdasarkan ID Judul Playlist dengan akses O(1)

#### 2. Circular Doubly Linked-List
- **Karakteristik**: 
  - Node memiliki pointer `next` dan `prev`
  - Node terakhir menunjuk kembali ke node pertama (circular)
  - Node pertama memiliki `prev` yang menunjuk ke node terakhir
- **Kegunaan**: 
  - Menyimpan daftar musik dalam setiap playlist
  - Memungkinkan navigasi bidirectional (Next/Previous saat memutar musik)
  - Pemutaran berulang otomatis (looping playlist)

#### 3. Sorted Circular Linked-List
- **Kegunaan**: Mengurutkan data playlist secara otomatis berdasarkan ID saat insert
- **Implementasi**: Setiap bucket di Hash Table menggunakan Sorted Circular Linked-List

#### 4. Linked List (Single)
- **Kegunaan**: Menyimpan daftar musik dan judul playlist di memori
- **Implementasi**: LinkedListMusik dan LinkedListJP

### Teknologi yang Digunakan

- **Java** (JDK 8 atau lebih tinggi)
- **MySQL** Database
- **JDBC** (Java Database Connectivity)
- **NetBeans** IDE (Opsional)

---

## Cara Install dan Menjalankan Aplikasi

### Prasyarat

Sebelum menjalankan aplikasi, pastikan Anda telah menginstall:

1. **Java Development Kit (JDK)** versi 8 atau lebih tinggi
   - Download di: https://www.oracle.com/java/technologies/downloads/
   - Verifikasi instalasi dengan perintah: `java -version`

2. **MySQL Server**
   - Download di: https://dev.mysql.com/downloads/mysql/
   - Atau install via XAMPP: https://www.apachefriends.org/

3. **MySQL JDBC Driver (Connector/J)**
   - Driver sudah harus ada di classpath project
   - Jika belum, download di: https://dev.mysql.com/downloads/connector/j/

### Langkah-langkah Instalasi

#### 1. Clone Project

```bash
git clone <url-repository>
cd playlist_musik
```

#### 2. Setup Database

**a. Buat Database Baru**

Buka MySQL client (phpMyAdmin atau MySQL Workbench) dan jalankan query berikut:

```sql
CREATE DATABASE playlist_musik;
USE playlist_musik;
```

**b. Buat Tabel-tabel**

```sql
-- Tabel Judul Playlist
CREATE TABLE tb_judul_playlist (
    id_judul_playlist VARCHAR(10) PRIMARY KEY,
    nama_playlist VARCHAR(100) NOT NULL
);

-- Tabel Musik
CREATE TABLE tb_musik (
    id_musik VARCHAR(10) PRIMARY KEY,
    judul_musik VARCHAR(100) NOT NULL,
    artis VARCHAR(100) NOT NULL
);

-- Tabel Playlist
CREATE TABLE tb_playlist (
    id_playlist VARCHAR(10) PRIMARY KEY,
    id_judul_playlist VARCHAR(10),
    id_musik VARCHAR(10),
    FOREIGN KEY (id_judul_playlist) REFERENCES tb_judul_playlist(id_judul_playlist) ON DELETE CASCADE,
    FOREIGN KEY (id_musik) REFERENCES tb_musik(id_musik) ON DELETE CASCADE
);
```

**c. Insert Data Awal (Opsional)**

```sql
-- Contoh data judul playlist
INSERT INTO tb_judul_playlist VALUES ('J001', 'Playlist Favorit');

-- Contoh data musik
INSERT INTO tb_musik VALUES ('M001', 'Selamat Jalan', 'Tulus');
INSERT INTO tb_musik VALUES ('M002', 'Pupus', 'Dewa 19');
INSERT INTO tb_musik VALUES ('M003', 'Menghitung Hari', 'Krisdayanti');
```

#### 3. Konfigurasi Koneksi Database

Buka file `src/repository/DBConnection.java` dan sesuaikan konfigurasi database:

```java
private static final String URL = "jdbc:mysql://localhost:3306/playlist_musik";
private static final String USER = "root"; // Sesuaikan dengan username MySQL Anda
private static final String PASSWORD = ""; // Sesuaikan dengan password MySQL Anda
```

#### 4. Kompilasi dan Jalankan Aplikasi

**Opsi A: Menggunakan NetBeans IDE**

1. Buka NetBeans IDE
2. Klik `File > Open Project`
3. Pilih folder `playlist_musik`
4. Klik kanan pada project > `Run`

**Opsi B: Menggunakan Command Line**

1. Pastikan MySQL JDBC Driver sudah ada di folder `lib/` atau tambahkan ke classpath

2. Kompilasi project:
```bash
javac -d build/classes -cp "lib/mysql-connector-java.jar" src/**/*.java
```

3. Jalankan aplikasi:
```bash
java -cp "build/classes;lib/mysql-connector-java.jar" main.Main
```

**Catatan untuk Windows:**
- Gunakan `;` sebagai pemisah classpath
- Contoh: `java -cp "build/classes;lib/mysql-connector-java.jar" main.Main`

**Catatan untuk Linux/Mac:**
- Gunakan `:` sebagai pemisah classpath
- Contoh: `java -cp "build/classes:lib/mysql-connector-java.jar" main.Main`

**Opsi C: Menggunakan Apache Ant (Jika tersedia)**

```bash
ant clean
ant compile
ant run
```

#### 5. Menggunakan Aplikasi

Setelah aplikasi berjalan, Anda akan melihat menu utama:

```
=========== Selamat Datang Di Playify ===========

Menu:
1. Buat Playlist
2. Daftar Playlist
3. Hapus Playlist
4. Tambah Musik
5. Daftar Musik
6. Hapus Musik
7. Keluar

Pilih Menu:
```

**Alur Penggunaan:**

1. **Tambah Musik** (Pilih menu 4)
   - Masukkan judul musik dan nama artis
   
2. **Buat Playlist** (Pilih menu 1)
   - Masukkan nama playlist

3. **Lihat Daftar Playlist** (Pilih menu 2)
   - Pilih submenu untuk:
     - Memutar playlist
     - Menambah musik ke playlist
     - Menghapus musik dari playlist

4. **Putar Playlist**
   - Pilih playlist yang ingin diputar
   - Gunakan kontrol:
     - `1` untuk Next (lagu berikutnya)
     - `2` untuk Previous (lagu sebelumnya)
     - `3` untuk Stop

---

## Troubleshooting

### Error: "Cannot connect to database"
- Pastikan MySQL server berjalan
- Periksa konfigurasi di `DBConnection.java`
- Pastikan database `playlist_musik` sudah dibuat

### Error: "ClassNotFoundException: com.mysql.jdbc.Driver"
- Pastikan MySQL JDBC Driver sudah ditambahkan ke classpath
- Download driver di: https://dev.mysql.com/downloads/connector/j/

### Error: "Table doesn't exist"
- Pastikan semua tabel sudah dibuat dengan menjalankan script SQL di atas
- Periksa nama database dan tabel sudah sesuai

### Aplikasi tidak mau compile
- Pastikan JDK sudah terinstall dengan benar
- Periksa JAVA_HOME environment variable
- Pastikan path ke javac sudah terdaftar di PATH

---

## Struktur Project

```
playlist_musik/
├── src/
│   ├── controller/          # Controller layer (MVC)
│   │   ├── JudulPlaylistController.java
│   │   ├── MusikController.java
│   │   └── PlaylistController.java
│   ├── main/                # Main entry point
│   │   └── Main.java
│   ├── model/               # Data models (MVC)
│   │   ├── JudulPlaylistModel.java
│   │   ├── MusikModel.java
│   │   └── PlaylistModel.java
│   ├── repository/          # Database layer
│   │   ├── DBConnection.java
│   │   └── DBManager.java
│   ├── service/             # Business logic layer
│   │   └── DBService.java
│   ├── util/                # Custom data structures
│   │   ├── CircularLink.java
│   │   ├── HashTable.java
│   │   ├── LinkedListJP.java
│   │   ├── LinkedListMusik.java
│   │   ├── NodeJP.java
│   │   ├── NodeMusik.java
│   │   └── SortedCircularLinkList.java
│   └── view/                # View layer (MVC)
│       └── AppView.java
├── build/                   # Compiled classes
├── nbproject/               # NetBeans project files
├── build.xml                # Ant build script
├── manifest.mf              # JAR manifest file
└── README.md                # Dokumentasi ini
```

## Catatan Tambahan

### Implementasi Struktur Data

**Hash Table Separate Chaining dengan Circular Doubly Linked-List:**
- **Array Size**: Ditentukan berdasarkan jumlah judul playlist di database
- **Hash Function**: Menggunakan ID playlist (substring angka) modulo size array
- **Collision Resolution**: Separate Chaining - setiap index array berisi Sorted Circular Doubly Linked-List
- **Kompleksitas**:
  - Insert: O(1) untuk hash, O(n) untuk sorting di linked-list
  - Search: O(1) untuk hash, O(n) untuk pencarian di linked-list
  - Delete: O(1) untuk hash, O(n) untuk pencarian dan penghapusan

**Circular Doubly Linked-List untuk Music Player:**
- Node memiliki pointer `next` dan `prev` untuk navigasi bidirectional
- Sifat circular memungkinkan playlist loop otomatis
- Mendukung operasi `playNext()` dan `playPrev()` dengan efisien

### Sistem Auto-Generated ID
- **Format ID**:
  - Judul Playlist: `J001`, `J002`, `J003`, ...
  - Musik: `M001`, `M002`, `M003`, ...
  - Playlist: `P001`, `P002`, `P003`, ...
- ID di-generate otomatis berdasarkan ID terakhir di database

### Fitur Khusus
- Pemutaran musik menggunakan Circular Doubly Linked-List sehingga:
  - Playlist berulang otomatis setelah lagu terakhir
  - Dapat navigasi maju (Next) dan mundur (Previous)
  - Tidak ada dead-end (selalu ada lagu berikutnya/sebelumnya)

---
