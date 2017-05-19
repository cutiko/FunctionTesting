package cl.cutiko.functions;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.ErrorCodes;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.ResultCodes;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;

import cl.cutiko.functions.data.Nodes;
import cl.cutiko.functions.fcm.Token;

public class MainActivity extends AppCompatActivity {

    private static final int RC_SIGN_IN = 343;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FirebaseUser current = FirebaseAuth.getInstance().getCurrentUser();
        if (current != null) {
            Toast.makeText(this, "logeado", Toast.LENGTH_SHORT).show();
        } else {
            signIn();
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Nodes().userNotification().setValue(true);
            }
        });
    }

    private void signIn() {
        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setProviders(
                                Arrays.asList(
                                        new AuthUI.IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build()
                                )
                        )
                        .setIsSmartLockEnabled(false)
                        .build(),
                RC_SIGN_IN);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            IdpResponse response = IdpResponse.fromResultIntent(data);

            if (resultCode == ResultCodes.OK) {
                Toast.makeText(this, "Logeado", Toast.LENGTH_SHORT).show();
                String token = new Token(this).getToken();
                if (token != null) {
                    new Nodes().userToken().setValue(token);
                }
            } else {
                // Sign in failed
                if (response == null) {
                    // User pressed back button
                    Toast.makeText(this, "back button", Toast.LENGTH_SHORT).show();
                } else if (response.getErrorCode() == ErrorCodes.NO_NETWORK) {
                    Toast.makeText(this, "no internet", Toast.LENGTH_SHORT).show();
                } else if (response.getErrorCode() == ErrorCodes.UNKNOWN_ERROR) {
                    Toast.makeText(this, "desconocido", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
