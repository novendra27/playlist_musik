package controller;

import model.PlaylistModel;
import service.DBService;
import util.HashTable;

public class PlaylistController {

    private static DBService service = new DBService();
    private static HashTable hashTable = new HashTable(service.getSizePlaylistService());
    private static JudulPlaylistController JPController = new JudulPlaylistController();
    private static MusikController musikController = new MusikController();

    public static void getPlaylist() {
        hashTable = service.getPlaylistService();
    }

    public static void displayAllPlaylist() {
        hashTable.displayTable();
    }
    
    public static void displayPlaylist(String IDJudulPlaylist) {
        JPController.getJudulPlaylist();
        hashTable.displayTable(IDJudulPlaylist, JPController.find(IDJudulPlaylist).getNamaPlaylist());
    }

    public static void insertPlaylist(String IDJudulPlaylist, String IDMusik) {
        String IDPlaylist = generateID();
        PlaylistModel playlistModel = new PlaylistModel(IDPlaylist, IDJudulPlaylist, IDMusik, musikController.find(IDMusik).getJudulMusic());
        getPlaylist();
        hashTable.insert(playlistModel);
        service.addPlaylistService(IDPlaylist, IDJudulPlaylist, IDMusik);
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
        return IDPlaylist;
    }

    public static void main(String[] args) {
        getPlaylist();
        musikController.getMusik();
        insertPlaylist("J001", "M003");
        insertPlaylist("J005", "M004");
        insertPlaylist("J003", "M002");
        displayAllPlaylist();
//        displayPlaylist("J001");
    }
}
