package section10.autoboxing;

import java.util.ArrayList;

public record CustomerAutoboxing(String name, ArrayList<Double> transactions) {
    public CustomerAutoboxing(String name, double initialDeposit) {
        this(name.toUpperCase(), new ArrayList<>(500));
        transactions.add(initialDeposit);
    }
}
