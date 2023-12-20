package util;

import model.MusikModel;

public class LinkedListMusik {

    private NodeMusik first;

    public LinkedListMusik() {
        first = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void displayList() {
        System.out.println("=================================================");
        System.out.println("Daftar Musik yang Tersedia : ");
        NodeMusik current = first;
        int i = 1;
        while (current != null) {
            System.out.print(i++ + ". ");
            current.displayNodeMusik();
            current = current.next;
        }
        System.out.println("=================================================");
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

    public MusikModel peekLast() {
        if (isEmpty()) {
            return null;
        }
        NodeMusik current = first;
        while (current.next != null) {
            current = current.next;
        }
        return current.Data;
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
    
    public MusikModel delete(String IDMusik) {
        NodeMusik current = first;
        NodeMusik previous = null;
        while (current != null && !current.Data.getIDMusic().equals(IDMusik)) {
            previous = current;
            current = current.next;
        }
        if (current == null) {
            return null;
        }
        if (previous == null) {
            first = current.next; 
        } else {
            previous.next = current.next;
        }
        return current.Data;
    }
}
