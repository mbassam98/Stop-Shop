package com.calculation.design;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.asura.library.posters.Poster;
import com.asura.library.posters.RawVideo;
import com.asura.library.posters.RemoteImage;
import com.asura.library.posters.DrawableImage;
import com.asura.library.posters.RemoteVideo;
import com.asura.library.views.PosterSlider;

import java.util.ArrayList;
import java.util.List;

public class Loge_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loge_activity);

        final LinearLayout lyt_facebook = findViewById(R.id.lyt_facebook);
        final Button btnregistere = findViewById(R.id.btnregistere);
        final Button btnlogine = findViewById(R.id.btnlogine);

        final PosterSlider posterSlider = findViewById(R.id.poster_slider);
        List<Poster> posters=new ArrayList<>();

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

        lyt_facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}