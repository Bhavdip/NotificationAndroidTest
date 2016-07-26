package skillvo.androidnotification;

/**
 * Created by boyap on 7/26/2016.
 */
public class NotificationModel {

    private NotificationType notificationType;
    private String usersName;
    private String usersId;

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public NotificationModel setNotificationType(NotificationType notificationType) {
        this.notificationType = notificationType;
        return this;
    }

    public String getUsersName() {
        return usersName;
    }

    public NotificationModel setUsersName(String usersName) {
        this.usersName = usersName;
        return this;
    }

    public String getUsersId() {
        return usersId;
    }

    public NotificationModel setUsersId(String usersId) {
        this.usersId = usersId;
        return this;
    }
}
