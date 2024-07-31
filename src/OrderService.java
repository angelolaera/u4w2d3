import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class OrderService {

    public List<Order> getOrdersWithProductCategory(List<Order> orders, String category) {
        return orders.stream()
                .filter(order -> order.getProducts().stream()
                        .anyMatch(product -> category.equals(product.getCategory())))
                .collect(Collectors.toList());
    }

    public List<Product> getProductsOrderedByCustomerTierAndDateRange(List<Order> orders, int tier, LocalDate startDate, LocalDate endDate) {
        return orders.stream()
                .filter(order -> order.getCustomer().getTier() == tier &&
                        (order.getOrderDate().isEqual(startDate) || order.getOrderDate().isAfter(startDate)) &&
                        (order.getOrderDate().isEqual(endDate) || order.getOrderDate().isBefore(endDate)))
                .flatMap(order -> order.getProducts().stream())
                .collect(Collectors.toList());
    }
}