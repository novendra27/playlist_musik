package util;

import model.PlaylistModel;

public class SortedCircularLinkList {

    private CircularLink first;

    public SortedCircularLinkList() {
        first = null;
    }

    public void insert(CircularLink theLink) {
        PlaylistModel key = theLink.getPlaylist();
        CircularLink current = first;
        if (current == null) {
            first = theLink;
            theLink.next = theLink;
            theLink.prev = theLink;
        } else {
            while (current.next != first && key.getIDJudulPlaylist().compareTo(current.getPlaylist().getIDJudulPlaylist()) > 0) {
                current = current.next;
            }
            if (key.getIDJudulPlaylist().compareTo(current.getPlaylist().getIDJudulPlaylist()) <= 0) {
                // Insert before current
                theLink.next = current;
                theLink.prev = current.prev;
                current.prev.next = theLink;
                current.prev = theLink;
                if (current == first) {
                    first = theLink;
                }
            } else {
                // Insert after current (at the end)
                theLink.next = first;
                theLink.prev = current;
                current.next = theLink;
                first.prev = theLink;
            }
        }
    }

    public void delete(String IDPlaylist) {
        CircularLink current = first;
        while (current != null && !IDPlaylist.equals(current.getPlaylist().getIDJudulPlaylist())) {
            current = current.next;
        }
        if (current != null) {
            current.prev.next = current.next;
            current.next.prev = current.prev;
            if (current == first) {
                first = current.next;
            }
        }
    }

    public CircularLink find(String IDPlaylist) {
        CircularLink current = first;
        do {
            if (current.getPlaylist().getIDJudulPlaylist().equals(IDPlaylist)) {
                return current;
            }
            current = current.next;
        } while (current != first);

        return null;
    }

    public void displayList(int index) {
        System.out.print("Playlist " + (index + 1) + " : ");
        if (first != null) {
            CircularLink current = first;
            do {
                current.displayLink();
                current = current.next;
            } while (current != first);
        }
        System.out.println("");
    }

    public void displayList(int index, String namaPlaylist) {
        System.out.print("Playlist " + namaPlaylist + " : ");
        if (first != null) {
            CircularLink current = first;
            do {
                current.displayLink();
                current = current.next;
            } while (current != first);
        }
        System.out.println("");
    }

    public boolean isEmpty() {
        return first == null;
    }

    public PlaylistModel peekLast() {
        if (isEmpty()) {
            return null;
        }
        return first.getPlaylist();
    }
}
