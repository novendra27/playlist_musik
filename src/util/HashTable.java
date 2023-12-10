package util;

import model.PlaylistModel;

public class HashTable {

    private SortedCircularLinkList[] hashArray;
    private int size;
    private int lastInsertIndex;

    public HashTable(int size) {
        this.size = size;
        hashArray = new SortedCircularLinkList[size];
        for (int i = 0; i < size; i++) {
            hashArray[i] = new SortedCircularLinkList();
        }
    }

    public void displayTable() {
        System.out.println("Daftar Playlist Beserta Lagunya : ");
        for (int j = 0; j < size; j++) {
            hashArray[j].displayList(j);
        }
    }

    public void displayTable(String IDJudulPlaylist, String namaPlaylist) {
        int index = hashFunc(IDJudulPlaylist);
<<<<<<< HEAD
        hashArray[index].displayAllList(index, namaPlaylist);
=======
        hashArray[index].displayList(index, namaPlaylist);
>>>>>>> 4666e00061e5a1db7bb5f4578b7c57089f25b5aa
    }

    public int hashFuncChangeData(String IDJudulPlaylist) {
        int idHash = Integer.parseInt(IDJudulPlaylist.substring(3)) - 1;
        lastInsertIndex = idHash % size;
        return idHash % size;
    }
    
    public int hashFunc(String IDJudulPlaylist) {
        int idHash = Integer.parseInt(IDJudulPlaylist.substring(3)) - 1;
        return idHash % size;
    }

    public void insert(PlaylistModel playlist) {
        CircularLink theLink = new CircularLink(playlist);
        String IDJudulPlaylist = playlist.getIDJudulPlaylist();
        int hashVal = hashFuncChangeData(IDJudulPlaylist);
        hashArray[hashVal].insert(theLink);
    }

    public void delete(String IDPlaylist, String IDJudulPlaylist) {
        int hashVal = hashFunc(IDJudulPlaylist);
        hashArray[hashVal].delete(IDPlaylist);
    }

    public PlaylistModel find(String IDPlaylist, String IDJudulPlaylist) {
        int hashVal = hashFunc(IDJudulPlaylist);
        return hashArray[hashVal].find(IDPlaylist);
    }

    public boolean isEmpty() {
        for (int i = 0; i < size; i++) {
            if (!hashArray[i].isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public PlaylistModel peekLast() {
        if (!isEmpty()) {
            return hashArray[lastInsertIndex].peekLast();
        }
        return null;
    }
    
    public void play(String IDJudulPlaylist, String IDMusik) {
        int hashVal = hashFunc(IDJudulPlaylist);
        hashArray[hashVal].play(IDMusik);
    }

    public void playNext(String IDJudulPlaylist, String IDMusik) {
        int hashVal = hashFunc(IDJudulPlaylist);
        hashArray[hashVal].playNext(IDMusik);
    }

    public void playPrev(String IDJudulPlaylist, String IDMusik) {
        int hashVal = hashFunc(IDJudulPlaylist);
        hashArray[hashVal].playPrev(IDMusik);
    }
}
