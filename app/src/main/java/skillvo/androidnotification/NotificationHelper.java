package skillvo.androidnotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class NotificationHelper {
    private static NotificationHelper mNotificationHelper = new NotificationHelper();
    private NotificationManager mNotificationManager;
    private List<NotificationModel> likeNotification = new ArrayList<>();
    private List<NotificationModel> verificationNotification = new ArrayList<>();
    private List<NotificationModel> ReviewNotification = new ArrayList<>();

    private NotificationHelper() {
    }

    public static NotificationHelper getInstance() {
        return mNotificationHelper;
    }

    public NotificationHelper registerManager(NotificationManager notificationManager) {
        this.mNotificationManager = notificationManager;
        return mNotificationHelper;
    }

    public void clearNotification() {
        likeNotification.clear();
        verificationNotification.clear();
        ReviewNotification.clear();
    }

    public void generateNotification(Context context, NotificationType notificationType, String users, String id) {
        int notifyID = -1;
        String contextTitle = null;
        String currentText = null;
        if (notificationType == NotificationType.LIKE) {
            likeNotification.add(new NotificationModel().setNotificationType(notificationType).setUsersName(users).setUsersId(id));
            notifyID = 1;
            contextTitle = "Like Notification";
            if (likeNotification.size() == 1) {
                currentText = String.format("%s users %2s %2s photo", (likeNotification.size()), "Like", id);
            } else {
                currentText = String.format("%s users %2s # photo", (likeNotification.size()), "Like");
            }
        } else if (notificationType == NotificationType.VERIFICATION) {
            verificationNotification.add(new NotificationModel().setNotificationType(notificationType).setUsersName(users).setUsersId(id));
            notifyID = 2;
            contextTitle = "Verification Notification";
            if (likeNotification.size() == 1) {
                currentText = String.format("%s users %2s %2s photo", (likeNotification.size()), "Verification", id);
            } else {
                currentText = String.format("%s users %2s # photo", (likeNotification.size()), "Verification");
            }
        } else if (notificationType == NotificationType.REVIEW) {
            ReviewNotification.add(new NotificationModel().setNotificationType(notificationType).setUsersName(users).setUsersId(id));
            notifyID = 3;
            contextTitle = "Review Notification";
            if (likeNotification.size() == 1) {
                currentText = String.format("%s users %2s %2s photo", (likeNotification.size()), "Review", id);
            } else {
                currentText = String.format("%s users %2s # photo", (likeNotification.size()), "Review");
            }
        } else if (notificationType == NotificationType.TEXT) {
            notifyID = new Random().nextInt();
            contextTitle = "Text Notification";
            currentText = String.format("Text Notification %d", notifyID);
        }
        if (notificationType != NotificationType.MESSAGE) {
            NotificationCompat.Builder mNotifyBuilder = new NotificationCompat.Builder(context)
                    .setContentTitle(contextTitle).setSmallIcon(R.mipmap.ic_launcher);
            mNotifyBuilder.setContentText(currentText);
            mNotificationManager.notify(notifyID, mNotifyBuilder.build());
        }
        if (notificationType == NotificationType.MESSAGE) {
            NotificationCompat.Builder mNotifyBuilder = new NotificationCompat.Builder(context)
                    .setContentTitle(contextTitle).setSmallIcon(R.mipmap.ic_launcher);
            mNotifyBuilder.setContentText(currentText);
        }
    }
}
