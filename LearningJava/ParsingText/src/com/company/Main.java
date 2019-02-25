package com.company;


public class Main {
    public static void main(String[] args) {

        Song song[] = new Song[5];

        song[0] = new Song("Stronger", "Kanye West",10.5,7983);
        song[1] = new Song("Crazy","Gnarls Barkley", 10.5,12);
        song[2] = new Song("Lose Yourself","Eminem", 10.5,5142);
        song[3] = new Song("Californication","Red Hot Chili Peppers", 10.5,5143);
        song[4] = new Song("Feel Good Inc","Gorillaz", 10.5,25);

        OutputToFile.writeString("Title");
        OutputToFile.writeString("Author");
        OutputToFile.writeString("Rating");
        for(int i = 0; i < song.length; i++) {
            OutputToFile.writeString("\n" + song[i].getTitle());
            OutputToFile.writeString(song[i].getAuthor());
            OutputToFile.writeString(Integer.toString(song[i].getRating()));
        }
        OutputToFile.saveAndClose();
    }
}
