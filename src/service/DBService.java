package service;

import repository.DBManager;
import util.LinkedListMusik;
import util.HashTable;
import util.LinkedListJP;

public class DBService extends DBManager {

    public static HashTable getPlaylistService() {
        HashTable hashTable = getPlaylist(getSizePlaylist());
        if (hashTable.isEmpty()) {
            return null;
        }
        return hashTable;
    }

    public static int getSizePlaylistService() {
        int size = getSizePlaylist();
        if (size > 0) {
            return size;
        }
        return 0;
    }

    public static LinkedListMusik getMusikService() {
        LinkedListMusik linkedListMusik = getMusik();
        if (linkedListMusik.isEmpty()) {
            return null;
        }
        return linkedListMusik;
    }

    public static LinkedListJP getJudulPlaylistService() {
        LinkedListJP linkedListJP = getJudulPlaylist();
        if (linkedListJP.isEmpty()) {
            return null;
        }
        return linkedListJP;
    }

    public static boolean addJudulPlaylistService(String IDJudulPlaylist, String namaPlaylist) {
        if (addJudulPlaylist(IDJudulPlaylist, namaPlaylist)) {
            return true;
        }
        return false;
    }
    
    public static boolean addMusikService(String IDMusik, String judulMusik, String artis) {
        if (addMusik(IDMusik, judulMusik, artis)) {
            return true;
        }
        return false;
    }
    
    public static boolean addPlaylistService(String IDPlaylist, String IDJudulPlaylist, String IDMusik) {
        if (addPlaylist(IDPlaylist, IDJudulPlaylist, IDMusik)) {
            return true;
        }
        return false;
    }
}
