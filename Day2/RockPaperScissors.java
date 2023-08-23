package Day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class RockPaperScissors {
    public static void main(String[] args) {
        ArrayList<Integer> points = new ArrayList<>();

        BufferedReader reader;
        int X = 1;
        int Y = 2;
        int Z = 3;
        int osszeg = 0;

        try {
            reader = new BufferedReader(new FileReader("rock_paper_scissors.txt"));
            String oldline = reader.readLine();

            while (oldline != null) {
                oldline = reader.readLine();
                if ((oldline.charAt(0) == 'A' && oldline.charAt(2) == 'X') ||
                        (oldline.charAt(0) == 'B' && oldline.charAt(2) == 'Y') ||
                        (oldline.charAt(0) == 'C' && oldline.charAt(2) == 'Z')) {
                    osszeg = osszeg + 3;
                }
                if (oldline.charAt(0) == 'A' && oldline.charAt(2) == 'Y') {
                    osszeg = osszeg + 8;
                }
                if (oldline.charAt(0) == 'B' && oldline.charAt(2) == 'Z') {
                    osszeg = osszeg + 9;
                }
                if (oldline.charAt(0) == 'C' && oldline.charAt(2) == 'X') {
                    osszeg = osszeg + 7;
                }
            }
            System.out.println(osszeg);

        } catch (

        IOException e) {
            e.printStackTrace();
        }

    }
}
