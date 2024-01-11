import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    int data;
    List<Main> children;

    public Main(int data) {
        this.data = data;
        this.children = new ArrayList<>();
    }

    public void add(int data) {
        this.children.add(new Main(data));
    }

    public static List<Integer> levelWidth(Main root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<Main> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                Main current = queue.poll();
                if (current != null && current.children != null) {
                    queue.addAll(current.children);
                }
            }

            result.add(levelSize);
        }

        return result;
    }

    public static void main(String[] args) {
        // Przykłady testowe
        Main root1 = new Main(0);
        root1.add(1);
        root1.add(2);
        root1.add(3);
        root1.children.get(0).add(4);
        root1.children.get(2).add(5);
        System.out.println(levelWidth(root1)); // Output: [1, 3, 2]

        Main root2 = new Main(0);
        root2.add(1);
        root2.children.get(0).add(2);
        root2.children.get(0).add(3);
        root2.children.get(0).children.get(0).add(4);
        System.out.println(levelWidth(root2)); // Output: [1, 1, 2, 1]

        Main root3 = new Main(0);
        root3.add(1);
        root3.add(2);
        root3.children.get(1).add(3);
        root3.children.get(1).add(4);
        root3.children.get(1).children.get(1).add(5);
        System.out.println(levelWidth(root3)); // Output: [1, 2, 2]

        Main root4 = new Main(0);
        root4.add(1);
        root4.add(2);
        root4.add(3);
        root4.children.get(0).add(4);
        root4.children.get(2).add(5);
        root4.children.get(2).add(6);
        System.out.println(levelWidth(root4)); // Output: [1, 3, 2]

        Main root5 = null;
        System.out.println(levelWidth(root5)); // Output: []
    }
}
