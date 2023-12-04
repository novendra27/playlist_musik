package controller;

import service.DBService;
import util.HashTable;

public class Controller {
    
    private static DBService service = new DBService();
    private static HashTable hashTable = new HashTable(service.getSizePlaylistService());
    
    public static void getPlaylist() {
        hashTable = service.getPlaylistService();
        if (hashTable != null) {
            System.out.println("Berhasil menambahkan playlist ke hash table");
            hashTable.displayTable();
        } else {
            System.out.println("Gagal menambahkan playlist ke hash table");
        }
    }
    
    public static void main(String[] args) {
        getPlaylist();
    }
}
