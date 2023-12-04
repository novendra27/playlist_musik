package util;

import model.PlaylistModel;

public class HashTable {

    private SortedCircularLinkList[] hashArray;
    private int size;

    public HashTable(int size) {
        this.size = size;
        hashArray = new SortedCircularLinkList[size];
        for (int i = 0; i < size; i++) {
            hashArray[i] = new SortedCircularLinkList();
        }
    }

    public void displayTable() {
        System.out.println("Table: ");
        for (int j = 0; j < size; j++) {
            System.out.print(" " + j + ". ");
            hashArray[j].displayList();
        }
    }

    public int hashFunc(String IDJudulPlaylist) {
        int idHash = Integer.parseInt(IDJudulPlaylist.substring(3));
        return idHash % size;
    }

    public void insert(PlaylistModel playlist) {
        CircularLink theLink = new CircularLink(playlist);
        String IDJudulPlaylist = playlist.getIDJudulPlaylist();
        int hashVal = hashFunc(IDJudulPlaylist);
        hashArray[hashVal].insert(theLink);
    }

    public void delete(String IDJudulPlaylist) {
        int hashVal = hashFunc(IDJudulPlaylist);
        hashArray[hashVal].delete(IDJudulPlaylist);
    }

    public CircularLink find(String IDJudulPlaylist) {
        int hashVal = hashFunc(IDJudulPlaylist);
        return hashArray[hashVal].find(IDJudulPlaylist);
    }
    
    public boolean isEmpty() {
        for (int i = 0; i < size; i++) {
            if (!hashArray[i].isEmpty()) {
                return false;
            }
        }
        return true;
    }
}