package com.example.player;

import io.vov.vitamio.LibsChecker;
import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.MediaPlayer.OnPreparedListener;
import io.vov.vitamio.MediaPlayer.OnSeekCompleteListener;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

    private VideoView vidoView;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
		
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (!LibsChecker.checkVitamioLibs(this)) {
			return;
		}
        initUI();
       
    }

	

	private void initUI() {
		vidoView =(VideoView) findViewById(R.id.vv);
		
		vidoView.setVideoPath("http://192.168.1.103:8080/1.avi");
//		setOnCompletionListener(MediaPlayer.OnCompletionListener listener)：当流媒体播放完毕的时候回调。
//		setOnErrorListener(MediaPlayer.OnErrorListener listener)：当播放中发生错误的时候回调。
//		setOnPreparedListener(MediaPlayer.OnPreparedListener listener)：当装载流媒体完毕的时候回调。
//		setOnSeekCompleteListener(MediaPlayer.OnSeekCompleteListener listener)：当使用seekTo()设置播放位置的时候回调。
		vidoView.setOnPreparedListener(new OnPreparedListener() {
			//当装载流媒体完毕的时候回调。
			@Override
			public void onPrepared(MediaPlayer mp) {
				// TODO Auto-generated method stub
				vidoView.start();
			}
		});
		vidoView.setOnSeekCompleteListener(new OnSeekCompleteListener() {
			
			@Override
			public void onSeekComplete(MediaPlayer mp) {
				vidoView.seekTo(mp.getCurrentPosition());
				
			}
		});
		
		vidoView.setMediaController(new MediaController(getApplicationContext()));
	}


  
    
}
