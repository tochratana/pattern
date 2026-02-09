package creational.singleton_pattern;


import java.util.UUID;

class User {
    private static User instance;
    private String uuid;
    private User(String uuid){  // create private constructor, so anyone can't create object like `User user = new
        // User()`
        this.uuid = uuid;
    }

    // Example យើងមាននៅ class user



    public static User getInstance(){
        if(instance == null){
            instance = new User(UUID.randomUUID().toString());
        }
        return instance;
    }

    public String getUuid(){
        return uuid;
    }
}

public class SingletonPatternDemo {
    static void main() {

        User user1 = User.getInstance();
        User user2 = User.getInstance();
        User user3 = User.getInstance();
        User user4 = User.getInstance();
        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3);
        System.out.println(user4);
    }
}
