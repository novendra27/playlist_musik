package util;

import model.JudulPlaylistModel;

public class NodeJP {

    public JudulPlaylistModel Data;
    public NodeJP next;

    public NodeJP(JudulPlaylistModel Data) {
        this.Data = Data;
    }

    public void displayNodeJP() {
        System.out.println(Data.displayJudulPlaylist());
    }
}
