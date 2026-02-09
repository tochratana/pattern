package pattern.factory_method;

import java.time.Instant;
import java.util.Date;

public class NotificationCreator extends ServiceCreator{
    @Override
    public ApplicationService getInstance() {
        NotificationService notificationService = new NotificationService();
        notificationService.setTimestamp(Date.from(Instant.now()));
        notificationService.setId("Notification Service Object");
        return notificationService;
    }
}
