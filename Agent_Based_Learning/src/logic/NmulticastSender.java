/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package logic;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Random;
import java.util.StringTokenizer;


public class NmulticastSender extends Thread{
    String MDetails;
    String MinMax="";
public NmulticastSender()
 {

 }
public void setMDetails(String Ndetails)
{
        MDetails=Ndetails;
        start();
}
public void run(){
try{
while(true)
  {
   
           InetAddress ip=InetAddress.getByName("228.8.9.7");
           MulticastSocket ms=new MulticastSocket(6678);
           ms.joinGroup(ip);
           byte[] bye=MDetails.getBytes();
           DatagramPacket datagram=new DatagramPacket(bye,bye.length,ip,6678);
           ms.send(datagram);
           Thread.sleep(5000);
          // System.out.println("gate------>"+GDetails);

  }
  }
catch(Exception e)
  {
     e.printStackTrace();
  }
  }
  }