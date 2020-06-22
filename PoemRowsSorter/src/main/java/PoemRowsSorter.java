//Collections: 4.   Занести стихотворение в список. Провести сортировку по возрастанию длин строк.

import java.util.*;

public class PoemRowsSorter {

    public static void main(String args[]) {

        ArrayList<String> poemLines = new ArrayList<String>();

        poemLines.add("I held a moment in my hand,");
        poemLines.add("Brilliant as a star,");
        poemLines.add("Fragile as a flower,");
        poemLines.add("A shiny silver out of one hour.");
        poemLines.add("I dropped it carelessly.");
        poemLines.add("Oh God! I knew not");
        poemLines.add("I held opportunity.");

        System.out.println("The original poem without sorting:");
        System.out.println();

        for (int i = 0; i < poemLines.size(); i++)
            System.out.println(poemLines.get(i));

        Comparator<String> byLength = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        };

        Collections.sort(poemLines, byLength);
        System.out.println();
        System.out.println("The same poem after sorting string by length:");
        System.out.println();

        for(String raw: poemLines) {
            System.out.println(raw);
        }
    }
}

