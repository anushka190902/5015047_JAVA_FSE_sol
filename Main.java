/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.HashMap;

class Product {
	private int productId;
	private String productName;
	private int quantity;
	private double price;

	public Product(int productId, String productName, int quantity, double price) {
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product ID: " + productId + ", Name: " + productName + ", Quantity: " + quantity + ", Price: $" + price;
	}
}

class Inventory {
	private HashMap<Integer, Product> products;

	public Inventory() {
		products = new HashMap<>();
	}

	// Adding a product to the inventory
	public void addProduct(Product product) {
		products.put(product.getProductId(), product);
	}

	// Update an existing product in the inventory
	public void updateProduct(int productId, String productName, int quantity, double price) {
		Product product = products.get(productId);
		if (product != null) {
			product.setProductName(productName);
			product.setQuantity(quantity);
			product.setPrice(price);
		} else {
			System.out.println("Product with ID " + productId + " not found.");
		}
	}

	// Delete a product from the inventory
	public void deleteProduct(int productId) {
		products.remove(productId);
	}

	// Print all products in the inventory
	public void printInventory() {
		for (Product product : products.values()) {
			System.out.println(product);
		}
	}
}

public class Main {
	public static void main(String[] args) {
		Inventory inventory = new Inventory();
		Product product1 = new Product(1, "Laptop", 10, 999.99);
		Product product2 = new Product(2, "Smartphone", 20, 499.99);

		inventory.addProduct(product1);
		inventory.addProduct(product2);

		System.out.println("Initial Inventory:");
		inventory.printInventory();

		inventory.updateProduct(1, "Gaming Laptop", 5, 1299.99);
		System.out.println("\nInventory after update:");
		inventory.printInventory();

		inventory.deleteProduct(2);
		System.out.println("\nInventory after deletion:");
		inventory.printInventory();
	}
}
