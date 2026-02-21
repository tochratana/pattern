package structural.bridgePattern;


import java.util.List;

class User{}
class Product{}

// abstraction
interface Service<T>{
    List<T> getAll();
    T save(T o);
    int delete(T o);
}
class UserService implements Service<User>{

    private UserRepository userRepository;
    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User o) {
        return null;
    }

    @Override
    public int delete(User o) {
        return 0;
    }
}
class ProductService implements Service<Product> {

    private ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product save(Product o) {
        return null;
    }

    @Override
    public int delete(Product o) {
        return 0;
    }
}

// Implementation
interface Repository<T> {
    List<T> findAll();
    T save(T o);
    int delete(T o);
}
class UserRepository implements Repository<User>{

    @Override
    public List<User> findAll() {
        return List.of();
    }

    @Override
    public User save(User o) {
        return null;
    }

    @Override
    public int delete(User o) {
        return 0;
    }
}
class ProductRepository implements Repository<Product>{

    @Override
    public List<Product> findAll() {
        return List.of();
    }

    @Override
    public Product save(Product o) {
        return null;
    }

    @Override
    public int delete(Product o) {
        return 0;
    }
}


public class Main {
    static void main(String[] args) {

        Service<User> userService = new UserService();
        userService.getAll();

        Service<Product> productService = new ProductService();
        productService.getAll();

    }
}
