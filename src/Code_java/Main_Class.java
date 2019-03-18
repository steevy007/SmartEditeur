
package Code_java;
import Interface.*;
import java.awt.Color;
import java.io.IOException;
/**
 *
 * @author Sanon
 */
public class Main_Class {
    public static void main(String[]steeve) throws IOException, InterruptedException{
        /*
        Splash s=new Splash();
        s.setVisible(true);
        try{
            for(int i=0;i<=100;i++){
            Thread.sleep(80);
            s.getInc().setText(Integer.toString(i)+"%");
            s.getProg().setValue(i);
            if(i==10){
              s.getProg().setForeground(Color.GRAY);
            }
             if(i==20){
              s.getProg().setForeground(Color.CYAN);
            }
                if(i==30){
              s.getProg().setForeground(Color.PINK);
            }
                   if(i==40){
              s.getProg().setForeground(Color.magenta);
            }
                      if(i==50){
              s.getProg().setForeground(Color.darkGray);
            }
                         if(i==60){
              s.getProg().setForeground(Color.YELLOW);
            }
                            if(i==70){
              s.getProg().setForeground(Color.ORANGE);
            }
                               if(i==80){
              s.getProg().setForeground(Color.red);
            }
                                  if(i==90){
              s.getProg().setForeground(Color.GREEN);
            }
                                     if(i==95){
              s.getProg().setForeground(Color.WHITE);
            }
            if(i==100){
                s.dispose();*/
            Main_View f=new Main_View();
              f.setVisible(true);
           /* }
            }
        }catch(Exception e){
    }
        */
    }
}