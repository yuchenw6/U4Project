import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String fileData = "";
        try {
            File f = new File("src/data");
            Scanner s = new Scanner(f);

            while (s.hasNextLine()) {
                String line = s.nextLine();
                fileData += line + "\n";
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        String[] jackCardType = {"Jack", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Queen", "King", "Ace"};
        String[] cardType = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        int[] numOfEachType = {0, 0, 0, 0, 0, 0, 0};

        String[] lines = fileData.split("\n");
        Hand[] allHand = new Hand[lines.length];
        int[] power = new int[lines.length];
        for (int i = 0; i< lines.length; i++){
            power[i] = 1;
        }
        int counter = 0;
        for (String line : lines) {
            String[] hands = line.split(",");
            String[] bid = hands[4].split("\\|");
            hands[4] = bid[0];
            int bidValue = Integer.parseInt(bid[1]);
            Hand hand1 = new Hand(hands, bidValue);
            allHand[counter] = hand1;
            counter++;
            int handResult = hand1.calculateHand();
            numOfEachType[handResult-1] = numOfEachType[handResult-1] + 1;
        }
        System.out.println("Number of five of a kind hands: " + numOfEachType[6]);
        System.out.println("Number of full house hands: " + numOfEachType[4]);
        System.out.println("Number of four of a kind hands: " + numOfEachType[5]);
        System.out.println("Number of three of a kind hands: " + numOfEachType[3]);
        System.out.println("Number of two pair hands: " + numOfEachType[2]);
        System.out.println("Number of one pair hands: " + numOfEachType[1]);
        System.out.println("Number of high card hands: " + numOfEachType[0]);

        for (int z = 0; z < 2; z++) {
            for (int i = 0; i < lines.length; i++) {
                Hand currentHand = allHand[i];
                for (int a = 0; a < lines.length; a++) {
                    if (currentHand.getHandLevel() > allHand[a].getHandLevel()) {
                        power[i]++;
                    } else if (currentHand.getHandLevel() == allHand[a].getHandLevel()) {
                        String[] currentList = currentHand.getHand();
                        String[] nextList = allHand[a].getHand();

                        for (int b = 0; b < 5; b++) {
                            int currentCardStrength = 0;
                            int nextCardStrength = 0;
                            for (int c = 0; c < cardType.length; c++) {
                                if (currentList[b].equals(cardType[c])) {
                                    currentCardStrength = c;
                                }
                                if (nextList[b].equals(cardType[c])) {
                                    nextCardStrength = c;
                                }
                            }
                            if (currentCardStrength > nextCardStrength) {
                                power[i]++;
                                b = 5;
                            } else if (currentCardStrength < nextCardStrength) {
                                b = 5;
                            }
                        }
                    }
                }
            }
            if (z == 0){
                int totalBidResult = 0;
                for (int i = 0; i < power.length; i++) {
                    totalBidResult += power[i] * allHand[i].getBid();
                }
                System.out.println("Total Bid Value: " + totalBidResult);

                for (int i = 0; i < 13; i++){
                    cardType[i] = jackCardType[i];
                }
                for(int i = 0; i < allHand.length; i++){
                    allHand[i].calculateJack();
                    power[i] = 1;
                }
            } else {
                int jackBidResult = 0;
                for (int i = 0; i < power.length; i++) {
                    jackBidResult += power[i] * allHand[i].getBid();
                }
                System.out.println("Total Bid Value With Jacks Wild: " + jackBidResult);
            }
        }
    }
}