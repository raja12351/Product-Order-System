package Service;

import Models.Order;
import Models.Product;
import Models.User;
import Repository.OrderRepository;
import Repository.ProductRepository;
import Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderService {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserRepository userRepository;

    public String addOrder(Character s) {
        List<Product> productList = productRepository.findAll();

        Order order = new Order();
        List<Product> products = new ArrayList<>();

        for(Product product : productList){
            String name = product.getName();
            Character pre = name.charAt(0);
            if(pre.equals(s)){
                products.add(product);
            }
        }
        User user = new User();

        order.setProductList(products);
        order = orderRepository.save(order);

        user.getOrderList().add(order);
        user = userRepository.save(user);

        for(Product product : products){
            product.setOrder(order);
            productRepository.save(product);
        }

        return "Order is placed Successfully!";
    }

    public String addLowOrder() {
        List<Product> productList = productRepository.findAll();
        List<String> categories = getAllCategory(productList);

        List<Product> products = new ArrayList<>();
        for(String category : categories){
            Product lowestPriceProduct = getLowestPriceProduct(category);
            products.add(lowestPriceProduct);
        }

        Order order = new Order();
        order.setProductList(products);
        order = orderRepository.save(order);

        User user = new User();

        user.getOrderList().add(order);
        user = userRepository.save(user);

        for(Product product : products){
            product.setOrder(order);
            productRepository.save(product);
        }

        return "Order is placed Successfully!";
    }

    public List<String> getAllCategory(List<Product> productList){
        HashMap<String, List<Product>> pair = new HashMap<>();

        for(Product product : productList){
            if(pair.containsKey(product.getCategory())){
                List<Product> ran = pair.get(product.getCategory());
                ran.add(product);
                pair.put(product.getCategory(),ran);
            }
            List<Product> products = new ArrayList<>();
            products.add(product);
            pair.put(product.getCategory(),products);
        }

        return new ArrayList<>(pair.keySet());
    }

    public Product getLowestPriceProduct(String category){
        List<Product> productList = productRepository.findAll();

        int min = Integer.MAX_VALUE;
        Product productAns = null;
        for(Product product : productList){
            if(product.getPrice() < min && product.getCategory().equals(category)){
                min = product.getPrice();
                productAns = product;
            }
        }

        return productAns;
    }
}
