package util;

import model.MusikModel;

public class NodeMusik {
    public MusikModel Data;
    public NodeMusik next;

    public NodeMusik(MusikModel Data) {
        this.Data = Data;
    }

    public void displayNodeJP() {
        System.out.print(Data + " ");
    }
}
