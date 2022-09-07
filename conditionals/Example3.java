package conditionals;

public class Example3 {
    public static void main(String[] args) {
        int a = 4;
        int result = a == 4 ? 1 : 8;
        // result will be 1
        // This is equivalent to
        

        if (a == 4) {
            result = 1;
        } else {
            result = 8;
        }
        System.out.print(result);

    }
}
