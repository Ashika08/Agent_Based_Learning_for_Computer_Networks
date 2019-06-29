

package logic;

import java.util.Observable;


public class ValueObject extends Observable {
private String neigh;
private String neigh1;
private String neigh2;
private String msg;
private String data;
private String ddata;
private String mdata;
private String idata;
public String getdos()
{
   //System.out.println("neighbour2:"+cnodenei);
  return ddata;

}
public String getmima()
{
   //System.out.println("neighbour2:"+cnodenei);
  return mdata;

}
public String getip()
{
   //System.out.println("neighbour2:"+cnodenei);
  return idata;

}
public String getneigh()
{
   //System.out.println("neighbour2:"+cnodenei);
  return neigh;

}
public String getneigh1()
{
   //System.out.println("neighbour2:"+cnodenei);
  return neigh1;

}
public String getneigh2()
{
   //System.out.println("neighbour2:"+cnodenei);
  return neigh2;

}
public String getmessage()
{
   //System.out.println("neighbour2:"+cnodenei);
  return data;

}
public String getmsg()
{
   //System.out.println("neighbour2:"+cnodenei);
  return msg;

}
public void setdos(String msg1)
{
 ddata=msg1;
// System.out.println("neighbour2:"+cnodenei);
 fireNotify();
}
public void setmima(String msg1)
{
 mdata=msg1;
// System.out.println("neighbour2:"+cnodenei);
 fireNotify();
}
public void setip(String msg1)
{
 idata=msg1;
// System.out.println("neighbour2:"+cnodenei);
 fireNotify();
}
public void setmessage(String msg1)
{
 data=msg1;
// System.out.println("neighbour2:"+cnodenei);
 fireNotify();
}
public void setmsg(String msg1)
{
 msg=msg1;
// System.out.println("neighbour2:"+cnodenei);
 fireNotify();
}

public void setneigh(String dispneiname1)
{
 neigh=dispneiname1;
// System.out.println("neighbour2:"+cnodenei);
 fireNotify();
}
public void setneigh2(String dispneiname1)
{
 neigh2=dispneiname1;
// System.out.println("neighbour2:"+cnodenei);
 fireNotify();
}
public void setneigh1(String dispneiname1)
{
 neigh1=dispneiname1;
// System.out.println("neighbour2:"+cnodenei);
 fireNotify();
}
private void fireNotify()
{
         setChanged();
         notifyObservers();
}

}
