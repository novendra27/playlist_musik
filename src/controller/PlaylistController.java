package controller;

import model.PlaylistModel;
import service.DBService;
import util.HashTable;

public class PlaylistController {

    private static DBService service = new DBService();
    private static HashTable hashTable = new HashTable(service.getSizePlaylistService());

    public static void getPlaylist() {
        hashTable = service.getPlaylistService();
        if (hashTable != null) {
            System.out.println("Berhasil menambahkan playlist ke hash table");
        } else {
            System.out.println("Gagal menambahkan playlist ke hash table");
        }
    }

    public static void displayPlaylist() {
        hashTable.displayTable();
    }

    public static void insertPlaylist(String IDJudulPlaylist, String IDMusik) {
        PlaylistModel playlistModel = new PlaylistModel(generateID(), IDJudulPlaylist, IDMusik);
        getPlaylist();
        hashTable.insert(playlistModel);
        service.addPlaylistService(generateID(), IDJudulPlaylist, IDMusik);
    }

    public static String generateID() {
        String IDPlaylist = hashTable.peekLast().getIDPlaylist();
        int intID = Integer.parseInt(IDPlaylist.substring(3)) + 1;
        if (intID < 10) {
            IDPlaylist = "P00" + intID;
        } else if (intID < 100) {
            IDPlaylist = "P0" + intID;
        } else {
            IDPlaylist = "P" + intID;
        }
        System.out.println(IDPlaylist);
        return IDPlaylist;
    }

    public static void main(String[] args) {
        getPlaylist();
        displayPlaylist();
    }
}
