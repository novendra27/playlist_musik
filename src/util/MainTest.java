package util;

import model.PlaylistModel;

public class MainTest {

    public static void main(String[] args) {
        // Membuat objek HashTable dengan ukuran 10
        HashTable hashTable = new HashTable(10);

        // Menambahkan beberapa data ke dalam HashTable
        PlaylistModel playlist1 = new PlaylistModel("P001", "M001");
        PlaylistModel playlist2 = new PlaylistModel("P002", "M002");
        PlaylistModel playlist3 = new PlaylistModel("P003", "M003");

        hashTable.insert(playlist1);
        hashTable.insert(playlist2);
        hashTable.insert(playlist3);

        // Menampilkan isi HashTable
        hashTable.displayTable();

        // Mencari dan menampilkan data berdasarkan IDPlaylist
        String searchIDPlaylist = "P002";
        CircularLink foundLink = hashTable.find(searchIDPlaylist);

        if (foundLink != null) {
            System.out.println("Playlist found: ");
            foundLink.displayLink();
        } else {
            System.out.println("Playlist not found.");
        }

        // Menghapus data berdasarkan IDPlaylist
        String deleteIDPlaylist = "P001";
        hashTable.delete(deleteIDPlaylist);

        // Menampilkan isi HashTable setelah penghapusan
        hashTable.displayTable();
    }
}
