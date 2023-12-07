package util;

import model.JudulPlaylistModel;
import model.MusikModel;

public class LLMusik {
    private NodeMusik first;

    //Konstruktor untuk menginisialisasi linked list kosong
    public LLMusik() {
        first = null;
    }

    //Method untuk memeriksa apakah linked list kosong
    public boolean isEmpty() {
        return (first == null);
    }

    //Method untuk menghapus node pertama dari linked list
    public NodeMusik deleteFirst() {
        NodeMusik temp = first;
        first = first.next;
        return temp;
    }
    
//    //Method untuk mencetak seluruh isi linked list
//    public void displayList() {
//        System.out.println("List(first-->last):");
//        NodeMusik current = first;
//        while (current != null) {
//            current.displayNodeMusik();
//            current = current.next;
//        }
//        System.out.println("");
//    }

    public void insertLast(MusikModel Data) {
        NodeMusik newNodeMusik = new NodeMusik(Data);
        if (isEmpty()) {
            // Jika linked list kosong, node baru menjadi node pertama
            first = newNodeMusik;
            return;
        }
        NodeMusik current = first;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNodeMusik;
    }

    public NodeMusik deleteLast() {
        if (isEmpty()) {
            return null;
        }
        if (first.next == null) {
            NodeMusik temp = first;
            first = null;
            return temp;
        }
        NodeMusik current = first;
        NodeMusik previous = null;
        while (current.next != null) {
            previous = current;
            current = current.next;
        }
        previous.next = null;

        return current;
    }
}
