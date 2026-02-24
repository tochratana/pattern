package structural.decoratorPattern.test;

interface Notification {
    void send(String message);

}

class EmailNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending Email: " + message);
    }
}
class SMSNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending SMS: " + message);
    }
}
class FacebookNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending Facebook Notification: " + message);
    }
}
class EmailSMSNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending Email: " + message);
        System.out.println("Sending SMS: " + message);
    }
}

class EmailSMSFacebookNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending Email: " + message);
        System.out.println("Sending SMS: " + message);
        System.out.println("Sending Facebook Notification: " + message);
    }
}
public class Main {
    public static void main(String[] args) {

        Notification notification1 = new EmailNotification();
        notification1.send("Hello User!");

        Notification notification2 = new EmailSMSNotification();
        notification2.send("System Update!");

        Notification notification3 = new EmailSMSFacebookNotification();
        notification3.send("Big Promotion!");
    }
}
