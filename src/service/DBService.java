package service;

import repository.DBManager;
import util.ArrayJudulPlaylist;
import util.ArrayMusik;
import util.HashTable;

public class DBService extends DBManager{
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
    
    public static ArrayMusik getMusikService() {
        ArrayMusik arrayMusik = getMusik(getSizeMusik());
        if (arrayMusik.isEmpty()) {
            return null;
        }
        return arrayMusik;
    }
    
    public static int getSizeMusikService() {
        int size = getSizeMusik();
        if (size > 0) {
            return size;
        }
        return 0;
    }
    
    public static ArrayJudulPlaylist getJudulPlaylistService() {
        ArrayJudulPlaylist judulPlaylist = getJudulPlaylist(getSizeJudulPlaylist());
        if (judulPlaylist.isEmpty()) {
            return null;
        }
        return judulPlaylist;
    }
    
    public static int getSizeJudulPlaylistService() {
        int size = getSizeJudulPlaylist();
        if (size > 0) {
            return size;
        }
        return 0;
    }
}
