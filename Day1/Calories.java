import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Calories {
    public static void main(String[] args) {
        BufferedReader reader;
        ArrayList<Integer> calories = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader("calorie_chart.txt"));
            String oldline = reader.readLine();
            int osszeg = 0;

            while (oldline != null) {

                if (oldline.isEmpty()) {
                    calories.add(osszeg);
                    osszeg = 0;
                } else {

                    osszeg = osszeg + Integer.parseInt(oldline);
                }
                oldline = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int legnagyobb = 0;
        for (int i = 0; i < calories.size(); i++) {
            if (legnagyobb < calories.get(i)) {
                legnagyobb = calories.get(i);
            }
        }
        System.out.println("The highest calorie holder elf has: " + legnagyobb + "/Cal");

        partTwo(calories);
    }

    public static void partTwo(ArrayList<Integer> calories) {

        ArrayList<Integer> highestCalories = new ArrayList<>();
        int n = 0;
        int i = 0;
        int legnagyobb = 0;

        for (n = 0; n < 3; n++) {
            for (i = 0; i < calories.size(); i++) {
                if (legnagyobb < calories.get(i)) {
                    legnagyobb = calories.get(i);
                }
            }
            System.out.println(i);
            highestCalories.add(legnagyobb);
            calories.remove(Integer.valueOf(legnagyobb));
            legnagyobb = 0;
        }

        int topThree = 0;

        for (int t = 0; t < highestCalories.size(); t++) {
            topThree = topThree + highestCalories.get(t);
        }

        System.out.println(topThree);
    }
}