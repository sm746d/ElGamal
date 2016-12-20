/**
 * @(#)FileTransfer.java
 *
 *
 * @author
 * @version 1.00 2011/5/2
 */

import java.math.BigInteger;
import java.security.*;
import java.util.Vector;
import java.util.*;
import java.io.*;
import java.util.Scanner;
import java.io.File;
 import java.math.BigInteger;
import java.security.*;
import javax.swing.*;
import java.util.Vector;
import java.util.*;
import java.io.*;
 import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;
public class FileTransfer {

public void transfer(String encryptedFileName)
{
	akritiClient a=new akritiClient();
		a.run();
		try
		{

		File fi=new File(encryptedFileName);
			Scanner sc = new Scanner(fi);
			while(sc.hasNextBigInteger())
			{
				BigInteger b=sc.nextBigInteger();
				String bs=b.toString();
				a.sendMessage(bs);
			//System.out.println(bs);
			}
			a.sendMessage("bye");
			//a.sendMessage("bye");

		}
		catch(Exception e)
		{
		}
			                   	javax.swing.JOptionPane.showMessageDialog(null,"the encrypted file is transfered");
}


}