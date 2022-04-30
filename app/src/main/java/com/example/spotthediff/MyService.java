package com.example.spotthediff;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.telephony.TelephonyManager;
import android.util.Log;

public class MyService extends Service {
    MediaPlayer player;
    private boolean playing = false;

    public MyService() {
    }


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        // throw new UnsupportedOperationException("Not yet implemented");
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //  player= MediaPlayer.create(this, R.raw.bensoundcute);
        // player.setLooping(true);
        // player.setVolume(100,100);
        IntentFilter filter = new IntentFilter(TelephonyManager.ACTION_PHONE_STATE_CHANGED);
    }

    @Override
    public int onStartCommand (Intent intent, int flags, int startId) {
        if(!playing){
            player = MediaPlayer.create(MyService.this, R.raw.music);
            player.start();
            player.setLooping(true);
            playing= true;
        }
        //return super.onStartCommand(intent, flags, startId);
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy () {
        super.onDestroy();
        if(player!=null)
        {
            player.stop();
            player.release();
            player= null;
    }
}

}