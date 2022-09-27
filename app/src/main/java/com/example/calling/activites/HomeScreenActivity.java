package com.example.calling.activites;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.calling.R;
import com.facebook.react.modules.core.PermissionListener;

import org.jitsi.meet.sdk.JitsiMeetActivity;
import org.jitsi.meet.sdk.JitsiMeetActivityDelegate;
import org.jitsi.meet.sdk.JitsiMeetActivityInterface;
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions;
import org.jitsi.meet.sdk.JitsiMeetView;

import java.net.MalformedURLException;
import java.net.URL;

public class HomeScreenActivity extends AppCompatActivity {

    EditText sCode;
    Button joinBtn,shareBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        sCode=findViewById(R.id.codeEt);
        joinBtn=findViewById(R.id.joinBtnId);
        shareBtn=findViewById(R.id.shareBtnId);

        joinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String value=sCode.getText().toString();
                Intent intent = new Intent(HomeScreenActivity.this, VideoMeeting.class);
                intent.putExtra("Key", value);
                startActivity(intent);

            }
        });

    }


}