package co.globelist.globelist;


import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONObject;

import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookieStore;
import java.util.HashMap;
import java.util.Map;

import com.android.volley.toolbox.StringRequest;
import com.android.volley.Request;
import com.android.volley.toolbox.Volley;


public class Welcome extends AppCompatActivity {
    private View mContentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final CookieManager manager = setUpCookieManager();
        CookieStore store = manager.getCookieStore();

        Log.d("Welcome", store.getCookies().toString());

        if (store.getCookies().size() > 0) {
            switchToMain();
        } else {
            setUpUI();
            setUpLogin();
        }
    }

    private void setUpLogin() {

        final RestService rest = new RestService();

        class AuthCallback extends Callback {
            @Override
            public void success(JSONObject jsonResponse) {
                super.success(jsonResponse);

                Log.d("AuthCallback", "my success");
            }

            @Override
            public void error(String error) {
                super.error(error);

                Intent intent = new Intent(Welcome.this, NotificationView.class);
                PendingIntent pIntent = PendingIntent.getActivity(Welcome.this, (int) System.currentTimeMillis(), intent, 0);
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {


                    NotificationManager notificationManager = (NotificationManager)
                            getSystemService(NOTIFICATION_SERVICE);

                    Notification n  = new Notification.Builder(Welcome.this)
                            .setContentTitle("You tried to log in")
                            .setContentText("Login attempt")
                            .setSmallIcon(R.drawable.logo)
                            .setContentIntent(pIntent)
                            .setAutoCancel(true)
                            .build();
                    notificationManager.notify(0, n);
                }

                switchToMain();
            }
        }

        Button clickButton = (Button) findViewById(R.id.login);
        clickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText fEmail = (EditText)findViewById(R.id.email);
                EditText fPass = (EditText)findViewById(R.id.password);
                Map<String, String> params = new HashMap<>();
                params.put("email", fEmail.getText().toString());
                params.put("password", fPass.getText().toString());
                StringRequest postRequest = rest.getStringRequest(Request.Method.POST, "auth", params, new AuthCallback());
                Volley.newRequestQueue(Welcome.this).add(postRequest);
            }
        });
    }

    private void switchToMain() {
        Intent i = new Intent(getApplicationContext(), Main.class);
        startActivity(i);
    }

    @NonNull
    private CookieManager setUpCookieManager() {
        final CookieManager manager = new CookieManager();
        CookieHandler.setDefault(manager);
        return manager;
    }

    private void setUpUI() {
        setContentView(R.layout.welcome);

        mContentView = findViewById(R.id.fullscreen_content);
        mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }

}
