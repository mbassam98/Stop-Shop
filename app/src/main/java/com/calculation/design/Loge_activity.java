package com.calculation.design;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.asura.library.posters.Poster;
import com.asura.library.posters.RawVideo;
import com.asura.library.posters.RemoteImage;
import com.asura.library.posters.DrawableImage;
import com.asura.library.posters.RemoteVideo;
import com.asura.library.views.PosterSlider;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Loge_activity extends AppCompatActivity {

    private static final String EMAIL = "email";
    CallbackManager callbackManager;

    static String TAG = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
    public static void printHashKey(Context pContext) {
        try {
            PackageInfo info = pContext.getPackageManager().getPackageInfo(pContext.getPackageName(), PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                String hashKey = new String(Base64.encode(md.digest(), 0));
                Log.i(TAG, "printHashKey() Hash Key: " + hashKey);
            }
        } catch (NoSuchAlgorithmException e) {
            Log.e(TAG, "printHashKey()", e);
        } catch (Exception e) {
            Log.e(TAG, "printHashKey()", e);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        printHashKey(Loge_activity.this);
        super.onCreate(savedInstanceState);

        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_loge_activity);

        final Button btnregistere = findViewById(R.id.btnregistere);
        final Button btnlogine = findViewById(R.id.btnlogine);
        final PosterSlider posterSlider = findViewById(R.id.poster_slider);
        final LoginButton loginButton = findViewById(R.id.login_button);


        loginButton.setReadPermissions(Arrays.asList(EMAIL));

        callbackManager = CallbackManager.Factory.create();

        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        String id = loginResult.getAccessToken().getUserId();
                        Toast.makeText(Loge_activity.this, "Id: " + id, Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(Loge_activity.this, ListDrinksActivity.class);
                        startActivity(i);
                    }

                    @Override
                    public void onCancel() {
                        Toast.makeText(Loge_activity.this, "Error in login 1", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        Toast.makeText(Loge_activity.this, "Error in login 2", Toast.LENGTH_SHORT).show();
                    }
                });

        List<Poster> posters = new ArrayList<>();

        posters.add(new DrawableImage(R.drawable.illustration_log_in));
        posters.add(new DrawableImage(R.drawable.illustration_log_in));
        posters.add(new DrawableImage(R.drawable.illustration_log_in));
        posters.add(new DrawableImage(R.drawable.illustration_log_in));
        posterSlider.setPosters(posters);

        btnlogine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Loge_activity.this, Logein_Activity.class);
                startActivity(i);
            }
        });

        btnregistere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Loge_activity.this, Register_Activity.class);
                startActivity(i);
            }
        });

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                String id = loginResult.getAccessToken().getUserId();
                Toast.makeText(Loge_activity.this, "Id: " + id, Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Loge_activity.this, ListDrinksActivity.class);
                startActivity(i);
            }

            @Override
            public void onCancel() {
                Toast.makeText(Loge_activity.this, "Error in login 3", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException exception) {
                Toast.makeText(Loge_activity.this, "Error in login 4", Toast.LENGTH_SHORT).show();
                exception.printStackTrace();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }
}