import java.net.*;
import java.io.*;
import java.math.BigInteger;
import java.security.*;
import javax.swing.*;
import java.util.Vector;
import java.util.*;
import java.io.*;
public class akritiClient
{
			Socket requestSocket;
	ObjectOutputStream out;
 	ObjectInputStream in;

	public void run()
	{
			try{
            	int confirm = JOptionPane.showConfirmDialog(null,"press YES to transfer encrypted data \n\nto this system NO or CANCEL to transfer \n\n it to the other system","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
                        if( confirm == JOptionPane.YES_OPTION )
                        {
                        	requestSocket = new Socket("localhost", 2004);
                        }
                        else
                        {
                        	requestSocket = new Socket("169.254.83.252", 2004);
                        }
		javax.swing.JOptionPane.showMessageDialog(null,"connected to the destination");
			out = new ObjectOutputStream(requestSocket.getOutputStream());
			out.flush();
			in = new ObjectInputStream(requestSocket.getInputStream());
   	    }
		catch(UnknownHostException unknownHost){
		javax.swing.JOptionPane.showMessageDialog(null,"You are trying to connect to an unknown host!");
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
		finally{}
	}
	void sendMessage(String msg)
	{
		try{
			out.writeObject(msg);
			out.flush();
			System.out.println("client>" + msg);
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
	}
}