/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package logic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


public class FileChooser {
public JFileChooser filechooser;
public int chooser;
public String path,data;
public StringTokenizer str;
public FileInputStream fis;
public ValueObject val=new ValueObject();
public void selectmsg() throws IOException {
    filechooser=new JFileChooser();
    chooser=filechooser.showOpenDialog(filechooser);
    if(chooser==JFileChooser.APPROVE_OPTION){
        path=filechooser.getSelectedFile().getAbsolutePath();
        data=filechooser.getSelectedFile().getName();
        str= new StringTokenizer(data,".");
        String fs=str.nextToken();
        String fr=str.nextToken();
        System.out.println("path:"+data);
        
        if(fr.equals("txt") ||fr.equals("java") ||fr.equals("html")||fr.equals("jsp")){
            try{
                fis= new FileInputStream(path);
                byte[] fb=new byte[fis.available()];
                fis.read(fb);
                String st=new String(fb);
                val.setmsg(st);
               }
            catch(Exception e){

           e.printStackTrace();
            }
        }
 else{
             JOptionPane.showMessageDialog(null,"unsupported format");
 }
   }
}

}
