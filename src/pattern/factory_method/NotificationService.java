package pattern.factory_method;

import java.util.Date;

public class NotificationService implements ApplicationService{
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
