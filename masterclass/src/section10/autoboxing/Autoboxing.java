package section10.autoboxing;

public class Autoboxing {

    public static void result() {
        CustomerAutoboxing bob = new CustomerAutoboxing("Bob S", 1000.0);
        System.out.println(bob);

        Bank bank = new Bank("Chase");
        bank.addNewCustomer("Jane A", 500.0);
        System.out.println(bank);

        bank.addTransaction("Jane A", -10.25);
        bank.addTransaction("Jane A", -75.01);
        bank.printStatement("Jane a");
    }
}
