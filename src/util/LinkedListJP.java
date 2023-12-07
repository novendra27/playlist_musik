package util;

import model.JudulPlaylistModel;

public class LinkedListJP {

    private NodeJP first;

    //Konstruktor untuk menginisialisasi linked list kosong
    public LinkedListJP() {
        first = null;
    }

    //Method untuk memeriksa apakah linked list kosong
    public boolean isEmpty() {
        return (first == null);
    }

    //Method untuk menghapus node pertama dari linked list
    public NodeJP deleteFirst() {
        NodeJP temp = first;
        first = first.next;
        return temp;
    }
    
    //Method mencari node yang sesuai dengan data yang dicari
    public String findIDJudulPlaylist(String key) {
        NodeJP current = first;
        while (current.Data.getIDJudulPlaylist() != key) {
            if (current.next == null) {
                return null;
            } else {
                current = current.next;
            }
        }
        return current.Data.getIDJudulPlaylist();
    }
    
//    //Method untuk mencetak seluruh isi linked list
//    public void displayList() {
//        System.out.println("List(first-->last):");
//        NodeJP current = first;
//        while (current != null) {
//            current.displayNodeJP();
//            current = current.next;
//        }
//        System.out.println("");
//    }

    public void insertLast(JudulPlaylistModel Data) {
        NodeJP newNodeJP = new NodeJP(Data);
        if (isEmpty()) {
            // Jika linked list kosong, node baru menjadi node pertama
            first = newNodeJP;
            return;
        }
        NodeJP current = first;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNodeJP;
    }

    public NodeJP deleteLast() {
        if (isEmpty()) {
            return null;
        }
        if (first.next == null) {
            NodeJP temp = first;
            first = null;
            return temp;
        }
        NodeJP current = first;
        NodeJP previous = null;
        while (current.next != null) {
            previous = current;
            current = current.next;
        }
        previous.next = null;

        return current;
    }
}
