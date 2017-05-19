package cl.cutiko.functions.data;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by cutiko on 12-05-17.
 */

public class CurrentUser {

    private final FirebaseUser current = FirebaseAuth.getInstance().getCurrentUser();

    public String uid() {
        return current.getUid();
    }

    public FirebaseUser getCurrent() {
        return current;
    }
}
