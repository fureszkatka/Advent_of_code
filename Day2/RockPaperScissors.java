package Day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RockPaperScissors {
    public static void main(String[] args) {

        BufferedReader reader;
        int osszeg = 0;

        int X = 1;
        int Y = 2;
        int Z = 3;

        int win = 6;
        int tie = 3;
        int lose = 0;

        try {
            reader = new BufferedReader(new FileReader("rock_paper_scissors.txt"));
            String oldline = reader.readLine();

            while (oldline != null) {

                if (oldline.charAt(2) == 'X') {
                    if (oldline.charAt(0) == 'A') {
                        osszeg += Z + lose;
                    }
                    if (oldline.charAt(0) == 'B') {
                        osszeg += X + lose;
                    }
                    if (oldline.charAt(0) == 'C') {
                        osszeg += Y + lose;
                    }
                }
                if (oldline.charAt(2) == 'Y') {
                    if (oldline.charAt(0) == 'A') {
                        osszeg += X + tie;
                    }
                    if (oldline.charAt(0) == 'B') {
                        osszeg += Y + tie;
                    }
                    if (oldline.charAt(0) == 'C') {
                        osszeg += Z + tie;
                    }
                }
                if (oldline.charAt(2) == 'Z') {
                    if (oldline.charAt(0) == 'A') {
                        osszeg += Y + win;
                    }
                    if (oldline.charAt(0) == 'B') {
                        osszeg += Z + win;
                    }
                    if (oldline.charAt(0) == 'C') {
                        osszeg += X + win;
                    }
                }
                System.out.println(osszeg);
                oldline = reader.readLine();

            }
            System.out.println(osszeg);

        } catch (

        IOException e) {
            e.printStackTrace();
        }

    }
}
