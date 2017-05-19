package cl.cutiko.functions.fcm;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by cutiko on 12-05-17.
 */

public class Token {

    private static final String TOKEN_GROUP = "GROU_KEY";
    private static final String TOKEN_KEY = "TOKEN_KEY";
    private final Context context;

    public Token(Context context) {
        this.context = context;
    }

    void saveToken(String token) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(TOKEN_GROUP, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = sharedPreferences.edit();
        prefEditor.putString(TOKEN_KEY, token);
        prefEditor.apply();
    }

    public String getToken() {
        SharedPreferences sharedPreferences = context.getSharedPreferences(TOKEN_GROUP, Context.MODE_PRIVATE);
        return sharedPreferences.getString(TOKEN_KEY, null);
    }


}
