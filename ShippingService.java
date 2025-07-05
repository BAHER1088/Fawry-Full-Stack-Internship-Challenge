import java.util.*;

class ShippingService {
    public static void ship(List<Shippable> items, List<CartItem> cartItems) {
        if (items.isEmpty()) return;
        System.out.println("** Shipment notice **");
        double totalWeight = 0;
        for (CartItem ci : cartItems) {
            if (ci.product instanceof Shippable) {
                System.out.printf("%dx %s\n", ci.quantity, ci.product.getName());
            }
        }
        for (Shippable item : items) {
            System.out.printf("%.0fg\n", item.getWeight());
            totalWeight += item.getWeight();
        }
        System.out.printf("Total package weight %.1fkg\n", totalWeight / 1000.0);
    }
}