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

    public String displayMusik() {
<<<<<<< HEAD
        return JudulMusik + " - " + Artis;
=======
        return JudulMusik + " by " + Artis;
>>>>>>> 4666e00061e5a1db7bb5f4578b7c57089f25b5aa
    }

}
