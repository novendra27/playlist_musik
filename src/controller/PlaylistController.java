package controller;

import service.DBService;
import util.ArrayJudulPlaylist;
import util.ArrayMusik;
import util.HashTable;
import util.LinkedListJP;

public class PlaylistController {
    
    private static DBService service = new DBService();
    private static HashTable hashTable = new HashTable(service.getSizePlaylistService());
    private static ArrayMusik arrayMusik = new ArrayMusik(service.getSizeMusikService());
    private static ArrayJudulPlaylist arrayJudulPlaylist = new ArrayJudulPlaylist(service.getSizeJudulPlaylistService());
    private static LinkedListJP linkedListJP = new LinkedListJP(); 
    
    public static void getPlaylist() {
        hashTable = service.getPlaylistService();
        if (hashTable != null) {
            System.out.println("Berhasil menambahkan playlist ke hash table");
            hashTable.displayTable();
        } else {
            System.out.println("Gagal menambahkan playlist ke hash table");
        }
    }
    
    public static void getMusik() {
        arrayMusik = service.getMusikService();
        if (arrayMusik != null) {
            System.out.println("Berhasil menambahkan musik ke array");
            arrayMusik.displayArray();
        } else {
            System.out.println("Gagal menambahkan musik ke array");
        }
    }
    
    public static void getJudulPlaylist() {
        arrayJudulPlaylist = service.getJudulPlaylistService();
        if (arrayJudulPlaylist != null) {
            System.out.println("Berhasil menambahkan judul playlist ke array");
            arrayJudulPlaylist.displayArray();
        } else {
            System.out.println("Gagal menambahkan judul playlist ke array");
        }
    }
    
    public static void insertJudulPlaylist(String namaPlaylist) {
        
    }
    
    public static String generateIDJP(String IDJudulPlaylist) {
        return IDJudulPlaylist = linkedListJP.findIDJudulPlaylist(IDJudulPlaylist);
    }
    
    public static void main(String[] args) {
        getPlaylist();
        getMusik();
        getJudulPlaylist();
    }
}
