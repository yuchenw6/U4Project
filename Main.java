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

        int[] numOfEachType = {0, 0, 0, 0, 0, 0, 0};
        System.out.println(fileData);
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
        System.out.println("Number of four of a kind hands: " + numOfEachType[5]);
        System.out.println("Number of full houses: " + numOfEachType[4]);
        System.out.println("Number of three of a kind hands: " + numOfEachType[3]);
        System.out.println("Number of two pairs: " + numOfEachType[2]);
        System.out.println("Number of one pairs: " + numOfEachType[1]);
        System.out.println("Number of high cards: " + numOfEachType[0]);


        for (int i = 0; i < lines.length; i++){
            Hand currentHand = allHand[i];
            for (int a = 0; a < lines.length; a++){
                if (currentHand.)
            }
        }

    }
}