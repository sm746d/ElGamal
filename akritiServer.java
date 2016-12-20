import java.io.*;
import java.math.BigInteger;
import java.security.*;
import java.util.Vector;
import java.util.*;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.undo.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.text.*;
import java.text.*;
import java.net.*;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
public class akritiServer{
	String encryptedFileName,s=" ";
	ServerSocket providerSocket;
	Socket connection = null;
	ObjectOutputStream out;
	ObjectInputStream in;
    String msg;
    String decrptedhashcode;
    String hashcodeofrecievefile;
        String filename;
        int hashcode;
	akritiServer(){}
	void run()
	{
		try{
			providerSocket = new ServerSocket(2004, 10);
			javax.swing.JOptionPane.showMessageDialog(null,"waiting for connection");
			connection = providerSocket.accept();
			javax.swing.JOptionPane.showMessageDialog(null,"Connection received from " + connection.getInetAddress().getHostName());
			out = new ObjectOutputStream(connection.getOutputStream());
			out.flush();
			in = new ObjectInputStream(connection.getInputStream());
			javax.swing.JOptionPane.showMessageDialog(null,"select the file where you want the data to be stored");
			JFileChooser savemyFile = new JFileChooser();
			FileFilter filter = new FileNameExtensionFilter(" files", "txt");
			savemyFile.addChoosableFileFilter(filter);
			int ret=savemyFile.showSaveDialog(null);
			File outputFile = savemyFile.getSelectedFile();
			encryptedFileName=String.valueOf(outputFile);
			FileOutputStream out=new FileOutputStream(encryptedFileName);
        	PrintStream prin= new PrintStream( out );
			try{
                do{
					msg = (String)in.readObject();
					if(msg.equals("bye"))
					{
						in.close();
						out.close();
						providerSocket.close();
						connection.close();
						break;
					}
        	prin.print (msg);
        	prin.print(s);
        	       }while(!msg.equals("bye"));
        	javax.swing.JOptionPane.showMessageDialog(null,"file saved at the server side");
            int response = JOptionPane.showConfirmDialog(null, "Do you want to wait for some more files or exit?", "Confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(response==JOptionPane.NO_OPTION || response==JOptionPane.CANCEL_OPTION)
            {
            	System.exit(0);
            }
            	}
			catch(ClassNotFoundException classnot)
				{
					System.err.println("Data received in unknown format");
				}
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}


		finally{
			//4: Closing connection
			try{
			//	int response = JOptionPane.showConfirmDialog(null, "Do you want to close the connection?", "Confirm",
            //JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            //if(response==JOptionPane.YES_OPTION)
            //{

				in.close();
				out.close();
				providerSocket.close();
				connection.close();
            //}
			}
			catch(IOException ioException){
				ioException.printStackTrace();
			}
		}
	}




	public  void Main()
	{
		akritiServer server = new akritiServer();
		while(true){
			server.run();
		}
	}
}
