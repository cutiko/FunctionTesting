package cl.cutiko.functions.data;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by cutiko on 12-05-17.
 */

public class Nodes {

    private final DatabaseReference root = FirebaseDatabase.getInstance().getReference();

    private DatabaseReference user() {
        String uid = new CurrentUser().uid();
        return root.child("users").child(uid);
    }

    public DatabaseReference userToken() {

        return user().child("token");
    }

    public DatabaseReference userNotification() {
        return user().child("notification");
    }

    public DatabaseReference damFcm() {
        return root.child("damFcm");
    }
}
