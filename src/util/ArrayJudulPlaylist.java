package util;

import model.JudulPlaylistModel;

public class ArrayJudulPlaylist {

    private JudulPlaylistModel[] playlists;
    private int nElemen;

    public ArrayJudulPlaylist(int max) {
        playlists = new JudulPlaylistModel[max];
        nElemen = 0;
    }

    public JudulPlaylistModel find(String searchID) {
        int i;
        for (i = 0; i < nElemen; i++) {
            if (playlists[i].getIDJudulPlaylist().equals(searchID)) {
                break;
            }
        }
        if (i == nElemen) {
            return null;
        } else {
            return playlists[i];
        }
    }

    public void insert(String IDJudulPlaylist, String NamaPlaylist) {
        playlists[nElemen] = new JudulPlaylistModel(IDJudulPlaylist, NamaPlaylist);
        nElemen++;
    }

    public boolean delete(String searchID) {
        int i;
        for (i = 0; i < nElemen; i++) {
            if (playlists[i].getIDJudulPlaylist().equals(searchID)) {
                break;
            }
        }
        if (i == nElemen) {
            return false;
        } else {
            for (int j = i; j < nElemen - 1; j++) {
                playlists[j] = playlists[j + 1];
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
            System.out.println(playlists[i].getIDJudulPlaylist() + " - " + playlists[i].getNamaPlaylist());
        }
    }
}
