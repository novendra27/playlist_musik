package controller;

import service.DBService;
import util.ArrayMusik;

public class MusikController {
    
    private static DBService service = new DBService();
    private static ArrayMusik arrayMusik = new ArrayMusik(service.getSizeMusikService());

    public static void getMusik() {
        arrayMusik = service.getMusikService();
        if (arrayMusik != null) {
            System.out.println("Berhasil menambahkan musik ke array");
            arrayMusik.displayArray();
        } else {
            System.out.println("Gagal menambahkan musik ke array");
        }
    }
    
    public static void main(String[] args) {
        getMusik();
    }
}
