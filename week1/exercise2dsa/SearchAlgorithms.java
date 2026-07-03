import java.util.Arrays;
import java.util.Comparator;

public class SearchAlgorithms {

    // Linear Search
    public static Product linearSearch(Product[] products, int id) {

        for (Product product : products) {
            if (product.productId == id) {
                return product;
            }
        }
        return null;
    }

    // Binary Search
    public static Product binarySearch(Product[] products, int id) {

        int low = 0;
        int high = products.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (products[mid].productId == id) {
                return products[mid];
            }

            if (products[mid].productId < id) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        Product[] products = {
                new Product(104, "Shoes", "Fashion"),
                new Product(101, "Laptop", "Electronics"),
                new Product(105, "Watch", "Accessories"),
                new Product(103, "Phone", "Electronics"),
                new Product(102, "Book", "Education")
        };

        // Linear Search
        System.out.println("Linear Search:");

        Product result1 = linearSearch(products, 103);

        if (result1 != null)
            result1.display();
        else
            System.out.println("Product not found");

        // Sort array for Binary Search
        Arrays.sort(products, Comparator.comparingInt(p -> p.productId));

        System.out.println("\nBinary Search:");

        Product result2 = binarySearch(products, 103);

        if (result2 != null)
            result2.display();
        else
            System.out.println("Product not found");
    }
}