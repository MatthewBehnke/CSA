package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class LoopingMediaLib {

    public static void main(String[] args) throws IOException {
        File f = new File("mymedia.csv");
        Scanner scan = new Scanner(f);

        int g = 0;
        Song[] songs = new Song[countLines(f)];
        while (scan.hasNext()) {
            Song song = new Song();
            String line = scan.nextLine();
            String[] pieces = line.split(",");

            song.setTitle(pieces[0]);
            song.setAuthor(pieces[1]);
            try {
                song.setRating(Integer.parseInt(pieces[2]));
            } catch (Exception e) {
                song.setRating(0);
            }

            songs[g] = song;
            g++;
        }

//        Song[] sortedSongs = doInsertionSongSort(songs);
        Song[] sortedSongs = songs;

        for (int i = 1; i < sortedSongs.length; i++){
            System.out.println("Title: " + sortedSongs[i].getTitle() + ", Author: " + sortedSongs[i].getAuthor() + ", Rating: " + sortedSongs[i].getRating());
        }
    }

    public static Song[] doInsertionSongSort(Song[] input){
        int temp;
        for (int i = 1; i < input.length; i++) {
            for(int j = i ; j > 0 ; j--){
                if(input[j].getRating() < input[j-1].getRating()){
                    temp = input[j].getRating();
                    input[j] = input[j-1];
                    input[j-1].setRating(temp);
                }
            }
        }
        return input;
    }

    public static int countLines(File input) throws IOException {
        try (InputStream is = new FileInputStream(input)) {
            int count = 1;
            for (int aChar = 0; aChar != -1;aChar = is.read())
                count += aChar == '\n' ? 1 : 0;
            return count;
        }
    }
}