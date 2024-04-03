package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Wisielec {
    List<String> words = List.of("samochód", "kot", "programowanie", "komputer");
    String word;
    char[] userWord;
    int lives = 3;
    public void play() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Start gry");

        Random random = new Random();
        word = words.get(random.nextInt(words.size()));

        userWord = new char[word.length()];
        Arrays.fill(userWord,'_');

        System.out.println(userWord);

        while(!gameEnded()){
            System.out.println(userWord);
            System.out.println();
            System.out.println("Pozostalo zyc: " + lives);
            System.out.println("Podaj kolejna litere");


            char letter = scanner.nextLine().charAt(0);

            checkLetter(letter);
        }
        if (lives == 0 ){
            System.out.println("Niestety nie udalo Ci się wygrać");
        }
        else{
            System.out.println("Gratuluje, udalo Ci się odgadnąć wylosowane słowo");
        }
        scanner.close();
    }

    private void checkLetter(char letter) {
        boolean foundLetter = false;
        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i) == letter){
                userWord[i] = letter;
                foundLetter = true;
           }
        }
        if(!foundLetter){
            System.out.println("Niestety nie ma takiej litery :o");
            lives--;
        }
    }


    private boolean gameEnded() {
        return lives == 0 || word.equals(String.valueOf(userWord));
    }
}
