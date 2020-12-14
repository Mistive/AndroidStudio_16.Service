package com.mistive.serviceexample;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class MusicService extends Service { //서비스를 등록하면 Manifest에 등록해야 함.
    MediaPlayer mediaPlayer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {  //이 친구는 안씀
        return null;
    }

    //"Ctrl + O"를 이용해 함수 생성
    //3가지 생명주기
    //초기화
    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = MediaPlayer.create(this, R.raw.sample);    //여기서 음악파일을 불러옴. 음악파일은 resource->raw 폴더 안에 보통 있음.
                                                                        //raw 폴더 안에는 소문자만 있어야 함.
        mediaPlayer.setLooping(false);  //반복재생 안함.
    }

    //시작
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mediaPlayer.start();

        return super.onStartCommand(intent, flags, startId);
    }


    //종료
    @Override
    public void onDestroy() {
        mediaPlayer.stop();
        super.onDestroy();
    }
}
