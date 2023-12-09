package view;

import controller.JudulPlaylistController;
import controller.MusikController;
import controller.PlaylistController;
import java.util.Scanner;

public class AppView {

    Scanner input = new Scanner(System.in);
    JudulPlaylistController jPControl;
    MusikController mControl;
    PlaylistController pControl;

    public AppView(JudulPlaylistController jPControl, MusikController mControl, PlaylistController pControl) {
        this.jPControl = jPControl;
        this.mControl = mControl;
        this.pControl = pControl;
    }

    private void createPlaylst() {
        System.out.print("Nama Playlist: ");
        String playlistName = input.nextLine();

        jPControl.insertJudulPlaylist(playlistName);
    }

    private void displayPlaylist() {
        jPControl.displayAllJudulPlaylist();
    }

    private void deletePlaylist() {
        displayPlaylist();

        System.out.print("Hapus Playlist (Nomor): ");
        String playlistKey = jPControl.generateID(Integer.parseInt(input.nextLine()));
        
        jPControl.delete(playlistKey);
    }

    private void addMusic() {
        System.out.print("Judul Musik: ");
        String musicTitle = input.nextLine();

        System.out.print("Penyanyi: ");
        String musicArtist = input.nextLine();

        mControl.insertMusik(musicTitle, musicArtist);
    }

    private void displayMusic() {
        mControl.displayAllMusik();
    }

    private int mainMenu() {
        System.out.println("Menu:");
        System.out.println("1. Buat Playlist");
        System.out.println("2. Daftar Playlist");
        System.out.println("3. Hapus Playlist");
        System.out.println("4. Tambah Musik");
        System.out.println("5. Daftar Musik");
        System.out.println("6. Keluar");

        System.out.print("Pilih Menu: ");
        int userChoice = Integer.parseInt(input.nextLine());
        return userChoice;
    }

    private int playlistMenu() {
        System.out.println("Menu Playlist:");
        System.out.println("1. Putar Playlist");
        System.out.println("2. Tambah Musik ke Playlist");
        System.out.println("3. Hapus Musik dari Playlist");
        System.out.println("4. Kembali");

        System.out.print("Pilih Menu: ");
        int userChoice = Integer.parseInt(input.nextLine());
        return userChoice;
    }

    public void init() {
        System.out.println("========== Selamat Datang Di Playify ==========");

        while (true) {
            int userChoice = mainMenu();

            switch (userChoice) {
                case 1: // only for create playlist
                    try {
                        createPlaylst();
                        System.out.println("Playlist berhasil dibuat!");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2: // only for display playlist
                    displayPlaylist();
                    break;
//                    int playlistOption = playlistMenu();
                case 3: // only for delete playlist
                    try {
                        deletePlaylist();
                        System.out.println("Playlist berhasil dihapus!");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4: // only for add music
                    try {
                        addMusic();
                        System.out.println("Musik berhasil ditambahkan!");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5: // onlu for display music
                    displayMusic();     
                    break;
                case 6:
                    System.out.println("Terima Kasih! See Yaa!");
                    System.exit(0);
               default:
                   System.out.println("ERROR: Menu yang dipilih tidak ada!");
            }
        }

    }

}
