//Collections: 1.   Ввести строки из файла, записать в список. Вывести строки в файл в обратном порядке.

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class ReverseRecorder {

    public static void main(String[] args) throws Exception {

        String filePath = "/Java//ReverseRecorder//src//main//resources//";
        String fileNameIn = "list.txt";
        String fileNameOut = "reverseList.txt";

        BufferedReader bufReader = new BufferedReader(new FileReader(filePath + fileNameIn));

        ArrayList<String> listOfStrings = new ArrayList<>();

        String strings = bufReader.readLine();
        while (strings != null) {
            listOfStrings.add(strings);
            strings = bufReader.readLine();
        }
        bufReader.close();

        System.out.println("Read from file and convert to ArrayList:");
        System.out.println(listOfStrings);
        System.out.println();

        Collections.reverse(listOfStrings);
        System.out.println("Reverse of ArrayList:");
        System.out.println(listOfStrings);

        FileWriter writer = new FileWriter(filePath + fileNameOut);
        for(String str: listOfStrings) {
            writer.write(str + System.lineSeparator());
        }

        writer.close();
    }
}