package loops;

public class Example5 {
    public static void main(String[] args) {
        int i;
        for (i = 0; i < 5; i++) {
            if (i >= 2) {
                break;
            }
            System.out.println("Yuhu");
        }
        System.out.println(i);
        // Output:
        // Yuhu
        // Yuhu
        // 2

    }
}
