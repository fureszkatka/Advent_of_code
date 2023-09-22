package Day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Racksacks {
    public static void main(String[] args) {
        ArrayList<Character> duplicants = new ArrayList<>();
        BufferedReader reader;
        long osszeg = 0;
        try {
            reader = new BufferedReader(new FileReader("Racksacks_items.txt"));
            String oldline = reader.readLine();

            while (oldline != null) {
                int length = oldline.length();
                int half = length / 2;
                int i = 0;
                while (i < half) {
                    int n = half;
                    while (n < length) {
                        if (oldline.charAt(i) == oldline.charAt(n)) {
                            duplicants.add(oldline.charAt(n));
                            n = length;
                            i = half;
                        }
                        n++;
                    }
                    System.out.print(i);
                    i++;
                }

                oldline = reader.readLine();
            }

            System.out.println(duplicants);

            for (int s = 0; s < duplicants.size(); s++) {
                char character = duplicants.get(s);

                if (Character.isUpperCase(character)) {
                    osszeg += character - 'A' + 27;
                    System.out.println(character - 'A' + 27);
                } else {
                    osszeg += character - 'a' + 1;
                    System.out.println(character - 'a' + 1);
                }

            }
            System.out.println("duplicants: " + osszeg);

        } catch (

        IOException e) {
            e.printStackTrace();
        }
    }
}
