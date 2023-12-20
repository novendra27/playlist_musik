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
        while (current != null && !IDPlaylist.equals(current.getPlaylist().getIDPlaylist())) {
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

    public PlaylistModel find(String IDPlaylist) {
        CircularLink current = first;
        do {
            if (current.getPlaylist().getIDPlaylist().equals(IDPlaylist)) {
                return current.playlist;
            }
            current = current.next;
        } while (current != first);

        return null;
    }
    
    public PlaylistModel findMusikInPlaylist(String IDMusik) {
        CircularLink current = first;
        do {
            if (current.getPlaylist().getIDMusik().equals(IDMusik)) {
                return current.playlist;
            }
            current = current.next;
        } while (current != first);

        return null;
    }
    
    public CircularLink findMusik(String IDMusik) {
        CircularLink current = first;
        do {
            if (current.getPlaylist().getIDMusik().equals(IDMusik)) {
                return current;
            }
            current = current.next;
        } while (current != first);

        return null;
    }
    
    public String findFirstIDMusik() {
        CircularLink current = first;
        if (current != null) {
            return current.playlist.getIDMusik();
        }
        return null;
    }

    public void displayList(int index) {
        if (first != null) {
            CircularLink current = first;
            System.out.print("Playlist " + current.playlist.getNamaPlaylist()+ " : ");
            do {
                current.displayLink();
                current = current.next;
            } while (current != first);
            System.out.println("");
        }
    }

    public void displayAllList(int index, String namaPlaylist) {
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
    
    public void play(String IDMusik) {
        CircularLink current = findMusik(IDMusik);
        if (current != null) {
            current.displayLink();
            System.out.println(" sedang diputar.");
        } else {
            System.out.println("Musik tidak ada di playlist.");
        }
    }

    public void playNext(String IDMusik) {
        CircularLink current = findMusik(IDMusik);
        if (current != null) {
            current = current.next;
            current.displayLink();
            System.out.println(" sedang diputar.");
        } else {
            System.out.println("Musik tidak ada di palylist.");
        }
    }

    public void playPrev(String IDMusik) {
        CircularLink current = findMusik(IDMusik);
        if (current != null) {
            current = current.prev;
            current.displayLink();
            System.out.println(" sedang diputar.");
        } else {
            System.out.println("Musik tidak ada di playlist.");
        }
    }
}
