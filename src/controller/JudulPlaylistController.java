package controller;

import model.JudulPlaylistModel;
import service.DBService;
import util.LinkedListJP;

public class JudulPlaylistController {

<<<<<<< HEAD
    private static DBService service;
    private static LinkedListJP linkedListJP = new LinkedListJP();
    private static PlaylistController playlistController = new PlaylistController(service);

    public JudulPlaylistController(DBService service) {
        this.service = service;
        getJudulPlaylist();
    }
    
=======
    private static DBService service = new DBService();
    private static LinkedListJP linkedListJP = new LinkedListJP();
    private static PlaylistController playlistController = new PlaylistController();

>>>>>>> 4666e00061e5a1db7bb5f4578b7c57089f25b5aa
    public static void getJudulPlaylist() {
        linkedListJP = service.getJudulPlaylistService();
    }

    public static void displayAllJudulPlaylist() {
        linkedListJP.displayList();
    }

    public static void insertJudulPlaylist(String namaPlaylist) {
        JudulPlaylistModel judulPlaylistModel = new JudulPlaylistModel(peekLastID(), namaPlaylist);
        linkedListJP.insertLast(judulPlaylistModel);
        service.addJudulPlaylistService(linkedListJP.peekLast().getIDJudulPlaylist(), linkedListJP.peekLast().getNamaPlaylist());
        playlistController.getPlaylist();
    }
    
    public static String peekLastID(){
        String IDJudulPlaylist = linkedListJP.peekLast().getIDJudulPlaylist();
        int intID = Integer.parseInt(IDJudulPlaylist.substring(3)) + 1;
        return generateID(intID);
    }

    public static String generateID(int intID) {
        String IDJudulPlaylist;
        if (intID < 10) {
            IDJudulPlaylist = "J00" + intID;
        } else if (intID < 100) {
            IDJudulPlaylist = "J0" + intID;
        } else {
            IDJudulPlaylist = "J" + intID;
        }
        return IDJudulPlaylist;
    }
    
    public static JudulPlaylistModel find(String IDJudulPlaylist){
        return linkedListJP.find(IDJudulPlaylist);
    }
    
    public static void delete(String IDJudulPlaylist){        
        JudulPlaylistModel judulPlaylistModel = new JudulPlaylistModel(find(IDJudulPlaylist).getIDJudulPlaylist(), find(IDJudulPlaylist).getNamaPlaylist());
        if ( judulPlaylistModel != null) {
            linkedListJP.delete(IDJudulPlaylist);
            service.deleteJudulPlaylistService(IDJudulPlaylist);
        } 
    }

    public static void main(String[] args) {
        getJudulPlaylist();
        displayAllJudulPlaylist();
        delete("J006");
        displayAllJudulPlaylist();
    }
}
