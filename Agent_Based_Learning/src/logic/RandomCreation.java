/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package logic;

import java.io.File;
import java.io.FileInputStream;
import java.net.InetAddress;
import java.util.Properties;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Pcube03
 */
public class RandomCreation {
Random ran=new Random();
 
public String peername()
{
    String pname="node"+String.valueOf(ran.nextInt(10)+String.valueOf(ran.nextInt(10))+String.valueOf(ran.nextInt(10))+String.valueOf(ran.nextInt(10)));
    return pname;

}
public String port()
{
    String port=String.valueOf(ran.nextInt(10))+String.valueOf(ran.nextInt(10))+String.valueOf(ran.nextInt(10))+String.valueOf(ran.nextInt(10));
    return port;
}
public String SystemName()throws Exception
{
    String localsys=InetAddress.getLocalHost().getHostName();
    return localsys;
}
public String bwidth()
{
    String bwidth=String.valueOf(ran.nextInt(100));
    return bwidth;
}
//////public String delay()
//////{
//////    String bwidth=String.valueOf(ran.nextInt(100));
//////    return bwidth;
//////}
public String ostatus()
{
    String OStatus=JOptionPane.showInputDialog(null,"Online status for out of 24hours.");
    boolean ok=true;
while(ok)
{
if(OStatus.equals(""))
{
    OStatus=JOptionPane.showInputDialog(null,"Online status for out of 24hours.");
}
else
{
ok=false;
}
}
return OStatus;
}
public String Distance()
{
    String dis="";
    try{
 dis=JOptionPane.showInputDialog(null,"Enter the Distance.");
int k=Integer.parseInt(dis);
    }
   catch(Exception e)
    {
      JOptionPane.showMessageDialog(null,"invalid input");
   }
boolean ok=true;
while(ok)
{
if(dis.equals(""))
{
dis=JOptionPane.showInputDialog(null,"Enter the Distance");
}
else
{
ok=false;
}
}


return dis;
}
public String name()
{
String dis=JOptionPane.showInputDialog(null,"Enter the name.");
boolean ok=true;
while(ok)
{
if(dis.equals(""))
{
dis=JOptionPane.showInputDialog(null,"Enter the name");
}
else
{
ok=false;
}
}
return dis;
}
public String Range()
{
String range="";
try{
 range=JOptionPane.showInputDialog(null,"Enter the range.");
int k=Integer.parseInt(range);
}
catch(Exception e)
{
 JOptionPane.showMessageDialog(null,"invalid input");
}
boolean ok=true;
while(ok)
{
if(range.equals(""))
{
range=JOptionPane.showInputDialog(null,"Enter the Range");
}
else
{
ok=false;
}
}
return range;
}
}

