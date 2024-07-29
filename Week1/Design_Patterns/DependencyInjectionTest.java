package com.example.dependencyinjection;

interface CustomerRepository {
    Customer findCustomerById(int id);
}
class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public Customer findCustomerById(int id) {
        // For demonstration, returning a dummy customer.
        // In a real application, this would interact with a database.
        return new Customer(id, "John Doe");
    }
}
//package com.example.dependencyinjection;

class CustomerService {
    private final CustomerRepository customerRepository;

    // Constructor injection
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getCustomer(int id) {
        return customerRepository.findCustomerById(id);
    }
}


public class DependencyInjectionTest {
    public static void main(String[] args) {
        // Create an instance of CustomerRepositoryImpl
        CustomerRepository customerRepository = new CustomerRepositoryImpl();

        // Inject the repository into CustomerService
        CustomerService customerService = new CustomerService(customerRepository);

        // Use the service to get a customer
        Customer customer = customerService.getCustomer(1);

        // Display customer details
        System.out.println("Customer ID: " + customer.getId());
        System.out.println("Customer Name: " + customer.getName());
    }
}


class Customer {
    private int id;
    private String name;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}


