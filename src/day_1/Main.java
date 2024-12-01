package day_1;

import java.util.*;
import java.io.*;

public class Main {
    public static int getTotalDistance(int[] list1, int[] list2) {
        if(list1.length != list2.length) {
            throw new IllegalArgumentException("Arrays lenght is not equal");
        }

        int loopLength = list1.length;
        int totalDistance = 0;
        Arrays.sort(list1);
        Arrays.sort(list2);

        for (int i = 0; i < loopLength; i++) {
            totalDistance = totalDistance + Math.abs(list1[i] - list2[i]);
        }

        return totalDistance;
    }
    public static void main(String[] args) {
        List<Integer> column1 = new ArrayList<>();
        List<Integer> column2 = new ArrayList<>();
        String filePath = "input.txt";
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.trim().split("\\s+");

                if (parts.length == 2) {
                    column1.add(Integer.parseInt(parts[0]));
                    column2.add(Integer.parseInt(parts[1]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int[] column1Array = column1.stream().mapToInt(i->i).toArray();
        int[] column2Array = column2.stream().mapToInt(i->i).toArray();

        System.out.println(getTotalDistance(column1Array,column2Array));
//        int[] list1 = {3,4,2,1,3,3};
//        int[] list2 = {4,3,5,3,9,3};
//
//        int totalDistance = getTotalDistance(list1, list2);
//        System.out.println(totalDistance);
    }
}