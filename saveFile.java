/**
 * @(#)saveFile.java
 *
 *
 * @author
 * @version 1.00 2011/3/31
 */

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
public class saveFile {
//String encryptedfile;
String encryptedfile;
 public File selectEncrypted()
  {

	JFileChooser savemyFile = new JFileChooser();
FileFilter filter = new FileNameExtensionFilter(" files", ".txt");
    savemyFile.addChoosableFileFilter(filter);
int ret=savemyFile.showSaveDialog(null);
File outputFile = savemyFile.getSelectedFile();

if(ret==JFileChooser.APPROVE_OPTION)
{
}
return outputFile;

  }


}


