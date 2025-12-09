import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day03Template {
    public static void main(String[] args) {

        // **** DO NOT EDIT ANYTHING HERE ****
        ArrayList<String> fileData = getFileData("src/data");
        int partOneAnswer = 0;
        for (String batteries : fileData) {
            System.out.println(getLargestCombination(batteries));
            int voltage = getLargestCombination(batteries);
            partOneAnswer += voltage;
        }

        System.out.println("Part one answer: " + partOneAnswer);
    }

    // COMPLETE THIS METHOD!
    public static int getLargestCombination(String batteries) {

        int length = batteries.length();
        int largestCombo = 0;

        for (int count = 0; count < length - 1; count++) {
            int largestNumber = Integer.parseInt(batteries.substring(count, count + 1));

            int nextLargestNumber = -1;

            for (int i = count + 1; i < length; i++) {
                int nextNumber = Integer.parseInt(batteries.substring(i, i + 1));
                if (nextNumber > nextLargestNumber) {
                    nextLargestNumber = nextNumber;
                }
            }

            int combo = largestNumber * 10 + nextLargestNumber;

            if (combo > largestCombo) {
                largestCombo = combo;
            }
        }

        return largestCombo;
    }

    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}