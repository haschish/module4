import java.util.Map;
import java.util.TreeMap;

public class Task12 {
    public static void main (String[] args) {
        TreeMap<String, String> pets = new TreeMap<>();
        pets.put("1", "B");
        pets.put("Abc", "B");
        pets.put("Bbbc", "B");
        pets.put("Cddd", "B");
        pets.put("Ddd", "B");
        pets.put("G", "B");
        pets.put("rty", "B");
        pets.put("H", "B");
        pets.put("I", "B");



        TreeMap<String, String> temp = new TreeMap<>(pets.tailMap("A"));
        TreeMap<String, String> mondayPets = new TreeMap<>(temp.headMap("I"));
        System.out.println(mondayPets);
    }
}
