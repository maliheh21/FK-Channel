package edu.uab.cis.ptr_channel;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

import android.util.Log;

public class CellularData {

	public static void sendBeta() throws IOException {	
		
		
		
		String start = "hey its me";
		byte[] startByte = start.getBytes();
		
		long startTime = System.nanoTime();
		
		DatagramSocket socket = new DatagramSocket();
		InetAddress serverIPAddress = InetAddress.getByName("164.111.139.178");	    
		DatagramPacket sendPacket = new DatagramPacket(startByte, startByte.length, serverIPAddress, 23450);
		socket.send(sendPacket);
		
//		String deviceIP = getLocalIpAddress();				
		String beta = "0000000005157E4295D6FF0C5B3D9D00FA1B0D76A04ADBF90252C748B2C46850BDCF32AFBF9C5AAB";
		byte[] betaByte = beta.getBytes();

		byte[] receiveData = new byte[1024];
		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
		socket.receive(receivePacket);
		String challenge = new String(receivePacket.getData());
		System.out.println("Alpha received From the Server");
		
		sendPacket = new DatagramPacket(betaByte, betaByte.length, serverIPAddress, 23450);
		socket.send(sendPacket);

		long endTime = System.nanoTime();
		long execTime = (endTime - startTime)/1000000;
		
		Log.e("time", Long.toString(execTime));

		
		socket.close();

	}


	public static String getLocalIpAddress()
	{
	    try {
	        for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
	            NetworkInterface intf = en.nextElement();
	            for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) {
	                InetAddress inetAddress = enumIpAddr.nextElement();
	                if (!inetAddress.isLoopbackAddress()) {
	                    return inetAddress.getHostAddress().toString();
	                }
	             }
	         }
	     } catch (SocketException ex) {
	         Log.e("exception", ex.toString());
	     }
	     return null;
	}

}
