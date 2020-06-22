//Collections: 6. Ввести строки из файла, записать в список ArrayList. Выполнить сортировку строк, используя метод sort() из класса Collections.

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FileSorter {

    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(new File("/Java//FileSorter//src//main//resources//document.txt"));
        ArrayList list = new ArrayList();

        while(s.hasNext()) {
            list.add(s.nextLine());
        }

        s.close();
        System.out.println("Read content from file and convert to list:");
        System.out.println(list);
        System.out.println();
        Collections.sort(list);
        System.out.println("Sort of ArrayList:");
        System.out.println(list);
    }
}
