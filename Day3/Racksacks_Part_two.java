package Day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Racksacks_Part_two {

    public static void main(String[] args) {
        BufferedReader reader;

        ArrayList<String> lines = new ArrayList<>();

        try {
            reader = new BufferedReader(new FileReader("Racksacks_items.txt"));
            String oldline = reader.readLine();
            List<Map<Character, List<Integer>>> outterArray = new ArrayList<>();

            Character compare;

            while (oldline != null) {
                lines.add(oldline);
                oldline = reader.readLine();
            }

            for (int i = 2; i < lines.size(); i += 3) {

                int n = 0;
                String first = lines.get(i - 2);
                String second = lines.get(i - 1);
                String third = lines.get(i);
                Map<Character, List<Integer>> similar = new HashMap<>();

                while (n < first.length()) {
                    compare = first.charAt(n);
                    for (int f = 0; f < first.length(); f++) {
                        if (compare == first.charAt(f)) {
                            List<Integer> arrayList = new ArrayList<>();
                            arrayList.add(1);
                            arrayList.add(0);
                            arrayList.add(0);

                            similar.put(compare, arrayList);

                        }
                    }
                    for (int s = 0; s < second.length(); s++) {
                        if (compare == second.charAt(s)) {
                            similar.get(compare).set(1, 1);
                        }
                    }

                    // hashmap={
                    // "s": [2,3,1,42],
                    // "s": [2,3,1,42],
                    // "s": [2,3,1,42],
                    // }

                    for (int t = 0; t < third.length(); t++) {
                        if (compare == third.charAt(t)) {
                            similar.get(compare).set(2, 1);
                        }
                    }
                    n++;
                }
                outterArray.add(similar);
            }
            System.out.println(outterArray);

            ArrayList<Character> duplicants = new ArrayList<>();

            for (int i = 0; i < outterArray.size(); i++) {
                outterArray.get(i).forEach((key, value) -> {

                    int osszeg = 0;

                    osszeg += value.get(0);
                    osszeg += value.get(1);
                    osszeg += value.get(2);

                    if (osszeg == 3) {
                        duplicants.add(key);
                    }
                });
            }

            int letterSum = 0;

            for (int s = 0; s < duplicants.size(); s++) {
                char character = duplicants.get(s);

                if (Character.isUpperCase(character)) {
                    letterSum += character - 'A' + 27;
                } else {
                    letterSum += character - 'a' + 1;
                }

            }
            System.out.print(letterSum);

        } catch (

        IOException e) {
            e.printStackTrace();
        }
    }
}