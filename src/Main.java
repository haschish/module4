
//import java.util.*;

import java.util.*;

class BinaryTree {
    int value;
    BinaryTree lchild; // левый потомок
    BinaryTree rchild; // правый потомок

    public BinaryTree(int value) {
        this.value = value;
        this.lchild = null;
        this.rchild = null;
    }

    public BinaryTree insertNode(BinaryTree node, int targetValue) {
        if (node == null) {
            node = new BinaryTree(targetValue);
            return node;
        }

        if (node.value > targetValue) {
            if (node.lchild == null) {
                return node.lchild = new BinaryTree(targetValue);
            }

            return insertNode(node.lchild, targetValue);
        }
        else if (node.value < targetValue) {
            if (node.rchild == null) {
                return node.rchild = new BinaryTree(targetValue);
            }

            return insertNode(node.rchild, targetValue);
        }
        return null;
    }

    public static boolean isNormalize(BinaryTree node) {
        if (node == null) {
            return true;
        }

        int lHeight = BinaryTree.getHeight(node.lchild);
        int rHeight = BinaryTree.getHeight(node.rchild);

        boolean normalized = Math.abs(lHeight - rHeight) <= 1;

        return normalized && BinaryTree.isNormalize(node.lchild) && BinaryTree.isNormalize(node.rchild);
    }

    public static int getHeight(BinaryTree node) {
        if (node == null) {
            return -1;
        }

        int lHeight = getHeight(node.lchild);
        int rHeight = getHeight(node.rchild);
        return Math.max(lHeight, rHeight) + 1;
    }

    public void printBinaryTree(BinaryTree node, int level) {
        if (node != null) {
            printBinaryTree(node.lchild, level + 1);
            for (int i = 0; i < level; i++)
                System.out.print("   ");//чем ниже уровень, тем отступ больше
            System.out.println(node.value);
            printBinaryTree(node.rchild, level + 1);
        }
    }
}

class Player implements Comparable<Player> {
    int id;
    int value;
    public Player(int id, int value) {
        this.id = id;
        this.value = value;
    }

    @Override
    public int compareTo(Player o) {
        if (value < o.value) {
            return 1;
        } else if (value > o.value) {
            return -1;
        } else {
            if (id > o.id) {
                return 1;
            } else if (id < o.id) {
                return -1;
            }
        }

        return 0;
    }
}



public class Main {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        class UserComparator implements Comparator<User> {
            @Override
            public int compare(User u1, User u2) {
                return u1.name.compareTo(u2.name);
            }
        }

        TreeSet<User> tree = new TreeSet<>(new UserComparator());
        tree.add(new User("p", 18));
        tree.add(new User("n", 20));

        for (User u : tree) {
            System.out.println(u.name);
        }
//        HashSet collection = new HashSet();
//        collection.add("3");
//        collection.add("21");
//        collection.add("1");
//        collection.add("25");
//        for (Object obj: collection){
//            System.out.print(obj + " ");
//        }
        TreeMap<String, TreeMap> buyers = new TreeMap<>();

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

            TreeMap basket = buyers.get(name);
            putProduct(basket, product, value);
        }

        for (Map.Entry<String, TreeMap> entry : buyers.entrySet()) {
            System.out.println(entry.getKey() + ":");
            printBasket(entry.getValue());
        }
    }

    static void putProduct(TreeMap basket, String name, Integer value) {
        if (basket.containsKey(name)) {
            value = (Integer)basket.get(name) + value;
        }
        basket.put(name, value);
    }

    static void printBasket(TreeMap basket) {
        for (Object entry : basket.entrySet()) {
            Map.Entry<String, Integer> item = (Map.Entry) entry;
            System.out.println(item.getKey() + " " + item.getValue());
        }
    }
}
