package model;

public class JudulPlaylistModel {

    private String IDJudulPlaylist;
    private String NamaPlaylist;

    public JudulPlaylistModel(String IDJudulPlaylist, String NamaPlaylist) {
        this.IDJudulPlaylist = IDJudulPlaylist;
        this.NamaPlaylist = NamaPlaylist;
    }

    public String getIDJudulPlaylist() {
        return IDJudulPlaylist;
    }

    public String getNamaPlaylist() {
        return NamaPlaylist;
    }

    public String displayJudulPlaylist() {
        return "Playlist " + NamaPlaylist;
    }

    
}
