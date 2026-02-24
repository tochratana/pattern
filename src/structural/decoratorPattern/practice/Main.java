package structural.decoratorPattern.practice;

interface Notification {
    void send(String message);
}

class BaseNotification implements Notification {

    @Override
    public void send(String message) {
        System.out.println("Base Notification + " + message);
    }
}

// Decorator
abstract class NotificationDecorator implements Notification {

    private Notification notification;

    public NotificationDecorator (Notification notification){
        this.notification = notification;
    }

    @Override
    public void send(String message) {
        notification.send(message);
    }
}


class EmailNoti extends NotificationDecorator {

    public EmailNoti(Notification notification) {
        super(notification);
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Email : " + message);
    }
}


class FaceNoti extends NotificationDecorator {

    public FaceNoti(Notification notification) {
        super(notification);
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Facebook : " + message);
    }
}




public class Main {
    static void main(String[] args) {
        Notification notification = new BaseNotification();
        notification = new EmailNoti(notification);
        notification = new FaceNoti(notification);
        notification.send("Hello");
    }
}
