package controller;

import service.DBService;
import util.LinkedListJP;

public class JudulPlaylistController {
    
    private static DBService service = new DBService();
    private static LinkedListJP linkedListJP = new LinkedListJP(); 
    
    public static void getJudulPlaylist() {
        linkedListJP = service.getJudulPlaylistService();
        if (linkedListJP != null) {
            System.out.println("Berhasil menambahkan judul playlist ke array");
            linkedListJP.displayList();
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
        getJudulPlaylist();
    }
}
