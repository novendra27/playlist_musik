package util;

import model.JudulPlaylistModel;
import model.MusikModel;

public class LinkedListMusik {

    private NodeMusik first;

    public LinkedListMusik() {
        first = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public NodeMusik deleteFirst() {
        NodeMusik temp = first;
        first = first.next;
        return temp;
    }

    public void displayList() {
        System.out.println("Daftar Musik yang Tersedia : ");
        NodeMusik current = first;
        int i = 1;
        while (current != null) {
            System.out.print(i++ + ". ");
            current.displayNodeMusik();
            current = current.next;
        }
        System.out.println("");
    }

    public void insertLast(MusikModel Data) {
        NodeMusik newNodeMusik = new NodeMusik(Data);
        if (isEmpty()) {
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

    public String peekLastID() {
        if (isEmpty()) {
            return null;
        }
        NodeMusik current = first;
        while (current.next != null) {
            current = current.next;
        }
        return current.Data.getIDMusic();
    }
    
    public MusikModel find(String key) {
        NodeMusik current = first;
        while (current != null) {
            if (current.Data.getIDMusic().equals(key)) {
                return current.Data;
            } else {
                current = current.next;
            }
        }
        return current.Data;
    }
}
