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

        System.out.println(fileData);
        String[] lines = fileData.split("\n");

        for (String line : lines) {
            String[] hands = line.split(",");
            String[] bid = hands[4].split("\\|");
            hands[4] = bid[0];
            int bidValue = Integer.parseInt(bid[1]);
            Hand hand1 = new Hand(hands, bidValue);
            String handResult = hand1.calculate();
            System.out.println(handResult);
        }
    }

}