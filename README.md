The solution is organized into multiple files:

- **`Product.java`** - Base Product class and interfaces (Expirable, Shippable)
- **`ProductTypes.java`** - Concrete product classes (Cheese, Biscuits, TV, Mobile, ScratchCard)
- **`Cart.java`** - Cart and CartItem classes
- **`Customer.java`** - Customer class with balance management
- **`ShippingService.java`** - Shipping service for shippable items
- **`CheckoutService.java`** - Checkout logic and receipt generation
- **`Solution.java`** - Main class with demo code

## Features

- **Product Management**
- **Expirable Products**
- **Shippable Products**
- **Cart System**
- **Checkout Sysrem**
- **Shipping System**
- **Error Handling**

## How to Compile and Run

Command Line

1. **Compile all files**:
   ```bash
   javac *.java
   ```

2. **Run the program**:
   ```bash
   java Solution
   ```

## Expected Output

```
** Shipment notice **
2x Cheese
1x Biscuits
400g
700g
Total package weight 1.1kg
** Checkout receipt **
2x Cheese
200
1x Biscuits
150
----------------------
Subtotal         350
Shipping         30
Amount           380
Customer balance 620
```

## Testing Different Scenarios

To test different scenarios, uncomment the relevant lines in `Solution.java`:

```java
//cart.add(tv, 3);
//cart.add(mobile, 1);
//cart.add(scratchCard, 1);
```

## Error Cases Handled

- Empty cart
- Insufficient customer balance
- Products out of stock
- Expired products
- Invalid quantities