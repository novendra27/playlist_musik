package service;

import repository.DBManager;
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
}
