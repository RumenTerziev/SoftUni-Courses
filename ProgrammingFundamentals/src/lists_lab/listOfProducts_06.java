package lists_lab;

import java.util.*;
import java.util.stream.Collectors;

public class listOfProducts_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<String> productList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String currentProduct = scanner.nextLine();
            productList.add(currentProduct);
        }

        Collections.sort(productList);

        for (int i = 0; i <= productList.size() - 1; i++) {
            System.out.printf("%d.%s%n", i + 1, productList.get(i));
        }
    }
}
