class Order {
    int orderId;
    String customerName;
    double totalPrice;

    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerName='" + customerName + '\'' +
                ", totalPrice=" + totalPrice +
                '}';
    }
}

public class OrderSorter {

    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (orders[j].totalPrice > orders[j+1].totalPrice) {
                    // swap orders[j+1] and orders[j]
                    Order temp = orders[j];
                    orders[j] = orders[j+1];
                    orders[j+1] = temp;
                }
            }
        }
    }

    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi-1);
            quickSort(orders, pi+1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = (low-1); // index of smaller element
        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice <= pivot) {
                i++;
                // swap orders[i] and orders[j]
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }

        // swap orders[i+1] and orders[high] (or pivot)
        Order temp = orders[i+1];
        orders[i+1] = orders[high];
        orders[high] = temp;

        return i+1;
    }

    public static void main(String[] args) {
        Order[] orders = {
            new Order(1, "Customer A", 300.50),
            new Order(2, "Customer B", 150.75),
            new Order(3, "Customer C", 450.00),
            new Order(4, "Customer D", 250.25)
        };

        System.out.println("Original Order List:");
        for (Order order : orders) {
            System.out.println(order);
        }

        // Bubble Sort
        bubbleSort(orders);
        System.out.println("\nOrder List after Bubble Sort:");
        for (Order order : orders) {
            System.out.println(order);
        }

        // Re-initializing the orders array to demonstrate Quick Sort
        orders = new Order[]{
            new Order(1, "Customer A", 300.50),
            new Order(2, "Customer B", 150.75),
            new Order(3, "Customer C", 450.00),
            new Order(4, "Customer D", 250.25)
        };

        // Quick Sort
        quickSort(orders, 0, orders.length - 1);
        System.out.println("\nOrder List after Quick Sort:");
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}
