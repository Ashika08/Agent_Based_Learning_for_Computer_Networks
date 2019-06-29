/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package logic;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Vector;
import javax.swing.JOptionPane;


public class RouteReciver extends Thread {
    HelloReceiver hr;
   // getlen gr;
    //Sorting rr=new Sorting();
    public String nodeport;
    public String nodename;
    public String bestpath;
    public String bmm="";
    public String bmm1="";
    public Vector v=new Vector();
    public ValueObject valueobj= new ValueObject();
    public ValueObject valueob= new ValueObject();
    public TreeMap pathsort = new TreeMap();
    public ArrayList neighbou=new ArrayList();
    TreeMap tmap = new TreeMap();
    int count=0;
    int s1=1;
public RouteReciver(HelloReceiver fi)
{
    hr=fi;
    //gr=VP;
   //data=dr;

}
public void Rstart(String port,String name)
{
    nodeport=port;
     nodename=name;
    start();
}

public void run()
{
      System.out.println("---------->Server Started-------->");
      try{
            ServerSocket ss=new ServerSocket(Integer.parseInt(nodeport));
            while(true){
            Socket s=ss.accept();
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            String Startdata=(String)ois.readObject();
            if(Startdata.equals("Neighbour")){
                      
                        String snodename=(String)ois.readObject();
                        String neigh=(String)ois.readObject();
                        String sport=(String)ois.readObject();
                        String sname=(String)ois.readObject();
                        String bwith=(String)ois.readObject();
                        int bwith1=Integer.parseInt(bwith);
                        String des=(String)ois.readObject();
                        if(!v.contains(snodename))
                        {
                              v.add(snodename);
                        }
                      if(!v.contains(neigh))
                        {
                              v.add(neigh);
                        }
                       // v.add(neigh);
                      //  JOptionPane.showMessageDialog(null,"  source request neighbour ");
                        reqtodest(snodename,des,sname,sport,bwith1,v);

              }
             else if(Startdata.equals("Requestsend"))
                   {
                    String source=(String)ois.readObject();
                    String destin=(String)ois.readObject();
                    //String orbit=(String)ois.readObject();
                    //System.out.println("--------->"+orbit);
                    String srcsysname=(String)ois.readObject();
                    String srcport=(String)ois.readObject();
                   
                    int TraFlux=(Integer)ois.readObject();
                     Vector path=(Vector)ois.readObject();
                    reqtodest1(source,destin,srcsysname,srcport,TraFlux,path);
                   }
  else if(Startdata.equals("RequestReceivedDestination"))
                   {
                     String nodname=(String)ois.readObject();
                     String destin=(String)ois.readObject();
                     String srcsysname1=(String)ois.readObject();
                     String srcsysport=(String)ois.readObject();
                     Vector path=(Vector)ois.readObject();
                     int TotalTrafficFlux=(Integer)ois.readObject();
                     //Vector v2=(Vector)ois.readObject();
                     //System.out.println("<------>"+v2);
                     res(srcsysname1,srcsysport,path,TotalTrafficFlux);
                   }
             else if(Startdata.equals("ResponsePath"))
                   {
                   // JOptionPane.showMessageDialog(null, "Inside res send");
                    Vector path=(Vector)ois.readObject();
                    int Fulx=(Integer)ois.readObject();
                   // JOptionPane.showMessageDialog(null, "HOPCOUNT INDICATOR------>"+path);
                  ///  JOptionPane.showMessageDialog(null, "TrafficFlux----->"+Fulx);
                    String details=path.toString();
                 //   valueob.setdata(details);
                    pathsort.put(Fulx,path);
                    JOptionPane.showMessageDialog(null, "HOPCOUNT INDICATOR------>"+pathsort);
                  }
             else if(Startdata.equals("MsgToDestination"))
                   {
                    String srname=(String)ois.readObject();
                    String Msg=(String)ois.readObject();
                    Vector flowpath=(Vector)ois.readObject();
                    MsgSendToDestination(srname,Msg,flowpath);
                   }
           
    }
    }
      catch(Exception e)
                    {

          e.printStackTrace();


}


}

public void res(String srssysnamee,String srcport,Vector path,int TotalFulx){
       try{
           //JOptionPane.showMessageDialog(null,"Inside res send");
           path.add(nodename);
           Socket soc2 = new Socket(srssysnamee,Integer.parseInt(srcport));
           ObjectOutputStream oos2 =new ObjectOutputStream(soc2.getOutputStream());
           oos2.writeObject("ResponsePath");
           oos2.writeObject(path);
           oos2.writeObject(TotalFulx);
       }
       catch(Exception e){
           e.printStackTrace();
       }
   }
    public void reqtodest(String nname,String destin,String ssys,String sport,int trafficvalue,Vector msgpath){
    try{
        HashMap traf=hr.hm3;
       System.out.println("inside destination"+traf);
        if(hr.neighbour.contains(destin)){
            HashMap h=hr.hm1;
            HashMap h1=hr.hm2;
        //    JOptionPane.showMessageDialog(null," request Send to Destination ");
            String portname=h.get(destin).toString();
            String sysname=h1.get(destin).toString();
            System.out.println("-------->TRAFFIC VALUE"+traf);
            System.out.println("<->"+nodename);
            String size=traf.get(destin).toString();
            System.out.println(traf+"---->"+size);
            int temptraf=Integer.parseInt(size);
            int temp=temptraf+trafficvalue;
                 System.out.println(temptraf+""+trafficvalue+"----------bandwwidth$$$$$----------------->"+size+temp);
            
                   if(!msgpath.contains(nodename)){
                   msgpath.add(nodename);
                   }
                  
            Socket st1=new Socket(sysname,Integer.parseInt(portname));
            System.out.println("****Server Received44544***");
            ObjectOutputStream oos=new ObjectOutputStream(st1.getOutputStream());
            oos.writeObject("RequestReceivedDestination");
            oos.writeObject(nname);
            oos.writeObject(destin);
            oos.writeObject(ssys);
            oos.writeObject(sport);
            oos.writeObject(msgpath);
            oos.writeObject(temp);
            st1.close();
      }
      else
       {
          
           HashMap hh=hr.hm1;
           HashMap hh1=hr.hm2;
           ArrayList neivector1=hr.neighbour;
            System.out.println("inside the neighbours"+neivector1);
           for(int k=0;k<neivector1.size();k++){
               String tempnei=neivector1.get(k).toString();
                if(!tempnei.equals(nname))
               {
               if(!msgpath.contains(tempnei)){
                   String neisysname=hh1.get(tempnei).toString();
                   String neiport=hh.get(tempnei).toString();
                   String size=traf.get(tempnei).toString();
                   System.out.println(traf+"---->"+size);
                   int tempbat=Integer.parseInt(size);
                 
                   int temp=tempbat+trafficvalue;
                    System.out.println(tempbat+""+trafficvalue+"----------bandwwidth----------------->"+size+temp);
                  if(!msgpath.contains(nodename)){
                   msgpath.add(nodename);
                   }
                   Socket soc1 = new Socket(neisysname,Integer.parseInt(neiport));
                   ObjectOutputStream oos1 = new ObjectOutputStream(soc1.getOutputStream());
                   oos1.writeObject("Requestsend");
                   oos1.writeObject(nname);
                   oos1.writeObject(destin);
                   oos1.writeObject(ssys);
                   oos1.writeObject(sport);
                    oos1.writeObject(temp);
                   oos1.writeObject(msgpath);
                  
                   //JOptionPane.showMessageDialog(null,"  source request neighbour "+tempnei);
                   Thread.sleep(5000);
               }
               }
           }
        }
     }
     catch(Exception e){
                JOptionPane.showMessageDialog(null,"in valid destintion");
           }
    }
 public void reqtodest1(String nname,String destin,String ssys,String sport,int trafficvalue,Vector msgpath){
    try{
        HashMap traf=hr.hm3;
      //  System.out.println("inside destination"+hr.neighbour);
        if(hr.neighbour.contains(destin)){
            HashMap h=hr.hm1;
            HashMap h1=hr.hm2;
         //   JOptionPane.showMessageDialog(null," request Send to Destination ");
            String portname=h.get(destin).toString();
            String sysname=h1.get(destin).toString();
          //  System.out.println("-------->TRAFFIC VALUE"+traf);
            System.out.println("<->"+nodename);
            String size=traf.get(destin).toString();
            System.out.println("---->"+size);
            int temptraf=Integer.parseInt(size);
            int temp=temptraf+trafficvalue;
            System.out.println(temptraf+""+trafficvalue+"----------bandwwidth----------------->"+size+temp);
         if(!msgpath.contains(nodename)){
                   msgpath.add(nodename);
                   }
            Socket st1=new Socket(sysname,Integer.parseInt(portname));
            System.out.println("****Server Received44544***");
            ObjectOutputStream oos=new ObjectOutputStream(st1.getOutputStream());
            oos.writeObject("RequestReceivedDestination");
            oos.writeObject(nname);
            oos.writeObject(destin);
            oos.writeObject(ssys);
            oos.writeObject(sport);
            oos.writeObject(msgpath);
             oos.writeObject(temp);
            
           
            st1.close();
      }
      else
       {

           HashMap hh=hr.hm1;
           HashMap hh1=hr.hm2;
           ArrayList neivector1=hr.neighbour;
            System.out.println("inside the neighbours"+neivector1);
           for(int k=0;k<neivector1.size();k++){
               String tempnei=neivector1.get(k).toString();
               if(!tempnei.equals(nname))
               {
               if(!msgpath.contains(tempnei)){
                   String neisysname=hh1.get(tempnei).toString();
                   String neiport=hh.get(tempnei).toString();
                   String size=traf.get(tempnei).toString();
                   System.out.println("---->"+size);
                   int tempbat=Integer.parseInt(size);
                  // System.out.println("--------------------------->"+tempbat);
                   int temp=tempbat+trafficvalue;
                     System.out.println(tempbat+""+trafficvalue+"----------bandwwidth----------------->"+size+temp);
                   if(!msgpath.contains(nodename)){
                   msgpath.add(nodename);
                   }
                   Socket soc1 = new Socket(neisysname,Integer.parseInt(neiport));
                   ObjectOutputStream oos1 = new ObjectOutputStream(soc1.getOutputStream());
                   oos1.writeObject("Requestsend");
                   oos1.writeObject(nname);
                   oos1.writeObject(destin);
                   oos1.writeObject(ssys);
                   oos1.writeObject(sport);
                    oos1.writeObject(temp);
                   oos1.writeObject(msgpath);
                  
                 //  JOptionPane.showMessageDialog(null,"  source request neighbour "+tempnei);
                   Thread.sleep(5000);
               }
               }
           }
        }
     }
     catch(Exception e){
                JOptionPane.showMessageDialog(null,"in valid destintion");
           }
    }

public void NeighbourSend(String nodename,String neigh)
           {
           String bmm="";
           HashMap h=hr.hm1;
           HashMap h1=hr.hm2;
           HashMap h2=hr.hm3;
           
           String portname=h.get(nodename).toString();
           String sysname=h1.get(nodename).toString();
            System.out.println("neigh***"+ neigh);
           String bwidth=h2.get(neigh).toString();
           
           bmm=bwidth;
          
           if(hr.neighbour.contains(nodename))
           {
           try{
                Socket st6=new Socket(sysname,Integer.parseInt(portname));
                System.out.println("****Server Received***");
                ObjectOutputStream oos=new ObjectOutputStream(st6.getOutputStream());
                oos.writeObject("SendtoSource");
                oos.writeObject(nodename);
                oos.writeObject(neigh);
                oos.writeObject(bmm);
                st6.close();
              }
 catch(Exception e)
{
     JOptionPane.showMessageDialog(null,"in valid destintion");
}
}
}
 public void MsgSendToDestination(String src,String message,Vector Fpath){
      try{
            Fpath.remove(0);
            int size=Fpath.size();
            if(size==0){
                valueobj.setmessage(message);
                JOptionPane.showMessageDialog(null, "Message Received from "+src);
            }else{
                String sentnode=Fpath.firstElement().toString();
                HashMap portnomap=hr.hm1;
                HashMap sysnamemap=hr.hm2;
                String portno=portnomap.get(sentnode).toString();
                String sysname=sysnamemap.get(sentnode).toString();
                Socket soc = new Socket(sysname,Integer.parseInt(portno));
                ObjectOutputStream oos = new ObjectOutputStream(soc.getOutputStream());
                oos.writeObject("MsgToDestination");
                oos.writeObject(src);
                oos.writeObject(message);
                oos.writeObject(Fpath);
            }
      }
      catch(Exception e){
          e.printStackTrace();
      }
  }

}
