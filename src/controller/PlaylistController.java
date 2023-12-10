package controller;

import model.PlaylistModel;
import service.DBService;
import util.HashTable;

public class PlaylistController {

    private static DBService service;
    private static HashTable hashTable = new HashTable(service.getSizePlaylistService());
    private static JudulPlaylistController JPController = new JudulPlaylistController(service);
    private static MusikController musikController = new MusikController(service);

    public PlaylistController(DBService service) {
        this.service = service;
        getPlaylist();
    }
    
    public static void getPlaylist() {
        hashTable = service.getPlaylistService();
    }

    public static void displayAllPlaylist() {
        hashTable.displayTable();
    }

    //Display satu playlist sesuai parameter
    public static void displayPlaylist(String IDJudulPlaylist) {
        JPController.getJudulPlaylist();
        hashTable.displayTable(IDJudulPlaylist, JPController.find(IDJudulPlaylist).getNamaPlaylist());
    }
    
    // Menambah musik ke playlist
    public static void insertMusicToPlaylist(String IDJudulPlaylist, String IDMusik) {
        PlaylistModel playlistModel = new PlaylistModel(peekLastID(), IDJudulPlaylist, JPController.find(IDJudulPlaylist).getNamaPlaylist(), IDMusik, musikController.find(IDMusik).getJudulMusic());
        hashTable.insert(playlistModel);
        service.addPlaylistService(hashTable.peekLast().getIDPlaylist(), hashTable.peekLast().getIDJudulPlaylist(), hashTable.peekLast().getIDMusik());
    }

    public static String peekLastID() {
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

    public static void play(String IDJudulPlaylist, String IDMusik) {
        hashTable.play(IDJudulPlaylist, IDMusik);
    }

    public static void playNext(String IDJudulPlaylist, String IDMusik) {
        hashTable.playNext(IDJudulPlaylist, IDMusik);
    }

    public static void playPrev(String IDJudulPlaylist, String IDMusik) {
        hashTable.playPrev(IDJudulPlaylist, IDMusik);
    }
    
    //Mencari playlistModel
    public static PlaylistModel find(String IDPlaylist, String IDJudulPlaylist){
        return hashTable.find(IDPlaylist, IDJudulPlaylist);
    }
    
    // Menghapus musik dari playlist
    public static void removeMusicFromPlaylist(String IDPlaylist, String IDJudulPlaylist){
        String IDPlaylistChecked = find(IDPlaylist, IDJudulPlaylist).getIDPlaylist();
        String IDJudulPlaylistChecked = find(IDPlaylist, IDJudulPlaylist).getIDJudulPlaylist();
        if ( IDPlaylistChecked != null && IDJudulPlaylistChecked != null) {
            hashTable.delete(IDPlaylist, IDJudulPlaylist);
            service.deletePlaylistService(IDPlaylist);
        } 
    }

    public static void main(String[] args) {
        getPlaylist();
        musikController.getMusik();
        JPController.getJudulPlaylist();
        displayAllPlaylist();
        System.out.println("=========");
        displayPlaylist("J001");
    }
}
