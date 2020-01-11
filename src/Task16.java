import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Task16 {
    static Scanner in = new Scanner(System.in);

    public static void main (String[] args) {
        TreeMap<String, TreeMap<String, Integer>> buyers = new TreeMap<>();

        while (in.hasNextLine()) {
            String line = in.nextLine();
            if (line.equals("")) {
                break;
            }
            String[] arr = line.split(" ");

            String name = arr[0];
            String product = arr[1];
            Integer value = Integer.parseInt(arr[2]);

            if (!buyers.containsKey(name)) {
                buyers.put(name, new TreeMap<String, Integer>());
            }

            TreeMap<String, Integer> basket = buyers.get(name);
            putProduct(basket, product, value);
        }

        for (Map.Entry<String, TreeMap<String, Integer>> entry : buyers.entrySet()) {
            System.out.println(entry.getKey() + ":");
            printBasket(entry.getValue());
        }
    }
    static void putProduct(TreeMap<String, Integer> basket, String name, Integer value) {
        if (basket.containsKey(name)) {
            value = (Integer)basket.get(name) + value;
        }
        basket.put(name, value);
    }

    static void printBasket(TreeMap<String, Integer> basket) {
        for (Map.Entry<String, Integer> entry : basket.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
