
package Playlist;

import java.util.Scanner;

public class Song {
    String title;
    Song next;

    
    public Song(String title) {
        this.title = title;
        this.next = null;
    }
}

public class Playlist {
    private Song head;

    
    public Playlist() {
        this.head = null;
    }

    
    public void addSong(String title) {
        Song newSong = new Song(title);
        if (head == null) {
            head = newSong;
        } else {
            Song current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newSong;
        }
        System.out.println("Lagu \"" + title + "\" ditambahkan ke playlist.");
    }

    
    public void displayPlaylist() {
        if (head == null) {
            System.out.println("Playlist kosong.");
            return;
        }

        Song current = head;
        System.out.println("Playlist:");
        while (current != null) {
            System.out.println(current.title);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Lagu");
            System.out.println("2. Tampilkan Playlist");
            System.out.println("3. Keluar");
            System.out.print("Pilih opsi: ");
            choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    System.out.print("Masukkan judul lagu: ");
                    String titleToAdd = scanner.nextLine();
                    playlist.addSong(titleToAdd);
                    break;

                case 2:
                    playlist.displayPlaylist();
                    break;

                case 3:
                    System.out.println("Keluar dari program.");
                    break;

                default:
                    System.out.println("Opsi tidak valid. Silakan coba lagi.");
                    break;
            }
        } while (choice != 3);

        scanner.close();
    }
}

