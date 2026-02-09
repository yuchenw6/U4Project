import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Hand {
    private String[] hand;
    private int bid;
    private int handLevel;
    private String[] cardType = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    public Hand(String[] hand, int bid){
        this.hand = hand;
        this.bid = bid;
        handLevel = 0;

    }

    public int calculateHand() {
        int same = 0;
        int[] cardNum = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0; i < hand.length; i++) {
            for (int a = 0; a < cardType.length; a++) {
                if (hand[i].equals(cardType[a])) {
                    cardNum[a] = cardNum[a] + 1;
                }
            }
        }
        int pairNum = 0;
        int three = 0;
        int four = 0;
        int five = 0;
        for (int i = 0; i<cardNum.length; i++){
            if (cardNum[i] == 5){
                five++;
            } else if (cardNum[i] == 4){
                four++;
            } else if (cardNum[i] == 3){
                three++;
            } else if (cardNum[i] == 2){
                pairNum++;
            }
        }
        if (five == 1){
            handLevel = 7;
            return 7;
        } else if (four == 1){
            handLevel = 6;
            return 6;
        } else if (three == 1){
            if (pairNum == 1){
                handLevel = 5;
                return 5;
            } else {
                handLevel = 4;
                return 4;
            }
        } else if (pairNum == 2){
            handLevel = 3;
            return 3;
        } else if (pairNum == 1){
            handLevel = 2;
            return 2;
        } else {
            handLevel = 1;
            return 1;
        }
    }

    public String[] getHand(){
        return hand;
    }

    public int getBid() {
        return bid;
    }

    public int getHandLevel(){
        return handLevel;
    }

    public int calculateJack(){
        int highestLevel = 0;
        String[] originalList = new String[5];
        for (int i = 0; i < 5; i++){
            originalList[i] = hand[i];
        }
        for (int i = 0; i < cardType.length; i++){
            for (int a = 0; a < 5; a++){
                if (hand[a].equals("Jack")){
                    hand[a] = cardType[i];
                }
            }
            int jackResult = calculateHand();
            if (jackResult > highestLevel){
                highestLevel = jackResult;
            }
            for (int b = 0; b < 5; b++){
                hand[b] = originalList[b];
            }
        }
        return highestLevel;
    }

}