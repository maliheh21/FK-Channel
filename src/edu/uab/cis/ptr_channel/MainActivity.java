package edu.uab.cis.ptr_channel;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
 
public class MainActivity extends Activity {
	
	

//  /** Called when the activity is first created. */
//  private EditText messageNumber;
//  @Override
//  public void onCreate(Bundle savedInstanceState) {
//      super.onCreate(savedInstanceState);
//      setContentView(R.layout.activity_main);
//      messageNumber=(EditText)findViewById(R.id.messageNumber);
//  }
//public void sayHello(View v) throws IOException {
//	 
//	CellularData.sendBeta();
//
//}
	
	
	ReceiveSMS rcvSMS = new ReceiveSMS();
	
    /** Called when the activity is first created. */
    private EditText messageNumber;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        messageNumber=(EditText)findViewById(R.id.messageNumber);
    }
 
    public void sayHello(View v) {
    	
//    	System.out.println("start time now:" + (System.nanoTime()/1000000));
        Log.e("Time", Long.toString((System.nanoTime()/1000000000)));

    	 
        String _messageNumber=messageNumber.getText().toString();
        String messageText = "Hi , Just SMSed to say hello";
     
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(_messageNumber, null, messageText, null, null);
     
    }
}

//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_main);
//	}
//
//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.main, menu);
//		return true;
//	}
//
//	@Override
//	public boolean onOptionsItemSelected(MenuItem item) {
//		// Handle action bar item clicks here. The action bar will
//		// automatically handle clicks on the Home/Up button, so long
//		// as you specify a parent activity in AndroidManifest.xml.
//		int id = item.getItemId();
//		if (id == R.id.action_settings) {
//			return true;
//		}
//		return super.onOptionsItemSelected(item);
//	}
//}
