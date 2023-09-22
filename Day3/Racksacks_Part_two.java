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

        Map<Character, List<Integer>> similar = new HashMap<>();
        ArrayList<String> lines = new ArrayList<>();

        try {
            reader = new BufferedReader(new FileReader("proba.txt"));
            String oldline = reader.readLine();

            int i = 1;
            Character compare;

            while (oldline != null) {
                lines.add(oldline);
                oldline = reader.readLine();
            }

            while (i < lines.size()) {

                if (i % 3 == 0) {
                    int n = 0;
                    String first = lines.get(i - 3);
                    String second = lines.get(i - 2);
                    String third = lines.get(i - 1);

                    while (n < first.length()) {
                        compare = first.charAt(n);

                        for (int f = 0; f < first.length(); f++) {
                            if (compare == first.charAt(n)) {
                                List<Integer> arrayList = new ArrayList<>();
                                arrayList.add(1);
                                arrayList.add(0);
                                arrayList.add(0);

                                similar.put(compare, arrayList);
                            }
                        }
                        for (int s = 0; s < second.length(); s++) {
                            if (compare == second.charAt(n)) {
                                List<Integer> foundList = similar.get(compare);
                                foundList.set(1, 1);
                            }
                        }
                        for (int t = 0; t < third.length(); t++) {
                            if (compare == third.charAt(n)) {
                                List<Integer> foundList = similar.get(compare);
                                foundList.set(2, 1);
                            }
                        }
                        n++;
                    }
                }
                i++;
            }
            System.out.println(similar);

        } catch (

        IOException e) {
            e.printStackTrace();
        }
    }
}