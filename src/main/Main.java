package main;

import controller.JudulPlaylistController;
import controller.MusikController;
import controller.PlaylistController;
import service.DBService;
import view.AppView;

public class Main {

    public static void main(String[] args) {
        DBService service = new DBService();
        JudulPlaylistController jPControl = new JudulPlaylistController(service);
        MusikController mControl = new MusikController(service);
        PlaylistController pControl = new PlaylistController(service);
        AppView run = new AppView(jPControl, mControl, pControl);

        run.init();
    }
}
