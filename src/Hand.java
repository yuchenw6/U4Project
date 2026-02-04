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

    public int calculateHand() {
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
}