public class Menu {

    void showMenu() {
        System.out.println();
        System.out.println("Welcome to the Taxi station application:\n");
        System.out.println(" 1. Car types");
        System.out.println(" 2. All cars");
        System.out.println(" 3. Total cost of all cars");
        System.out.println(" 4. Sorting cars by fuel consumption");
        System.out.println(" 5. Cars with 110-130 range speed\n");
        System.out.print(" Choice (q to quit): ");
    }

    boolean isValid(int choice) {
        if (choice < '1' | choice > '5' & choice != 'q') return false;
        else return true;
    }
}
