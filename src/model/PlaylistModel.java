package model;

public class PlaylistModel {

    String IDJudulPlaylist;
    String IDMusic;

    public PlaylistModel(String IDPlaylist, String IDMusic) {
        this.IDJudulPlaylist = IDPlaylist;
        this.IDMusic = IDMusic;
    }

    public String getIDJudulPlaylist() {
        return IDJudulPlaylist;
    }

    public String getIDMusic() {
        return IDMusic;
    }

    public void displayPlaylist() {
        System.out.print(IDMusic + " ");
    }
}
