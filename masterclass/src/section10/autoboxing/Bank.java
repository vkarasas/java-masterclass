package section10.autoboxing;

import java.util.ArrayList;

public class Bank {

    private String name;
    private ArrayList<CustomerAutoboxing> customerAutoboxings = new ArrayList<>(5000);

    public Bank(String name) {
        this.name = name;
    }

    private CustomerAutoboxing getCustomer(String customerName) {
        for (var customer: customerAutoboxings) {
            if(customer.name().equalsIgnoreCase(customerName)) {
                return customer;
            }
        }
        System.out.printf("Customer (%s) wasn't found %n", customerName);
        return null;
    }

    public void addNewCustomer(String customerName, double initialDeposit) {
        if(getCustomer(customerName) == null) {
            CustomerAutoboxing customerAutoboxing = new CustomerAutoboxing(customerName, initialDeposit);
            customerAutoboxings.add(customerAutoboxing);
            System.out.println("New Customer added: " + customerAutoboxing);
        }
    }

    public void addTransaction(String name, double transactionAmount) {
        CustomerAutoboxing customerAutoboxing = getCustomer(name);
        if (customerAutoboxing != null) {
            customerAutoboxing.transactions().add(transactionAmount);
        }
    }

    public void printStatement(String customerName) {
        CustomerAutoboxing customerAutoboxing = getCustomer(customerName);
        if (customerAutoboxing == null) {
            return;
        }
        System.out.println("-".repeat(30));
        System.out.println("Customer Name: " + customerAutoboxing.name());
        System.out.println("Transactions:");
        for (double d: customerAutoboxing.transactions()) {
            System.out.printf("$%10.2f (%s)%n", d, d < 0 ? "debit": "credit");
        }
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", customers=" + customerAutoboxings +
                '}';
    }
}
