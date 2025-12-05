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
        String largestCombo = "";
        int largestNumber = 0;
        int length = batteries.length();
        for (int count = 0; count < length; count++) {
            int nextNumber = Integer.parseInt(batteries.substring(count, count + 1));
            if (largestNumber < nextNumber) {
                largestNumber = nextNumber;
            }
        }
        largestCombo += String.valueOf(largestNumber);

        int nextLargestNumber = 0;
        boolean check = false;

        for (int count = 0; count < length; count++) {
            int nextNumber = Integer.parseInt(batteries.substring (count, count + 1));
            if (largestNumber == nextNumber) {
                if (!check) {
                    check = true;
                } else {
                    nextLargestNumber = nextNumber;
                }
            }
            if (nextNumber != largestNumber && nextNumber > nextLargestNumber) {
                nextLargestNumber = nextNumber;
            }
        }
        largestCombo += String.valueOf(nextLargestNumber);

        return Integer.parseInt(largestCombo);
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