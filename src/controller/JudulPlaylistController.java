package controller;

import model.JudulPlaylistModel;
import service.DBService;
import util.LinkedListJP;

public class JudulPlaylistController {

    private static DBService service = new DBService();
    private static LinkedListJP linkedListJP = new LinkedListJP();

    public static void getJudulPlaylist() {
        linkedListJP = service.getJudulPlaylistService();
        if (linkedListJP != null) {
            System.out.println("Berhasil menambahkan judul playlist ke linked list");
        } else {
            System.out.println("Gagal menambahkan judul playlist ke linked list");
        }
    }

    public static void displayJudulPlaylist() {
        linkedListJP.displayList();
    }

    public static void insertJudulPlaylist(String namaPlaylist) {
        JudulPlaylistModel judulPlaylistModel = new JudulPlaylistModel(generateID(), namaPlaylist);
        linkedListJP.insertLast(judulPlaylistModel);
        service.addJudulPlaylistService(linkedListJP.peekLast().getIDJudulPlaylist(), linkedListJP.peekLast().getNamaPlaylist());
    }

    public static String generateID() {
        String IDJudulPlaylist = linkedListJP.peekLast().getIDJudulPlaylist();
        int intID = Integer.parseInt(IDJudulPlaylist.substring(3)) + 1;
        if (intID < 10) {
            IDJudulPlaylist = "J00" + intID;
        } else if (intID < 100) {
            IDJudulPlaylist = "J0" + intID;
        } else {
            IDJudulPlaylist = "J" + intID;
        }
        return IDJudulPlaylist;
    }

    public static void main(String[] args) {
        getJudulPlaylist();
        displayJudulPlaylist();
        insertJudulPlaylist("AA");
    }
}
