import java.util.*;

class CheckoutService {
    public static void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            System.out.println("Error: Cart is empty");
            return;
        }
        double subtotal = 0;
        double shipping = 0;
        List<Shippable> shippables = new ArrayList<>();
        List<CartItem> cartItems = cart.getItems();
        for (CartItem item : cartItems) {
            Product p = item.product;
            if (item.quantity > p.getQuantity()) {
                System.out.println("Error: Not enough stock for " + p.getName());
                return;
            }
            if (p instanceof Expirable && ((Expirable) p).isExpired()) {
                System.out.println("Error: " + p.getName() + " is expired");
                return;
            }
            subtotal += p.getPrice() * item.quantity;
            if (p instanceof Shippable) {
                for (int i = 0; i < item.quantity; i++) {
                    shippables.add((Shippable) p);
                }
                shipping += 10 * item.quantity;
            }
        }
        double total = subtotal + shipping;
        if (customer.getBalance() < total) {
            System.out.println("Error: Insufficient balance");
            return;
        }
        ShippingService.ship(shippables, cartItems);
        System.out.println("** Checkout receipt **");
        for (CartItem item : cartItems) {
            System.out.printf("%dx %s\n", item.quantity, item.product.getName());
            System.out.printf("%d\n", (int) (item.product.getPrice() * item.quantity));
        }
        System.out.println("----------------------");
        System.out.printf("Order subtotal         %d\n", (int) subtotal);
        System.out.printf("Shipping fees         %d\n", (int) shipping);
        System.out.printf("Paid amount           %d\n", (int) total);
        customer.deduct(total);
        System.out.printf("Customer balance after payment %d\n", (int) customer.getBalance());
        for (CartItem item : cartItems) {
            item.product.reduceQuantity(item.quantity);
        }
    }
}