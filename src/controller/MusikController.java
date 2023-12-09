package controller;

import model.MusikModel;
import service.DBService;
import util.LinkedListMusik;

public class MusikController {

    private static DBService service = new DBService();
    private static LinkedListMusik linkedListMusik = new LinkedListMusik();

    public static void getMusik() {
        linkedListMusik = service.getMusikService();
    }

    public static void displayAllMusik() {
        linkedListMusik.displayList();
    }

    public static void insertMusik(String judulMusic, String artis) {
        MusikModel musikModel = new MusikModel(peekLastID(), judulMusic, artis);
        linkedListMusik.insertLast(musikModel);
        service.addMusikService(linkedListMusik.peekLast().getIDMusic(), linkedListMusik.peekLast().getJudulMusic(), linkedListMusik.peekLast().getArtis());
    }

    public static String peekLastID() {
        String IDMusik = linkedListMusik.peekLast().getJudulMusic();
        int intID = Integer.parseInt(IDMusik.substring(3)) + 1;
        return generateID(intID);
    }
    
    public static String generateID(int intID) {
        String IDMusik;
        if (intID < 10) {
            IDMusik = "M00" + intID;
        } else if (intID < 100) {
            IDMusik = "M0" + intID;
        } else {
            IDMusik = "M" + intID;
        }
        return IDMusik;
    }
    
    public static MusikModel find(String IDMusik){
        return linkedListMusik.find(IDMusik);
    }

    public static void main(String[] args) {
        getMusik();
        displayAllMusik();
    }
}
