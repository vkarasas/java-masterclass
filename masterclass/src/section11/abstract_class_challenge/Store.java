package section11.abstract_class_challenge;

import java.util.ArrayList;

public class Store {

    private static final ArrayList<ProductForSale> STORE_PRODUCTS = new ArrayList<>();

    public static void main(String[] args) {

        STORE_PRODUCTS.add(
                new ArtObject("Oil Painting", 1350, "Impressionistic work by ABF painted in 2010")
        );

        STORE_PRODUCTS.add(
                new ArtObject("Sculpture", 2000, "Bronze work by JFK, produced in 1950")
        );

        STORE_PRODUCTS.add(
                new Furniture("Desk", 500, "Mahogany Desk")
        );

        STORE_PRODUCTS.add(
                new Furniture("Lamp", 200, "Tiffany Lamp with Hummingbirds")
        );

        listProducts();

        System.out.println("\nOrder 1");
        var order1 = new ArrayList<OrderItem>();
        addItemToOrder(order1, 1, 2);
        addItemToOrder(order1, 0, 1);
        printOrder(order1);

        System.out.println("\nOrder 2");
        var order2 = new ArrayList<OrderItem>();
        addItemToOrder(order2, 3, 5);
        addItemToOrder(order2, 0, 1);
        addItemToOrder(order2, 2, 1);
        printOrder(order2);
    }

    public static void listProducts() {
        for(var item: STORE_PRODUCTS) {
            System.out.println("-".repeat(30));
            item.showDetails();
        }
    }

    public static void addItemToOrder(ArrayList<OrderItem> orders, int orderIndex, int qty) {
        orders.add(new OrderItem(qty, STORE_PRODUCTS.get(orderIndex)));
    }

    public static void printOrder(ArrayList<OrderItem> orders) {
        double salesTotal = 0;
        for (var item : orders) {
            item.product().printPricedItem(item.qty());
            salesTotal += item.product().getSalesPrice(item.qty());
        }

        System.out.printf("Sales Total = $%6.2f %n", salesTotal);
    }
}
