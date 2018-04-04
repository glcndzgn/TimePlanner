package widgets;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class WorkTimer extends Widget{

    private JLabel  label;
    private JButton button;
    private int buttonstate = 0;
    private int currentTime;
    private Timer   timer;

    public WorkTimer () {
        super(WidgetType.WORKTIMER);

        init();
    }

    private void init() {
        label = new JLabel();
        label.setSize(150, 50);
        label.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));

        button = new JButton();
        button.setSize(50, 50);
        button.addActionListener(e -> {
            if (buttonstate == 0){
                play();
            }else
                stop();
        });

            timer = new Timer(50, e->{
                currentTime += 50;
                label.setText(formatTime(currentTime));
            });

    }

    private String formatTime(int millis){

        int seconds = millis  /1000;
        int minutes = seconds /60;
        int hours   = minutes /60;
        int ms      = millis  %1000;

        String strMs = Integer.toString (ms);
        if (strMs.length()>2){
            strMs = strMs.substring(0, strMs.length() - 1);
        }

        return hours+"."+minutes+"."+seconds+"."+strMs;

    }



    private void play(){
        timer.start();
        buttonstate = 1;
    };

    private void stop(){
        timer.stop();
        buttonstate = 0;
    }





    @Override
    public void setPosition(int x, int y) {
        label.setLocation(x,y);
        button.setLocation(label.getWidth()+x,y);

    }

    @Override
    public void addToFrame(JFrame frame) {
        frame.add(label);
        frame.add(button);

    }
}
