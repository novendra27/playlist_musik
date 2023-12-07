package controller;

import service.DBService;
import util.LinkedListMusik;

public class MusikController {
    
    private static DBService service = new DBService();
    private static LinkedListMusik linkedListMusik = new LinkedListMusik();

    public static void getMusik() {
        linkedListMusik = service.getMusikService();
        if (linkedListMusik != null) {
            System.out.println("Berhasil menambahkan musik ke array");
            linkedListMusik.displayList();
        } else {
            System.out.println("Gagal menambahkan musik ke array");
        }
    }
    
    public static void main(String[] args) {
        getMusik();
    }
}
