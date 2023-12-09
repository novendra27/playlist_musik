package util;

import model.PlaylistModel;

public class CircularLink {

    public PlaylistModel playlist;
    public CircularLink next;
    public CircularLink prev;

    public CircularLink(PlaylistModel playlist) {
        this.playlist = playlist;
        this.next = null;
        this.prev = null;
    }

    public PlaylistModel getPlaylist() {
        return playlist;
    }

    public void displayLink() {
        playlist.displayPlaylist();
    }
}