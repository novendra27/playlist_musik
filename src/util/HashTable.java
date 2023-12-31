package util;

import model.PlaylistModel;

public class HashTable {

    private SortedCircularLinkList[] hashArray;
    private int size;
    private int lastInsertIndex;
    private int lastPlayIndex;
    private int hashPlayIndex;

    public HashTable(int size) {
        this.size = size;
        hashArray = new SortedCircularLinkList[size];
        for (int i = 0; i < size; i++) {
            hashArray[i] = new SortedCircularLinkList();
        }
    }

    public void displayTable() {
        System.out.println("=================================================");
        System.out.println("Daftar Playlist Beserta Lagunya : ");
        for (int j = 0; j < size; j++) {
            hashArray[j].displayList(j);
        }
        System.out.println("=================================================");
    }

    public void displayTable(String IDJudulPlaylist, String namaPlaylist) {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        int index = hashFunc(IDJudulPlaylist);
        hashArray[index].displayAllList(index, namaPlaylist);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
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
    
    public PlaylistModel findMusikInPlaylist(String IDMusik, String IDJudulPlaylist) {
        int hashVal = hashFunc(IDJudulPlaylist);
        return hashArray[hashVal].findMusikInPlaylist(IDMusik);
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

    public void play(String IDJudulPlaylist) {
        int hashVal = hashFunc(IDJudulPlaylist);
        String IDMusik = hashArray[hashVal].findFirstIDMusik();
        lastPlayIndex = Integer.parseInt(IDMusik.substring(3));
        hashArray[hashPlayIndex].play(IDMusik);
    }

    public void playNext() {
        String temp = hashArray[hashPlayIndex].playNext(generateIDMusik(lastPlayIndex));
        lastPlayIndex = Integer.parseInt(temp.substring(3));
    }

    public void playPrev() {
        String temp = hashArray[hashPlayIndex].playPrev(generateIDMusik(lastPlayIndex));
        lastPlayIndex = Integer.parseInt(temp.substring(3));
    }

    public void stopPlay() {
        lastPlayIndex = 0;
    }

    public static String generateIDMusik(int intID) {
        String IDMusik;
        if (intID < 10) {
            IDMusik = "M00" + intID;
        } else if (intID < 100) {
            IDMusik = "M0" + intID;
        } else {
            IDMusik = "M" + intID;
        }
        return IDMusik;
    }
}
