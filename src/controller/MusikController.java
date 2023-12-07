package controller;

import model.MusikModel;
import service.DBService;
import util.LinkedListMusik;

public class MusikController {

    private static DBService service = new DBService();
    private static LinkedListMusik linkedListMusik = new LinkedListMusik();

    public static void getMusik() {
        linkedListMusik = service.getMusikService();
        if (linkedListMusik != null) {
            System.out.println("Berhasil menambahkan musik ke linked list");
        } else {
            System.out.println("Gagal menambahkan musik ke linked list");
        }
    }

    public static void displayMusik() {
        linkedListMusik.displayList();
    }

    public static void insertMusik(String judulMusic, String artis) {
        MusikModel musikModel = new MusikModel(generateID(), judulMusic, artis);
        linkedListMusik.insertLast(musikModel);
        linkedListMusik.displayList();
    }

    public static String generateID() {
        String IDMusik = linkedListMusik.peekLastID();
        int intID = Integer.parseInt(IDMusik.substring(3)) + 1;
        if (intID < 10) {
            IDMusik = "M00" + intID;
        } else if (intID < 100) {
            IDMusik = "M0" + intID;
        } else {
            IDMusik = "M" + intID;
        }
        return IDMusik;
    }

    public static void main(String[] args) {
        getMusik();
        displayMusik();
    }
}
