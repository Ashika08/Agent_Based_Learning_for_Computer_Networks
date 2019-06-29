/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package agent_based_learning;

import java.util.Observer;
import java.util.Observable;
import logic.ValueObject;


public class ValueObjectAdapter extends Observer {
    public-read var neigh:String;
    public-read var neigh1:String;
        public-read var neigh2:String;
    public-read var msg:String;
     public-read var data:String;
     public-read var ddata:String;
     public-read var mdata:String;
     public-read var idata:String;
    public var valueObject : ValueObject
    on replace { valueObject.addObserver(this)}
    override function update(observable: Observable, arg: Object)
    {
        FX.deferAction(
            function(): Void
    {

       neigh=valueObject.getneigh();
        neigh1=valueObject.getneigh1();
        neigh2=valueObject.getneigh2();
       msg=valueObject.getmsg();
       data=valueObject.getmessage();
       ddata=valueObject.getdos();
       mdata=valueObject.getmima();
       idata=valueObject.getip();

    }
    );
    }
    }
