
package Code_java;
import Interface.*;
import java.io.IOException;
/**
 *
 * @author Sanon
 */
public class Main_Class {
    public static void main(String[]steeve) throws IOException, InterruptedException{
        
        Splash s=new Splash();
        s.setVisible(true);
        try{
            for(int i=0;i<=100;i++){
            Thread.sleep(110);
            s.getInc().setText(Integer.toString(i)+"%");
            s.getProg().setValue(i);
            if(i==100){
                s.dispose();
            Main_View f=new Main_View();
              f.setVisible(true);
            }
            }
        }catch(Exception e){
    }
        
    }
}