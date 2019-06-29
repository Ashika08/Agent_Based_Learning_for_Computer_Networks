/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package agent_based_learning;



import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.effect.DropShadow;
import java.awt.TextField;
import javafx.ext.swing.SwingTextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextBox;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollView;
import javafx.scene.image.ImageView;
import javafx.scene.effect.Reflection;

import javafx.scene.input.MouseEvent;
import javafx.scene.image.Image;
import java.lang.Thread;

import javafx.ext.swing.SwingComboBox;
import javafx.ext.swing.SwingComboBoxItem;
import logic.RandomCreation;
import logic.NmulticastSender;
import logic.HelloReceiver;
import javafx.ext.swing.SwingButton;
import logic.FileChooser;
import logic.Sender1;
import logic.RouteReciver;
import javax.swing.JOptionPane;








/**
 * @author balaji
 */
public class Node{
    public function ssum(){
    var admin:SwingTextField;
    var namelab:Label;
    var portlab:Label;
    var syslab:Label;
    var dist:Label;
    var range:Label;
    var msg:TextBox;
    var rev:TextBox;
    var dest:SwingTextField;
    var neighlab:TextBox;
var ran:RandomCreation=new RandomCreation();
var node=ran.peername();
var port=ran.port();
var sname=ran.SystemName();
var dis=ran.Distance();
var rang=ran.Range();
var bwidth=ran.bwidth();
var Nms:NmulticastSender=new NmulticastSender();
var f:FileChooser=new FileChooser();

var lo:HelloReceiver=new HelloReceiver(node,dis,rang);
var rr:RouteReciver=new RouteReciver(lo);
rr.Rstart(port,node);
var s:Sender1=new Sender1(lo,rr);

var no:String="MobileDetails@{node}@{port}@{sname}@{dis}@{rang}@{bwidth} ";
Nms.setMDetails(no);
var value1:ValueObjectAdapter=new ValueObjectAdapter();
value1.valueObject=lo.valueobject;
var value2:ValueObjectAdapter=new ValueObjectAdapter();
value2.valueObject=f.val;
var value3:ValueObjectAdapter=new ValueObjectAdapter();
value3.valueObject=rr.valueobj;
//var k=n1.cname();
//         var port=n1.CPort();
//         var sname=n1.SystemName();
Stage {
    title: "user page"
    scene: Scene {
         width:500
        height:350
        content: [

            Rectangle {
                   arcHeight:35
                   arcWidth:35
                    x: 0, y: 0
                    width:500, height:350
                    fill: Color.BLACK
                  }


          Rectangle{
                    arcHeight:25
                    arcWidth:25
                    x: 10, y: 10
                    width:380, height:330
                    fill: Color.WHITE
                  }

                     Label {
                            text:"Node details"
                            translateX:150
                            translateY:15
                            font: Font{ name:"IMPACT" , size:20}
                            textFill:Color.BLACK
                           }
                     Label {
	                    text: "NAME:"
                            translateX:10
                            translateY:60
                            font: Font{ name:"IMPACT" , size:15}
                            textFill:Color.BLUE
                        }
                        namelab=Label {
	                    text:bind node
                            translateX:100
                            translateY:60
                            font: Font{ name:"IMPACT" , size:15}
                            textFill:Color.BLUE
                       }
                 Label {
	                    text: "port:"
                            translateX:10
                            translateY:90
                            font: Font{ name:"IMPACT" , size:15}
                            textFill:Color.BLUE
                        }
                portlab=Label {
	                   text:bind port
                            translateX:100
                            translateY:90
                            font: Font{ name:"IMPACT" , size:15}
                            textFill:Color.BLUE
                     }
                     Label {
	                    text: "sname:"
                            translateX:10
                            translateY:120
                            font: Font{ name:"IMPACT" , size:15}
                            textFill:Color.BLUE
                        }
                 syslab=Label {
	                    text:bind sname
                            translateX:100
                            translateY:120
                            font: Font{ name:"IMPACT" , size:15}
                            textFill:Color.BLUE
                     }
                
                  Label {
	                    text: "Distancee:"
                            translateX:10
                            translateY:150
                            font: Font{ name:"IMPACT" , size:15}
                            textFill:Color.BLUE
                        }
                dist=Label {
	                    text:bind dis
                            translateX:100
                            translateY:150
                            font: Font{ name:"IMPACT" , size:15}
                            textFill:Color.BLUE
                     }
                  Label {
	                    text: "Range:"
                            translateX:10
                            translateY:180
                            font: Font{ name:"IMPACT" , size:15}
                            textFill:Color.BLUE
                        }
                 range=Label {
	                    text:bind rang
                            translateX:100
                            translateY:180
                            font: Font{ name:"IMPACT" , size:15}
                            textFill:Color.BLUE
                     }
               Label {
	                    text: "Neighbour Nodes "
                            translateX:240
                            translateY:60
                            font: Font{ name:"IMPACT" , size:15}
                            textFill:Color.BLUE
                     }
         neighlab=TextBox
                    {
                           translateX:250
                           translateY:90
                           text:bind value1.neigh
                           columns: 12
                           multiline: true
                           editable:false
                    }
                    Label {
	                    text: "Bandwidth"
                            translateX:240
                            translateY:180
                            font: Font{ name:"IMPACT" , size:15}
                            textFill:Color.BLUE
                     }
                     admin=SwingTextField {
	             columns: 10
                     translateX:250
                     translateY:210
	             text:bind  bwidth
	             editable: true
                    }
                    Label {
	                    text: "File name:"
                            translateX:240
                            translateY:230
                            font: Font{ name:"IMPACT" , size:15}
                            textFill:Color.BLUE
                     }

                    msg=TextBox
                    {
                           translateX:250
                           translateY:250
                           text:bind value2.msg
                           columns: 12
                           multiline: true
                           editable:false
                    }
                    Label {
	                    text: "dest:"
                            translateX:10
                            translateY:210
                            font: Font{ name:"IMPACT" , size:15}
                            textFill:Color.BLUE
                     }
                     dest=SwingTextField {
	             columns: 10
                     translateX:60
                     translateY:210
	             text:""
	             editable: true
                    }
                    Label {
	                    text: "Receive msg:"
                            translateX:10
                            translateY:230
                            font: Font{ name:"IMPACT" , size:15}
                            textFill:Color.BLUE
                     }
                      rev=TextBox
                    {
                           translateX:60
                           translateY:250
                           text:bind value3.data
                           columns: 12
                           multiline: true
                           editable:false
                    }
SwingButton {
	text: "Browse"
        translateX:400
        translateY:50
	action: function() {
        f.selectmsg();
        }
}


SwingButton {
	text: "route request"
        translateX:400
        translateY:100
	action: function() {

          s.route_request(namelab.text,portlab.text,syslab.text,neighlab.text,admin.text,dest.text);
        }
}
SwingButton {
	text: "send data"
        translateX:400
        translateY:150
	action: function() {
         if(msg.text.equals(""))
         {
              JOptionPane.showMessageDialog(null,"No file is selected");
         }
         else{
            var m:String=JOptionPane.showInputDialog("Select your choice delay/bandwidth"," ");
            s.MsgSendToDestination(namelab.text,msg.text,m);
        }
        }
        }
]
}
}
}
}