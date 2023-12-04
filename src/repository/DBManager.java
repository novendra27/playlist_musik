package repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.PlaylistModel;
import util.HashTable;

public class DBManager {
    
    public static PlaylistModel playlistModel;
    
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
}
