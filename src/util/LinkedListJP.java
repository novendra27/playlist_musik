package util;

import model.JudulPlaylistModel;

public class LinkedListJP {

    private NodeJP first;

    public LinkedListJP() {
        first = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public NodeJP deleteFirst() {
        NodeJP temp = first;
        first = first.next;
        return temp;
    }

    public JudulPlaylistModel find(String key) {
        NodeJP current = first;
        while (current != null) {
            if (current.Data.getIDJudulPlaylist().equals(key)) {
                return current.Data;
            } else {
                current = current.next;
            }
        }
        return current.Data;
    }

    public void displayList() {
        System.out.println("Daftar Judul Playlist yang Tersedia : ");
        NodeJP current = first;
        int i = 1;
        while (current != null) {
            System.out.print(i++ + ". ");
            current.displayNodeJP();
            current = current.next;
        }
        System.out.println("");
    }

    public void insertLast(JudulPlaylistModel Data) {
        NodeJP newNodeJP = new NodeJP(Data);
        if (isEmpty()) {
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

    public JudulPlaylistModel peekLast() {
        if (isEmpty()) {
            return null;
        }
        NodeJP current = first;
        while (current.next != null) {
            current = current.next;
        }
        return current.Data;
    }
}
