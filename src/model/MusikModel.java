package model;

public class MusikModel {

    private String IDMusik;
    private String JudulMusik;
    private String Artis;

    public MusikModel(String IDMusic, String JudulMusic, String Artis) {
        this.IDMusik = IDMusic;
        this.JudulMusik = JudulMusic;
        this.Artis = Artis;
    }

    public String getIDMusic() {
        return IDMusik;
    }

    public String getJudulMusic() {
        return JudulMusik;
    }

    public String getArtis() {
        return Artis;
    }

    public String displayMusic() {
        return "MusicModel{IDMusic = " + IDMusik + ", JudulMusic = " + JudulMusik + ", Artis = " + Artis + '}';
    }

}
