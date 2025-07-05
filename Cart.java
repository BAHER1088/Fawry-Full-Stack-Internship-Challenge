import java.util.*;

class CartItem {
    Product product;
    int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public CartItem(Product product, int quantity, int weight) {
        this.product = product;
        this.quantity = quantity;

    }
}

class Cart {
    private List<CartItem> items = new ArrayList<>();

    public void add(Product product, int quantity) {
        if (quantity <= 0)
            throw new IllegalArgumentException("Quantity must be positive");
        if (quantity > product.getQuantity())
            throw new IllegalArgumentException("Not enough stock for " + product.getName());
        if (product instanceof Expirable && ((Expirable) product).isExpired())
            throw new IllegalArgumentException(product.getName() + " is expired");

        for (CartItem item : items) {
            if (item.product == product) {
                if (item.quantity + quantity > product.getQuantity())
                    throw new IllegalArgumentException("Not enough stock for " + product.getName());
                item.quantity += quantity;
                return;
            }
        }
        items.add(new CartItem(product, quantity));
    }

    public List<CartItem> getItems() {
        return items;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}