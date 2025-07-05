import java.util.*;

class Cheese extends Product implements Expirable, Shippable {
    private Date expiryDate;
    private double weight;

    public Cheese(String name, double price, int quantity, Date expiryDate, double weight) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
        this.weight = weight;
    }

    @Override
    public boolean isExpired() {
        return new Date().after(expiryDate);
    }

    @Override
    public double getWeight() { return weight; }
}

class Biscuits extends Product implements Expirable, Shippable {
    private Date expiryDate;
    private double weight;

    public Biscuits(String name, double price, int quantity, Date expiryDate, double weight) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
        this.weight = weight;
    }

    @Override
    public boolean isExpired() {
        return new Date().after(expiryDate);
    }

    @Override
    public double getWeight() { return weight; }
}

class TV extends Product implements Shippable {
    private double weight;
    public TV(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }
    @Override
    public double getWeight() { return weight; }
}

class Mobile extends Product {
    public Mobile(String name, double price, int quantity) {
        super(name, price, quantity);
    }
}

class ScratchCard extends Product {
    public ScratchCard(String name, double price, int quantity) {
        super(name, price, quantity);
    }
} 