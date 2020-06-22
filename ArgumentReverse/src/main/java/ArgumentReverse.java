// Fundamentals: 2.Отобразить в окне консоли аргументы командной строки в обратном порядке.

public class ArgumentReverse {

    public static void main(String[] args) {

        StringBuffer sb = new StringBuffer("reverse");
        System.out.println(sb);
        sb.reverse();
        System.out.println(sb);
    }

}
