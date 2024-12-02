package day_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static Object[] transferTo2DArrayWithSafety(String filePath) {
        List<int[]> records = new ArrayList<>();
        List<String> safetyStatus = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.trim().split("\\s+");
                int[] eachRecord = new int[parts.length];
                for (int i = 0; i < parts.length; i++) {
                    eachRecord[i] = Integer.parseInt(parts[i]);
                }
                records.add(eachRecord);
                safetyStatus.add(checkRowSafety(eachRecord));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Object[] {
                records.toArray(new int[records.size()][]),
                safetyStatus.toArray(new String[0])
        };
    }

    private static String checkRowSafety(int[] row) {
        boolean isIncreasing = false;
        boolean isDecreasing = false;

        for (int i = 1; i < row.length; i++) {
            if (row[i] > row[i - 1]) {
                isIncreasing = true;
            } else if (row[i] < row[i - 1]) {
                isDecreasing = true;
            }

            if (isIncreasing && isDecreasing) {
                return "Unsafe";
            }
        }
        return "Safe";
    }

    public static void main(String[] args) {
        String filePath = "data.txt";

        Object[] result = transferTo2DArrayWithSafety(filePath);

        int[][] data = (int[][]) result[0];
        String[] safetyStatus = (String[]) result[1];

        System.out.println("Contents of the 2D Array with Safety Status:");
        for (int i = 0; i < data.length; i++) {
            for (int value : data[i]) {
                System.out.print(value + " ");
            }
            System.out.println("-> " + safetyStatus[i]);
        }
    }
}
