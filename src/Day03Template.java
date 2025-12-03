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
        int position = 0;
        int count = 0;
        int largestNumber = Integer.parseInt(batteries.substring(0, 1));
        int length = batteries.length();
        while (count < length) {
            int nextNumber = Integer.parseInt(batteries.substring(count, count + 1));
            count ++;
            if (largestNumber < nextNumber) {
                largestNumber = nextNumber;
                position = count;
            }
        }
        largestCombo += String.valueOf(largestNumber);

        String nextLargest = "";
        while (position < length) {
            int nextNumber = Integer.parseInt(batteries.substring(position, position + 1));
            count ++;
            if (largestNumber < nextNumber) {
                largestNumber = nextNumber;
            }
        }

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