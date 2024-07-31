import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> products = List.of(
                new Product(1L, "Book 1", "Books", 150.0),
                new Product(2L, "Book 2", "Books", 90.0),
                new Product(3L, "Toy", "Baby", 50.0),
                new Product(4L, "Action Figure", "Boys", 200.0)
        );

        List<Product> products1 = List.of(
                new Product(1L, "Toy 1", "Baby", 30.0),
                new Product(2L, "Book 1", "Books", 100.0)
        );

        List<Product> products2 = List.of(
                new Product(3L, "Toy 2", "Baby", 40.0),
                new Product(4L, "Toy 3", "Baby", 20.0)
        );

        List<Order> orders = List.of(
                new Order(1L, "Shipped", LocalDate.of(2021, 2, 10), LocalDate.of(2021, 2, 15), products1, new Customer(1L, "Customer 1", 2)),
                new Order(2L, "Delivered", LocalDate.of(2021, 3, 5), LocalDate.of(2021, 3, 10), products2, new Customer(2L, "Customer 2", 2))
        );

        ProductService productService = new ProductService();
        OrderService orderService = new OrderService();

        // Esercizio #1
        List<Product> booksOver100 = productService.getProductsByCategoryAndPrice(products, "Books", 100);
        booksOver100.forEach(product -> System.out.println("Esercizio #1 - Product: " + product.getName()));

        // Esercizio #2
        List<Order> ordersWithBabyProducts = orderService.getOrdersWithProductCategory(orders, "Baby");
        ordersWithBabyProducts.forEach(order -> System.out.println("Esercizio #2 - Order ID: " + order.getId()));
    }
}