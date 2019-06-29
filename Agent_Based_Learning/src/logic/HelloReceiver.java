
package logic;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;


public class HelloReceiver extends Thread{
     public String name;
     public String dist;
     public String rang;
     int nop,length;
     public HashMap hm11=new HashMap();
     public HashMap hm1=new HashMap();
     public HashMap hm2=new HashMap();
     public HashMap hm3=new HashMap();
     public HashMap hm4=new HashMap();
     public HashMap hm5=new HashMap();
     public HashMap hm6=new HashMap();
     public ArrayList neighbour=new ArrayList();
     public ArrayList neighbour12=new ArrayList();
     public ValueObject valueobject = new ValueObject();
     public int minvalue;
     public int maxvalue;
     public HelloReceiver(String name,String dist,String range){
     this.name=name;
     this.dist=dist;
     this.rang=range;
     minvalue=Integer.parseInt(dist)-Integer.parseInt(range);
     maxvalue=Integer.parseInt(dist)+Integer.parseInt(range);
     start();
     }


     public void run(){
     System.out.println("Inside the HELLO RECEIVER");
     try{
     while(true){
                InetAddress ip=InetAddress.getByName("228.8.9.7");
                MulticastSocket ms=new MulticastSocket(6678);
                ms.joinGroup(ip);
                byte[] by=new byte[9999];
                DatagramPacket dp=new DatagramPacket(by,by.length);
                ms.receive(dp);
                String details=new String(dp.getData()).trim();
                //System.out.println("HelloReceiver receiving Data............."+details);
                StringTokenizer st=new StringTokenizer(details,"@");
                String set=st.nextToken();
                if(set.equalsIgnoreCase("MobileDetails")){
                     //System.out.println("Enter into the Vechicle");
                     String nname=st.nextToken().trim();
                     String nport=st.nextToken().trim();
                     String sysname=st.nextToken().trim();
                     String ndist=st.nextToken().trim();
                     String nrang=st.nextToken().trim();
                     String bwidth=st.nextToken().trim();
                     //String ctime=st.nextToken().trim();
                     // hm6.put(nname,traf);
                        hm11.put(nname,ndist);
                        hm3.put(nname,bwidth);
                     String localsys=InetAddress.getLocalHost().getHostName();
                     if(!(name.equals(nname))){
                         if(minvalue<=0){
                            minvalue=0;
                         }
                     if(!neighbour.contains(nname)) {
                             if((minvalue<=Integer.parseInt(ndist)) && (maxvalue>=Integer.parseInt(ndist)))
                             {
                                 //System.out.println("Vech------>"+nname);
                              
                                 hm1.put(nname,nport);
                                 hm2.put(nname,sysname);
                                
                                 neighbour.add(nname);
                                //neighbour.add(currenttime);
                             }
                             String dispneiname = new String();
                             for(int i=0;i<neighbour.size();i++){
                             dispneiname+=String.valueOf(neighbour.get(i))+"\n";
                             }
                             //System.out.println("neighbour-------------->"+dispneiname);
                             valueobject.setneigh(dispneiname);
                             }
                             }
                             }
                 else{
                         // System.out.println("-----Inside the else part----->");
                         String nname=st.nextToken().trim();
                         String nport=st.nextToken().trim();
                         String sysname=st.nextToken().trim();
                       
                         if(!(name.equals(nname))){
                             if(minvalue<=0){
                             minvalue=10;
                             }
                           if(!neighbour12.contains(nname))
                                    
                           {       // System.out.println("Gate------->"+nname);
                                             hm4.put(nname,nport);
                                             System.out.println("port no:"+hm4);
                                             hm5.put(nname,sysname);
                                             neighbour12.add(nname);
                             
                             }
                             String dispneiname11 = new String();
                                             for(int i=0;i<neighbour12.size();i++){
                                             dispneiname11+=String.valueOf(neighbour12.get(i))+"\n";
                                             System.out.println("---------"+dispneiname11);
                             }
                                             //System.out.println("gate****--->"+dispneiname11);
                                            valueobject.setneigh1(dispneiname11);


                     }
                     }
                     }
         }
catch(Exception e)
{
e.printStackTrace();
}
}


}



