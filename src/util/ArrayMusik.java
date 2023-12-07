package util;

import model.MusikModel;

public class ArrayMusik {

    private MusikModel[] musics;  // Change the type to MusikModel
    private int nElemen;

    public ArrayMusik(int max) {
        musics = new MusikModel[max];
        nElemen = 0;
    }

    public MusikModel find(String searchID) {  // Change the parameter and return type
        int i;
        for (i = 0; i < nElemen; i++) {
            if (musics[i].getIDMusic().equals(searchID)) {
                break;
            }
        }
        if (i == nElemen) {
            return null;
        } else {
            return musics[i];
        }
    }

    public void insert(String IDMusic, String JudulMusic, String Artis) {  // Change parameters
        musics[nElemen] = new MusikModel(IDMusic, JudulMusic, Artis);
        nElemen++;
    }

    public boolean delete(String searchID) {  // Change the parameter
        int i;
        for (i = 0; i < nElemen; i++) {
            if (musics[i].getIDMusic().equals(searchID)) {
                break;
            }
        }
        if (i == nElemen) {
            return false;
        } else {
            for (int j = i; j < nElemen - 1; j++) {
                musics[j] = musics[j + 1];
            }
            nElemen--;
            return true;
        }
    }

    public boolean isEmpty() {
        return nElemen == 0;
    }

    public void displayArray() {
        for (int i = 0; i < nElemen; i++) {
            System.out.println(musics[i].displayMusic());
        }
    }
}
