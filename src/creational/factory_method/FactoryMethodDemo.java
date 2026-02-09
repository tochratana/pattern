package creational.factory_method;

import java.time.Instant;
import java.util.Date;

public class FactoryMethodDemo {
    public static class App1 {
    }

    public static class App2 {
    }

    public static class App3 {
    }

    public static interface ApplicationService {
    }

    public static class NotificationCreator extends ServiceCreator {
        @Override
        public ApplicationService getInstance() {
            NotificationService notificationService = new NotificationService();
            notificationService.setTimestamp(Date.from(Instant.now()));
            notificationService.setId("Notification Service Object");
            return notificationService;
        }
    }

    public static class NotificationService implements ApplicationService {
        private String to;
        private String message;
        private String id;
        private Date timestamp;

        public void setTo(String to) {
            this.to = to;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public void setTimestamp(Date timestamp) {
            this.timestamp = timestamp;
        }
    }

    public abstract static class ServiceCreator {
        public abstract ApplicationService getInstance();

    }
}
