import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        Cheese cheese = new Cheese("Cheese", 100, 5, cal.getTime(), 400);
        Biscuits biscuits = new Biscuits("Biscuits", 150, 2, cal.getTime(), 700);
        TV tv = new TV("TV", 1000, 3, 5000);
        Mobile mobile = new Mobile("Mobile", 500, 10);
        ScratchCard scratchCard = new ScratchCard("ScratchCard", 50, 20);

        Customer customer = new Customer("Ali", 1000);

        Cart cart = new Cart();
        try {
            cart.add(cheese, 2);
            cart.add(biscuits, 1);
            // cart.add(tv, 3);
            // cart.add(mobile, 1);
            // cart.add(scratchCard, 1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        CheckoutService.checkout(customer, cart);
    }
}