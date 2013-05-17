package com.xinlan.bubble.component;

import com.xinlan.loveplush.R;
import com.xinlan.utils.Common;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * 鎾斁鑳屾櫙闊充箰
 * 
 * @author Panyi
 * 
 */
public class BgmPlayer {
	private MediaPlayer mediaPlayer;// 澹版槑涓�釜闊充箰鎾斁鍣�

	public BgmPlayer(Context context) {
		int rand=Common.genRand(1, 2);
		if (rand == 1) {
			mediaPlayer = MediaPlayer.create(context, R.raw.bg2);
		} else if (rand == 2){
			mediaPlayer = MediaPlayer.create(context, R.raw.bg3);
		}
		mediaPlayer.setVolume(0.6f, 0.6f);
		mediaPlayer.setLooping(true);// 寰幆鎾斁
	}

	/**
	 * 鎾斁鑳屾櫙闊充箰
	 */
	public void playBmg() {
		mediaPlayer.start();// 寮�鎾斁
	}

	public void pauseBgm() {
		mediaPlayer.pause();
	}

	public void stopBgm() {
		mediaPlayer.stop();
	}
}// end class
