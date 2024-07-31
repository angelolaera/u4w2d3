

import java.util.List;
import java.util.stream.Collectors;

public class ProductService {

    public List<Product> getProductsByCategoryAndPrice(List<Product> products, String category, double price) {
        return products.stream()
                .filter(product -> category.equals(product.getCategory()) && product.getPrice() > price)
                .collect(Collectors.toList());
    }

    public List<Product> getDiscountedProductsByCategory(List<Product> products, String category, double discountPercentage) {
        return products.stream()
                .filter(product -> category.equals(product.getCategory()))
                .peek(product -> product.setPrice(product.getPrice() * (1 - discountPercentage / 100)))
                .collect(Collectors.toList());
    }
}