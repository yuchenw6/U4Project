import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Hand {
    private String[] hand;
    private int bid;
    private int handLevel;
    public Hand(String[] hand, int bid){
        this.hand = hand;
        this.bid = bid;
        handLevel = 0;

    }

    public String calculate() {
        int same = 0;
        String[] cardType = {"Ace", "King", "Queen", "Jack", "10", "9", "8", "7", "6", "5", "4", "3", "2"};
        int[] cardNum = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0; i < hand.length; i++) {
            for (int a = 0; a < cardType.length; a++) {
                if (hand[i].equals(cardType[a])) {
                    cardNum[a] = cardNum[a] + 1;
                }
            }
        }
        int pairNum = 0;
        boolean three = false;
        boolean four = false;
        boolean five = false;
        for (int i = 0; i<cardNum.length; i++){
            if (cardNum[i] == 5){
                five = true;
            } else if (cardNum[i] == 4){
                four = true;
            } else if (cardNum[i] == 3){
                three = true;
            } else if (cardNum[i] == 2){
                pairNum++;
            }
        }
        if (five == true){
            handLevel = 7;
            return "FIVE OF A KIND";
        } else if (four == true){
            handLevel = 6;
            return "FOUR OF A KIND";
        } else if (three == true){
            if (pairNum == 1){
                handLevel = 5;
                return "FULL HOUSE";
            } else {
                handLevel = 4;
                return "THREE OF A KIND";
            }
        } else if (pairNum == 2){
            handLevel = 3;
            return "TWO PAIR";
        } else if (pairNum == 1){
            handLevel = 2;
            return "ONE PAIR";
        } else {
            handLevel = 1;
            return "HIGH CARD";
        }
    }
}