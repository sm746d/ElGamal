/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * keyGen.java
 *
 * Created on Apr 28, 2011, 9:29:12 PM
 */

/**
 *
 * @author akriti
 */
 import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;
  import java.math.BigInteger;
import java.security.*;
import javax.swing.*;
import java.util.Vector;
import java.util.*;
import java.io.*;
public class oldKey extends javax.swing.JFrame {
	BigInteger p,gre;
	int users;
	Vector v=new Vector();
	Vector u=new Vector();
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    /** Creates new form keyGen */
    public oldKey() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ELGAMAL ENCRYPTION SYSTEM");
        addWindowListener(new WindowAdapter(){


            public void windowClosing(WindowEvent evt){//System.exit(0);
            int response = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Confirm",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(response==JOptionPane.YES_OPTION)
            {
            	System.exit(0);
            }
            else //if(response==JOptionPane.NO_OPTION)
            {

				setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
            }
            }
        });


        jLabel1.setText("Enter prime number");
        jLabel2.setText("Enter random number");
        jLabel3.setText("Enter parts of private key");
        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });


        setLayout(null);
        add(jLabel1);
        add(jLabel2);
        add(jLabel3);
        add(jTextField1);
        add(jTextField2);
        add(jTextField3);
        add(jButton1);
        add(jButton2);
        setSize(500,500);
        jLabel1.setBounds(20,100,200,20);
        jTextField1.setBounds(250,100,200,20);
        jLabel2.setBounds(20,160,200,20);
        jTextField2.setBounds(250,160,200,20);
        jLabel3.setBounds(20,220,200,20);
        jTextField3.setBounds(250,220,200,20);
        jButton1.setBounds(150,280,100,20);
        jButton2.setBounds(150,340,100,20);
    }// </editor-fold>

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt)
	{
		this.setVisible(false);
		keyGen kg=new keyGen();
		kg.setVisible(true);
	}
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if(jTextField1.getText().length()==0 || jTextField2.getText().length()==0 || jTextField3.getText().length()==0)
        {
        	javax.swing.JOptionPane.showMessageDialog(null,"some of the fields are left blank.you can not proceed further unless the fields are filled");


        }
        else
        {

        String tf1=jTextField1.getText();
		String tf2=jTextField2.getText();
		String tf3=jTextField3.getText();
		p=new BigInteger(jTextField1.getText());
        gre=new BigInteger(jTextField2.getText());
        users=Integer.parseInt(jTextField3.getText());
		test ts=new test();
		boolean pb=ts.testPrime(p);
		boolean greb=ts.testPrime(gre);
		boolean pg=ts.comparePnG(p,gre);
		BigInteger limit=new BigInteger("127");
        if(pb==false)
        {
        	javax.swing.JOptionPane.showMessageDialog(null," the prime number entered is incorrect");
        }
        if(p.compareTo(limit)<=0)
        {
        	javax.swing.JOptionPane.showMessageDialog(null," the prime number should be greater than 127");
        }
        else if(greb==false)
        {
        	javax.swing.JOptionPane.showMessageDialog(null,"random number should be prime");
        }
        else if(pg==false)
        {
        	javax.swing.JOptionPane.showMessageDialog(null,"random number should be less than the prime number"+p);
        }
        else if(users%2==0)
        {
        	javax.swing.JOptionPane.showMessageDialog(null,"parts should be odd");
        }
                else
        {
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




        //	v.add(pk);
        }
        calcPnG cpg=new calcPnG();
        u=cpg.calcPublicKey(v,p,gre);
    	for(int i=0;i<u.size();i++)
    	{
    		javax.swing.JOptionPane.showMessageDialog(null,"the public key for the part "+(i+1)+" is "+u.get(i));        // TODO add your handling code here:

    	}


		encryptionStart es=new encryptionStart(p,gre,u,v);
		es.setVisible(true);
		this.setVisible(false);
        }
    	}
    }



    /**
    * @param args the command line arguments
    */
   /* public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new keyGen().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify

    // End of variables declaration

}
