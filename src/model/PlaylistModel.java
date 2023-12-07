package model;

public class PlaylistModel {

    private String IDPlaylist;
    private String IDJudulPlaylist;
    private String IDMusik;

    public PlaylistModel(String IDPlaylist, String IDJudulPlaylist, String IDMusik) {
        this.IDPlaylist = IDPlaylist;
        this.IDJudulPlaylist = IDJudulPlaylist;
        this.IDMusik = IDMusik;
    }

    public String getIDPlaylist() {
        return IDPlaylist;
    }

    public String getIDJudulPlaylist() {
        return IDJudulPlaylist;
    }

    public String getIDMusik() {
        return IDMusik;
    }

    public void displayPlaylist() {
        System.out.print(IDMusik + " ");
    }
}
