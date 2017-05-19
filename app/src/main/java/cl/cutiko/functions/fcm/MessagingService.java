package cl.cutiko.functions.fcm;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import cl.cutiko.functions.notifications.GenericNotification;

/**
 * Created by cutiko on 12-05-17.
 */

public class MessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        String title = remoteMessage.getData().get("message");
        String body = remoteMessage.getData().get("sender");
        GenericNotification.notify(this, title, body);

    }
}
