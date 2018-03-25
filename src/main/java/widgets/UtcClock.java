package widgets;

import util.DateUtils;

import javax.swing.*;
import java.awt.*;

public class UtcClock extends Widget{

    private JLabel label;


    public UtcClock() {
        super(WidgetType.UTCCLOCK);

        init();
    }

     private void init(){

         label = new JLabel();
         label.setSize(55,40);
         label.setBorder(BorderFactory.createMatteBorder(1, 1,1,1, Color.BLACK));

         Timer timer = new Timer(1000,e->{
             label.setText(getCurrentTimeUTC());

         });

         timer.start();
    }

    private String getCurrentTimeUTC(){
        return DateUtils.getTimeInUTC();


    }
    @Override
    public void setPosition(int x, int y){
      label.setLocation(x,y);
    }

    @Override
    public void addToFrame(JFrame frame) {
        frame.add(label);
    }
}

