public class NumbersEndingIn7_01 {
    public static void main(String[] args) {

        for (int num = 1; num <= 1000; num++) {
            if (num % 10 == 7) {
                System.out.println(num);
            }
        }
    }
}
