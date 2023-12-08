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
        PlaylistModel playlistModel = new PlaylistModel(peekLastID(), IDJudulPlaylist, IDMusik, musikController.find(IDMusik).getJudulMusic());
        getPlaylist();
        hashTable.insert(playlistModel);
        service.addPlaylistService(hashTable.peekLast().getIDPlaylist(), hashTable.peekLast().getIDJudulPlaylist(), hashTable.peekLast().getIDMusik());
    }
 
    public static String peekLastID(){
        String IDPlaylist = hashTable.peekLast().getIDPlaylist();
        int intID = Integer.parseInt(IDPlaylist.substring(3)) + 1;
        return generateID(intID);
    }
    
    public static String generateID(int intID) {
        String IDPlaylist;
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
        displayAllPlaylist();
    }
}
