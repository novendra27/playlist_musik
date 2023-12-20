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

    private void createPlaylist() {
        System.out.print("Nama Playlist: ");
        String playlistName = input.nextLine();

        jPControl.insertJudulPlaylist(playlistName);
    }

    private void displayAllJudulPlaylist() {
        jPControl.displayAllJudulPlaylist();
    }

    private void displayOnePlaylist(String IDJudulPlaylist) {
        pControl.displayPlaylist(IDJudulPlaylist);
    }

    private void deletePlaylist() {
        displayAllJudulPlaylist();

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

    private void deleteMusic() {
        displayMusic();
        System.out.print("Hapus Musik (Nomor): ");
        String musicKey = mControl.generateID(Integer.parseInt(input.nextLine()));

        mControl.delete(musicKey);
    }

    private void addMusicToPlaylist() {
        displayAllJudulPlaylist();
        System.out.print("Pilih PLaylist: ");
        String choosenPlaylist = jPControl.generateID(Integer.parseInt(input.nextLine()));

        displayMusic();
        System.out.print("Pilih Musik: ");
        String choosenMusic = mControl.generateID(Integer.parseInt(input.nextLine()));

        pControl.insertMusicToPlaylist(choosenPlaylist, choosenMusic);
        pControl.displayPlaylist(choosenPlaylist);
    }

    private void removeMusicFromPlaylist() {
        displayAllJudulPlaylist();
        System.out.print("Pilih PLaylist: ");
        String choosenPlaylist = jPControl.generateID(Integer.parseInt(input.nextLine()));

        displayOnePlaylist(choosenPlaylist);
        displayMusic();
        System.out.print("Pilih Musik: ");
        String choosenMusic = mControl.generateID(Integer.parseInt(input.nextLine()));

        pControl.removeMusicFromPlaylist(choosenMusic, choosenPlaylist);
        pControl.displayAllPlaylist();
    }

    private void playPlaylist() {
        displayAllJudulPlaylist();
        System.out.print("Pilih Playlist: ");
        String choosenPlaylist = jPControl.generateID(Integer.parseInt(input.nextLine()));
        displayOnePlaylist(choosenPlaylist);
        pControl.play(choosenPlaylist);
    }

    private int player() {
        System.out.println("\n1. Next");
        System.out.println("2. Previous");
        System.out.println("3. Stop");

        System.out.print("Pilih Menu: ");
        int userChoice = Integer.parseInt(input.nextLine());
        return userChoice;
    }

    private int mainMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Buat Playlist");
        System.out.println("2. Daftar Playlist");
        System.out.println("3. Hapus Playlist");
        System.out.println("4. Tambah Musik");
        System.out.println("5. Daftar Musik");
        System.out.println("6. Hapus Musik");
        System.out.println("7. Keluar");

        System.out.print("Pilih Menu: ");
        int userChoice = Integer.parseInt(input.nextLine());
        return userChoice;
    }

    private int playlistMenu() {
        System.out.println("\nMenu Playlist:");
        System.out.println("1. Putar Playlist");
        System.out.println("2. Tambah Musik ke Playlist");
        System.out.println("3. Hapus Musik dari Playlist");
        System.out.println("4. Kembali");

        System.out.print("Pilih Menu: ");
        int userChoice = Integer.parseInt(input.nextLine());
        return userChoice;
    }

    public void init() {
        System.out.println("=========== Selamat Datang Di Playify ===========");

        while (true) {
            int userChoice = mainMenu();

            switch (userChoice) {
                case 1: // only for create playlist
                    try {
                    createPlaylist();
                    System.out.println("Playlist berhasil dibuat!");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
                case 2: // only for display playlist
                    displayAllJudulPlaylist();

                    int playlistOption = playlistMenu();

                    switch (playlistOption) {
                        case 1: // only for play playlist
                            playPlaylist();

                            int playerOption = player();

                            do {
                                switch (playerOption) {
                                    case 1:
                                        pControl.playNext();
                                        playerOption = player();
                                        break;
                                    case 2:
                                        pControl.playPrev();
                                        playerOption = player();
                                        break;

                                    case 3:
                                        pControl.stopPlay();
                                        break;
                                }
                            } while (playerOption != 3);
                             break;
                        case 2:
                            addMusicToPlaylist();
                            System.out.println("Musik berhasil ditambah ke playlist");
                            break;
                        case 3:
                            removeMusicFromPlaylist();
                            System.out.println("Musik berhasil dihapus dari playlist");
                            break;
                        case 4:
                            init();
                            break;
                    }
                    break;
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
                case 5: // only for display music
                    displayMusic();
                    break;
                case 6: // only for delete music
                    try {
                    deleteMusic();
                    System.out.println("Musik berhasil dihapus!");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
                case 7: // exit apps
                    System.out.println("Terima Kasih! See Yaa!");
                    System.exit(0);
                default:
                    System.out.println("ERROR: Menu yang dipilih tidak ada!");
            }
        }

    }

}
