

package agent_based_learning;





import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.ext.swing.SwingLabel;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.scene.effect.Reflection;
import javafx.scene.input.MouseEvent;
import java.lang.Thread;
import javafx.scene.shape.Rectangle;
import javafx.stage.StageStyle;



/**
 * @author Pcube03
 */
class Main
{
var peer:ImageView;
var exit:ImageView;
var ser:ImageView;
var sta:Stage;
var mobile: Boolean = "{__PROFILE__}" == "mobile";
 var browser: Boolean = "{__PROFILE__}" == "browser";
function disp():Void{
sta=Stage {
    title: "Efficient value"
    onClose: function () {  }
    style:StageStyle.TRANSPARENT
    scene: Scene {
        width:740
        height:400
        content: [


                   Rectangle {
                   arcHeight:35
                   arcWidth:35
                    x: 0, y: 0
                    width: 740, height: 600
                    fill: Color.BLACK
                    onMouseDragged: function(me: MouseEvent)
                    {
                        if (not browser and not mobile) {
                            sta.x = me.screenX - me.dragAnchorX;
                            sta.y = me.screenY - me.dragAnchorY;
                    }
                    }
                }

 Rectangle {
      arcHeight:25
      arcWidth:25
      x: 20, y: 80
      width:680, height: 300
      fill: Color.WHITE
}


ImageView {
                            image: Image {
                                    //url: "{__DIR__}images/network.jpg"
                            }
                            translateX:20
                            translateY:80
                            fitHeight:300
                            fitWidth:450
                            visible:true
}

SwingLabel {
    text: "Agent Based Learning using Improvised Artificial"
    translateX:60
    translateY:30
    font:Font{size:20,name:"algerian"}
    foreground:Color.WHITE
}
SwingLabel {
    text: "Bee Colony Algorithm on Network Routing"
    translateX:80
    translateY:50
    font:Font{size:20,name:"algerian"}
    foreground:Color.WHITE
}
Label {
    text: "NODE"
    translateX:170
    translateY:100
    font: Font{ name:"IMPACT" , size:20}
    textFill:Color.BLACK
    }
peer=ImageView {
                            translateX:160
                            translateY:130
                            //effect: Reflection { fraction:0.9 }
                            image: Image {
                            url: "{__DIR__}images/noode.png"
                            }
                            fitHeight:75
                            fitWidth:75
                           
                            onMousePressed: function (e: MouseEvent): Void{
                              var no:Node=new Node();
                              no.ssum();
                            }
                            visible:true
                            }



Label {
                            text: "Exit"
                            translateX:480
                            translateY:100
                            font: Font{ name:"IMPACT" , size:20}
                            textFill:Color.BLACK
                           }
                             ser=ImageView {
                             translateX:460
                             translateY:130
                            // effect: Reflection { fraction:0.9 }
                             image: Image {
                             url: "{__DIR__}images/exit.png"
                             }
                              fitHeight:75
                              fitWidth:75
                              
                              onMousePressed: function (e: MouseEvent): Void{
                              sta.close();
                              }

                              visible:true
                            }
]
}
}
}
}
var main:Main=new Main();
main.disp();
