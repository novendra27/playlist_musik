package model;

public class PlaylistModel {

    private String IDPlaylist;
    private String IDJudulPlaylist;
    private String NamaPlaylist;
    private String IDMusik;
    private String JudulMusik;

    public PlaylistModel(String IDPlaylist, String IDJudulPlaylist, String NamaPlaylist, String IDMusik, String JudulMusik) {
        this.IDPlaylist = IDPlaylist;
        this.IDJudulPlaylist = IDJudulPlaylist;
        this.NamaPlaylist = NamaPlaylist;
        this.IDMusik = IDMusik;
        this.JudulMusik = JudulMusik;
    }

    public String getIDPlaylist() {
        return IDPlaylist;
    }

    public String getIDJudulPlaylist() {
        return IDJudulPlaylist;
    }

    public String getNamaPlaylist() {
        return NamaPlaylist;
    }

    public String getIDMusik() {
        return IDMusik;
    }

    public String getJudulMusik() {
        return JudulMusik;
    }
    
    public void displayPlaylist() {
        System.out.println(JudulMusik);
    }
}
