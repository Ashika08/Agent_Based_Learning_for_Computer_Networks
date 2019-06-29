/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package logic;

import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Vector;
import javax.swing.JOptionPane;


public class Sender1 {
     HelloReceiver hr;
     RouteReciver nr;
      public Vector v2=new Vector();

 public Sender1(HelloReceiver fi,RouteReciver m)
{
       this.hr=fi;
        this.nr=m;

}
public void route_request(String nname,String sport,String ssname,String neigh,String bwith,String des)
    {
  try {
        System.out.println("----Route-----");
        neigh=neigh.trim();
        HashMap h=hr.hm1;
        HashMap h1=hr.hm2;
        String[] nei=neigh.split("\n");
        System.out.println("neigh"+nei.length);
       if(des.startsWith("n"))
       {

       
   
        for(int i=0;i<nei.length;i++)
        {
             v2.add(nei[i].toString());
       System.out.println("neigh"+nei[i]);
       String portnm=h.get(nei[i]).toString();
       String sysnm=h1.get(nei[i]).toString();

          Socket st1=new Socket(sysnm,Integer.parseInt(portnm));
          ObjectOutputStream oos=new ObjectOutputStream(st1.getOutputStream());
          oos.writeObject("Neighbour");
          oos.writeObject(nname);
          oos.writeObject(nei[i]);
          oos.writeObject(sport);
          oos.writeObject(ssname);
          oos.writeObject(bwith);
          oos.writeObject(des);
          
          JOptionPane.showMessageDialog(null,"  source request to neighbour "+nei[i]);
           }
           }
        else{
         JOptionPane.showMessageDialog(null,"invalid data");
           }
    
        }
    catch(Exception e)
    {
        JOptionPane.showMessageDialog(null,"destination is not reachable");
    }
}
public void MsgSendToDestination(String src,String message,String m){
      try{
 int batkey1=0;

      TreeMap pathN=nr.pathsort;
      System.out.println(pathN);
      if(m.toLowerCase().equals("delay"))
      {
         batkey1=(Integer)pathN.firstKey();
      }
 else if(m.toLowerCase().equals("bandwidth"))
      {
       batkey1=(Integer)pathN.lastKey();
     }
 else{
           JOptionPane.showMessageDialog(null,"not coorect input");
     }
      System.out.println("------------------------->last"+batkey1);
      Vector pa=(Vector)pathN.get(batkey1);
      
      System.out.println("---------------->path:"+pa);
      
      
            HashMap neinodeport=hr.hm1;
            HashMap neinodesysname=hr.hm2;
            String neighbourname=v2.get(0).toString();
            System.out.println("---------------->path:"+neighbourname);
            pa.remove(0);
            String portno=neinodeport.get(neighbourname).toString();
            String sysnamenei=neinodesysname.get(neighbourname).toString();
            Socket soc = new Socket(sysnamenei,Integer.parseInt(portno));
            ObjectOutputStream oos = new ObjectOutputStream(soc.getOutputStream());
            oos.writeObject("MsgToDestination");
            oos.writeObject(src);
            oos.writeObject(message);
           oos.writeObject(pa);

      }
      catch(Exception e){
          e.printStackTrace();
      }
  }
}
