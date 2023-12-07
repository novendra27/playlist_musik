package repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.MusikModel;
import model.PlaylistModel;
import util.ArrayJudulPlaylist;
import util.ArrayMusik;
import util.HashTable;

public class DBManager {

    public static PlaylistModel playlistModel;
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

    protected static ArrayMusik getMusik(int size) {
        ArrayMusik arrayMusik = new ArrayMusik(size);
        try {
            String sql = "SELECT * FROM `tb_musik`";
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(sql);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                arrayMusik.insert(result.getString("id_musik"), result.getString("judul_musik"), result.getString("artis"));
            }
            return arrayMusik;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected static int getSizeMusik() {
        try {
            String sql = "SELECT COUNT(id_musik) FROM tb_musik;";
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(sql);
            ResultSet result = preparedStatement.executeQuery();
            if (result.next()) {
                int size = result.getInt("COUNT(id_musik)");
                return size;
            }
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    protected static ArrayJudulPlaylist getJudulPlaylist(int size) {
        ArrayJudulPlaylist ArrayJudulPlaylist = new ArrayJudulPlaylist(size);
        try {
            String sql = "SELECT * FROM `tb_judul_playlist`";
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(sql);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                ArrayJudulPlaylist.insert(result.getString("id_judul_playlist"), result.getString("nama_playlist"));
            }
            return ArrayJudulPlaylist;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected static int getSizeJudulPlaylist() {
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

}
