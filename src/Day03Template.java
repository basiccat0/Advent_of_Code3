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
        int largestNumber = 0;

        for (int i = 0; i < length - 1; i++) {
            int leftDigit = Integer.parseInt(batteries.substring(i, i + 1));

            int maxRightDigit = -1;

            // find largest digit to the right
            for (int j = i + 1; j < length; j++) {
                int rightDigit = Integer.parseInt(batteries.substring(j, j + 1));
                if (rightDigit > maxRightDigit) {
                    maxRightDigit = rightDigit;
                }
            }

            // form number leftDigit + maxRightDigit
            int combo = leftDigit * 10 + maxRightDigit;

            if (combo > largestNumber) {
                largestNumber = combo;
            }
        }

        return largestNumber;
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