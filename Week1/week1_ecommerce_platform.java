import java.util.Arrays;
import java.util.Comparator;

class Product {
    private int productId;
    private String productName;
    private String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Product ID: " + productId + ", Name: " + productName + ", Category: " + category;
    }
}

public class ProductSearch {
    // Linear Search
    public static Product linearSearch(Product[] products, int productId) {
        for (Product product : products) {
            if (product.getProductId() == productId) {
                return product;
            }
        }
        return null;
    }

    // Binary Search
    public static Product binarySearch(Product[] products, int productId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (products[mid].getProductId() == productId) {
                return products[mid];
            } else if (products[mid].getProductId() < productId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(3, "Laptop", "Electronics"),
            new Product(1, "Smartphone", "Electronics"),
            new Product(2, "Tablet", "Electronics"),
            new Product(5, "Chair", "Furniture"),
            new Product(4, "Desk", "Furniture")
        };

        // Sort the array for binary search
        Arrays.sort(products, Comparator.comparingInt(Product::getProductId));

        System.out.println("Products array:");
        for (Product product : products) {
            System.out.println(product);
        }

        int searchId = 2;

        // Linear search
        Product resultLinear = linearSearch(products, searchId);
        System.out.println("\nLinear Search Result:");
        System.out.println(resultLinear != null ? resultLinear : "Product not found");

        // Binary search
        Product resultBinary = binarySearch(products, searchId);
        System.out.println("\nBinary Search Result:");
        System.out.println(resultBinary != null ? resultBinary : "Product not found");
    }
}
