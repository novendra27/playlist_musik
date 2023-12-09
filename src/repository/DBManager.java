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
            String sql = "SELECT p.id_playlist, p.id_judul_playlist, j.nama_playlist, p.id_musik, m.judul_musik FROM tb_playlist p "
                    + "INNER JOIN tb_musik m ON p.id_musik = m.id_musik "
                    + "INNER JOIN tb_judul_playlist j ON P.id_judul_playlist = j.id_judul_playlist";
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(sql);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                playlistModel = new PlaylistModel(result.getString("id_playlist"), result.getString("id_judul_playlist"), 
                        result.getString("nama_playlist"), result.getString("id_musik"), result.getString("judul_musik"));
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

    protected static boolean addJudulPlaylist(String IDJudulPlaylist, String namaPlaylist) {
        try {
            String sql = "INSERT INTO `tb_judul_playlist`(`id_judul_playlist`, `nama_playlist`) VALUES (?,?)";
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, IDJudulPlaylist);
            preparedStatement.setString(2, namaPlaylist);
            int result = preparedStatement.executeUpdate();
            if (result == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    protected static boolean addMusik(String IDMusik, String judulMusik, String artis) {
        try {
            String sql = "INSERT INTO `tb_musik`(`id_musik`, `judul_musik`, `artis`) VALUES (?,?,?)";
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, IDMusik);
            preparedStatement.setString(2, judulMusik);
            preparedStatement.setString(3, artis);
            int result = preparedStatement.executeUpdate();
            if (result == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    protected static boolean addPlaylist(String IDPlaylist, String IDJudulPlaylist, String IDMusik) {
        try {
            String sql = "INSERT INTO `tb_playlist`(`id_playlist`, `id_judul_playlist`, `id_musik`) VALUES (?,?,?)";
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, IDPlaylist);
            preparedStatement.setString(2, IDJudulPlaylist);
            preparedStatement.setString(3, IDMusik);
            int result = preparedStatement.executeUpdate();
            if (result == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
