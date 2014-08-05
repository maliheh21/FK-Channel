package edu.uab.cis.ptr_channel;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;


public class ReceiveSMS extends BroadcastReceiver {

    private static final String SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(SMS_RECEIVED)) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                // get sms objects
                Object[] pdus = (Object[]) bundle.get("pdus");
                if (pdus.length == 0) {
                    return;
                }
                // large message might be broken into many
                SmsMessage[] messages = new SmsMessage[pdus.length];
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < pdus.length; i++) {
                    messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                    sb.append(messages[i].getMessageBody());
                }
                String sender = messages[0].getOriginatingAddress();
                String message = sb.toString();
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
//            	long time = System.nanoTime();

                // prevent any other broadcast receivers from receiving broadcast
                // abortBroadcast();
            	
           	 
//                String _messageNumber=sender;
//                String messageText = "Hi , Just SMSed to say hello";
//             
//                SmsManager sms = SmsManager.getDefault();
//                sms.sendTextMessage(_messageNumber, null, messageText, null, null);
                
//            	System.out.println("time: " + System.nanoTime() - time)/1000000);

                Log.e("Time", Long.toString((System.nanoTime()/1000000000)));
            	
            }
        }
    }
}