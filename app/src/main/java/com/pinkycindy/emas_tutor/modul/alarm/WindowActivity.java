package com.pinkycindy.emas_tutor.modul.alarm;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.pinkycindy.emas_tutor.R;

/**
 * Created by Pinky Cindy
 */
public class WindowActivity extends AppCompatActivity {

    Button btnstop;
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_window);

        btnstop = (Button)findViewById(R.id.btnStop);
        btnstop.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
             // Toast.makeText(WindowActivity.this, "Matching Location", Toast.LENGTH_LONG).show();
             // mp = MediaPlayer.create(WindowActivity.this, R.raw.alarm3);
              mp.stop();
          }
      });

    }
}
