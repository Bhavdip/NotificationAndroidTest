package skillvo.androidnotification;

import android.app.NotificationManager;
import android.content.Context;
import android.database.DatabaseUtils;
import android.databinding.DataBindingUtil;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Random;

import skillvo.androidnotification.databinding.NotificationBinding;

public class NotificationActivity extends AppCompatActivity {
    private String[] users = {"Lisa", "John", "Jack"};
    private String[] usersId = {"1", "2", "3"};

    private NotificationBinding mNotificationBinding;
    private NotificationManager mNotificationManager;
    private NotificationHelper mNotificationHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationHelper = NotificationHelper.getInstance().registerManager(mNotificationManager);
        mNotificationBinding = DataBindingUtil.setContentView(this, R.layout.activity_notification);
        mNotificationBinding.btnLikeNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int idx = new Random().nextInt(users.length);
                String userName = (users[idx]);
                String userId = (usersId[idx]);
                mNotificationHelper.generateNotification(NotificationActivity.this, NotificationType.LIKE, userName, userId);
            }
        });

        mNotificationBinding.btnVerificationNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int idx = new Random().nextInt(users.length);
                String userName = (users[idx]);
                String userId = (usersId[idx]);
                mNotificationHelper.generateNotification(NotificationActivity.this, NotificationType.VERIFICATION, userName, userId);
            }
        });

        mNotificationBinding.btnReviewNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int idx = new Random().nextInt(users.length);
                String userName = (users[idx]);
                String userId = (usersId[idx]);
                mNotificationHelper.generateNotification(NotificationActivity.this, NotificationType.REVIEW, userName, userId);
            }
        });

        mNotificationBinding.btnMessageNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int idx = new Random().nextInt(users.length);
                String userName = (users[idx]);
                String userId = (usersId[idx]);
                mNotificationHelper.generateNotification(NotificationActivity.this, NotificationType.MESSAGE, userName, userId);
            }
        });

        mNotificationBinding.btnTextNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int idx = new Random().nextInt(users.length);
                String userName = (users[idx]);
                String userId = (usersId[idx]);
                mNotificationHelper.generateNotification(NotificationActivity.this, NotificationType.TEXT, userName, userId);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mNotificationHelper.clearNotification();
    }
}
