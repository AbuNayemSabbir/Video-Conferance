package com.example.calling.activites;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.facebook.react.modules.core.PermissionListener;

import org.jitsi.meet.sdk.JitsiMeetActivityDelegate;
import org.jitsi.meet.sdk.JitsiMeetActivityInterface;
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions;
import org.jitsi.meet.sdk.JitsiMeetView;

import java.net.MalformedURLException;
import java.net.URL;

public class VideoMeeting extends AppCompatActivity implements JitsiMeetActivityInterface {
    private JitsiMeetView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        try {
            Intent intent = getIntent();
            String str = intent.getStringExtra("Key");
            view = new JitsiMeetView(VideoMeeting.this);
            JitsiMeetConferenceOptions options = new JitsiMeetConferenceOptions.Builder()
                    .setServerURL(new URL("https://meet.jit.si"))
                    .setRoom(str)
                    .build();
            view.join(options);
            setContentView(view);



        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed() {
        JitsiMeetActivityDelegate.onBackPressed();
        Intent intent = new Intent(VideoMeeting.this, SignInActivity.class);
        startActivity(intent);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();

        view.dispose();
       // view = null;

        JitsiMeetActivityDelegate.onHostDestroy(this);



    }

    @Override
    protected void onResume() {
        super.onResume();

        JitsiMeetActivityDelegate.onHostResume(this);
    }

    @Override
    protected void onStop() {
        super.onStop();

        JitsiMeetActivityDelegate.onHostPause(this);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }



    @Override
    public boolean shouldShowRequestPermissionRationale(String s) {
        return false;
    }

    @Override
    public void requestPermissions(String[] strings, int i, PermissionListener permissionListener) {

    }

}
