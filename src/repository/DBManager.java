package repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.JudulPlaylistModel;
import model.MusikModel;
import model.PlaylistModel;
import util.HashTable;
import util.LinkedListJP;
import util.LinkedListMusik;

public class DBManager {

    public static PlaylistModel playlistModel;
    public static JudulPlaylistModel judulPlaylistModel;
    public static MusikModel musikModel;

    protected static HashTable getPlaylist(int size) {
        HashTable hashTable = new HashTable(size);
        try {
            String sql = "SELECT id_judul_playlist, id_musik FROM `tb_playlist`";
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(sql);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                playlistModel = new PlaylistModel(result.getString("id_judul_playlist"), result.getString("id_musik"));
                hashTable.insert(playlistModel);
            }
            return hashTable;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected static int getSizePlaylist() {
        try {
            String sql = "SELECT COUNT(id_judul_playlist) FROM tb_judul_playlist;";
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(sql);
            ResultSet result = preparedStatement.executeQuery();
            if (result.next()) {
                int size = result.getInt("COUNT(id_judul_playlist)");
                return size;
            }
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    protected static LinkedListMusik getMusik() {
        LinkedListMusik linkedListMusik = new LinkedListMusik();
        try {
            String sql = "SELECT * FROM `tb_musik`";
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(sql);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                musikModel = new MusikModel(result.getString("id_musik"), result.getString("judul_musik"), result.getString("artis"));
                linkedListMusik.insertLast(musikModel);
            }
            return linkedListMusik;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected static LinkedListJP getJudulPlaylist() {
        LinkedListJP linkedListJP = new LinkedListJP();
        try {
            String sql = "SELECT * FROM `tb_judul_playlist`";
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(sql);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                judulPlaylistModel = new JudulPlaylistModel(result.getString("id_judul_playlist"), result.getString("nama_playlist"));
                linkedListJP.insertLast(judulPlaylistModel);
            }
            return linkedListJP;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
