import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;

class User {
    String name;
    int age;

    User(String n, int a) {
        name = n;
        age = a;
    }
}

public class Task7 {
    public static void main (String[] args) {
        HashSet collection = new HashSet();
        collection.add("3");
        collection.add("21");
        collection.add("1");
        collection.add("25");

        for (Object obj: collection){
            System.out.print(obj + " ");
        }
//        class UserComparator implements Comparator<User> {
//            @Override
//            public int compare(User u1, User u2) {
//                return u1.name.compareTo(u2.name);
//            }
//        }
//
//        TreeSet<User> tree = new TreeSet<>(new UserComparator());
//
//        tree.add(new User("p", 18));
//        tree.add(new User("n", 20));
//
//        for (User u : tree) {
//            System.out.println(u.name);
//        }
    }
}
