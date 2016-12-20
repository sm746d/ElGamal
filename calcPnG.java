/**
 * @(#)calcPnG.java
 *
 *
 * @author
 * @version 1.00 2011/4/13
 */
import java.math.BigInteger;
import java.security.*;
import java.util.Vector;
import java.util.*;
import java.io.*;
import javax.swing.*;

public class calcPnG {

int getkeyLength()
{
	int check_kl1=0,check_kl2=0,check_kl3=0;
	String skeylength;int keyLength;
	do
	{
			check_kl1=0;
		check_kl2=0;
		check_kl3=0;

	do
	{
		check_kl1=0;
		check_kl2=0;
		check_kl3=0;
		do
		{
		check_kl1=0;
		check_kl2=0;
		check_kl3=0;

	 skeylength=javax.swing.JOptionPane.showInputDialog("enter the key size that you want to work with ","");

	if(skeylength==null || skeylength.length()==0)
	{
		check_kl2=1;
	 			javax.swing.JOptionPane.showMessageDialog(null,"can not leave the field blank");
	}
	}while(check_kl2==1);
	int len=skeylength.length();
	 for(int i=0;i<len;i++)
	 {
	 	if(skeylength.charAt(i)<48 ||skeylength.charAt(i)>=57)
	 	{
	 		check_kl1=1;
	 			javax.swing.JOptionPane.showMessageDialog(null,"only integers can be entered");
			break;
	 	}
	 }
	}while(check_kl1==1);
	if(Integer.parseInt(skeylength)<=7)
	{
		check_kl3=1;
		javax.swing.JOptionPane.showMessageDialog(null,"the key length should be greater than 7 bits");
	}
	}while(check_kl3==1);
	keyLength=Integer.parseInt(skeylength);
	return keyLength;
}
BigInteger calcP(int keyLength)
{
	//int keyLength = 20;
	//int keyLength;

                int certainty = 16;
                SecureRandom sr = new SecureRandom();
	BigInteger p = new BigInteger(keyLength, certainty, sr);
	return p;
}
BigInteger calcGRE(BigInteger p,int keyLength)
{
	BigInteger gre;
	//int keyLength = 20;
                int certainty = 16;
                SecureRandom sr = new SecureRandom();
	do
        {
        	gre = new BigInteger(keyLength, certainty, sr);
        }while(p.compareTo(gre)<=0);
        return gre;
}
Vector calcPrivateKey(BigInteger p,int users)throws IOException,ClassCastException
{
	Vector v=new Vector();
	String s1="",s2;
	int j=0;
	for(int i=0;i<users;i++)
	{
		j=j+1;
		int check1=0,check2=0,check3=0,check4=0;
	do
	{
		check1=0;
		check2=0;
		check3=0;
		check4=0;
		do
		{
		check1=0;
		check2=0;
		check3=0;
		check4=0;
	do
	{
		check1=0;
		check2=0;
		check3=0;
		check4=0;
		do
		{
			check1=0;
		check2=0;
		check3=0;
		check4=0;
		s2=javax.swing.JOptionPane.showInputDialog("the private key for user number "+j+" is ","");
	if(s2==null || s2.length()==0)
	{
		check4=1;
		javax.swing.JOptionPane.showMessageDialog(null,"wrong operation performed");
	}
	}while(check4==1);
	int len=s2.length();
	for(int k=0;k<len;k++)
	{
		if((int)s2.charAt(k)<48 || (int)s2.charAt(k)>57)
		{

			check1=1;
			javax.swing.JOptionPane.showMessageDialog(null,"only integers can be entered");
			break;
		}

	}
	}while(check1==1);
		if(s2.equals(s1))
		{
			check2=1;
			javax.swing.JOptionPane.showMessageDialog(null,"wrong operation performed");

		}
		}while(check2==1);

	BigInteger bi=new BigInteger(s2);
	if(bi.compareTo(p)>=0)
	{
		check3=1;
			javax.swing.JOptionPane.showMessageDialog(null,"the private key should be less than the prime number"+p);
	}

	}while(check3==1);
		BigInteger bi=new BigInteger(s2);
		v.add(bi);
	}
        return v;
}
Vector calcPublicKey(Vector v,BigInteger p,BigInteger gre)
{
	Vector u=new Vector();
	for(int i=0;i<v.size();i++)
        {
            BigInteger h1=(BigInteger)v.get(i);
            BigInteger h=gre.modPow(h1,p);
			//System.out.println("the public key part for user number "+(i+1)+" is "+h);
			u.add(h);
		}
		return u;
}
/*BigInteger enterSecretKey(BigInteger p,BigInteger gre)throws IOException,ClassCastException
{
	//System.out.println("enter an element from 0 to "+p);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String string_users=br.readLine();
        BigInteger k=new BigInteger(string_users);
		return k;
}*/


}