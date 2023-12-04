package model;

public class MusicModel {
    private String IDMusic;
    private String JudulMusic;
    private String Artis;

    public MusicModel(String IDMusic, String JudulMusic, String Artis) {
        this.IDMusic = IDMusic;
        this.JudulMusic = JudulMusic;
        this.Artis = Artis;
    }

    public String getIDMusic() {
        return IDMusic;
    }

    public String getJudulMusic() {
        return JudulMusic;
    }

    public String getArtis() {
        return Artis;
    }

    public String displayMusic() {
        return "MusicModel{" + "IDMusic=" + IDMusic + ", JudulMusic=" + JudulMusic + ", Artis=" + Artis + '}';
    }

    
}
