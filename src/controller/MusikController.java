package controller;

import model.MusikModel;
import service.DBService;
import util.LinkedListMusik;

public class MusikController {

<<<<<<< HEAD
    private static DBService service;
    private static LinkedListMusik linkedListMusik = new LinkedListMusik();

    public MusikController (DBService service) {
        this.service = service;
        getMusik();
    }
    
=======
    private static DBService service = new DBService();
    private static LinkedListMusik linkedListMusik = new LinkedListMusik();

>>>>>>> 4666e00061e5a1db7bb5f4578b7c57089f25b5aa
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
<<<<<<< HEAD
        String IDMusik = linkedListMusik.peekLast().getIDMusic();
=======
        String IDMusik = linkedListMusik.peekLast().getJudulMusic();
>>>>>>> 4666e00061e5a1db7bb5f4578b7c57089f25b5aa
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
    
    public static void delete(String IDMusik){        
        MusikModel musikModel = new MusikModel(find(IDMusik).getIDMusic(), find(IDMusik).getJudulMusic(), find(IDMusik).getArtis());
        if ( musikModel != null) {
            linkedListMusik.delete(IDMusik);
            service.deleteMusikService(IDMusik);
        } 
    }

    public static void main(String[] args) {
        getMusik();
        displayAllMusik();
<<<<<<< HEAD
        insertMusik("Judul-Judulan", "Om PMR");
//        delete("M006");
//        displayAllMusik();
=======
        delete("M006");
        displayAllMusik();
>>>>>>> 4666e00061e5a1db7bb5f4578b7c57089f25b5aa
    }
}
