package com.company;


public class Main {
    public static void main(String[] args) {

        Song song[] = new Song[5];

        song[0] = new Song("Stronger", "Kanye West",10.5,7983);
        song[1] = new Song("Crazy","Gnarls Barkley", 10.5,12);
        song[2] = new Song("Lose Yourself","Eminem", 10.5,5142);
        song[3] = new Song("Californication","Red Hot Chili Peppers", 10.5,5143);
        song[4] = new Song("Feel Good Inc","Gorillaz", 10.5,25);

        MediaFile.writeString("Title");
        MediaFile.writeString("Author");
        MediaFile.writeString("Rating");
        for(int i = 0; i < song.length; i++) {
            MediaFile.writeString("\n" + song[i].getTitle());
            MediaFile.writeString(song[i].getAuthor());
            MediaFile.writeString(Integer.toString(song[i].getRating()));
        }
        MediaFile.saveAndClose();
    }
}
