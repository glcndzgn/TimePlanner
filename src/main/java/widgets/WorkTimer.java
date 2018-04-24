package widgets;

import util.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

public class WorkTimer extends Widget{

    private JLabel  label;
    private JButton button;
    private ImageIcon workIcon;
    private Timer   timer;
    private Label workLabel;
    private int currentTime;
    private int buttonState = 0;
    public LinkedList<String> recordedTimes = new LinkedList<String>();


    public WorkTimer () {
        super(WidgetType.WORKTIMER);

        init();
    }

    private void init() {

        try {
            workIcon = new ImageIcon(new ImageLoader().loadImage("icon_work.png", 40, 40));
        } catch (Exception e) {
            LOGGER.warning("Chronometer button icons could not be loaded.");
        }

        label = new JLabel();
        label.setSize(150, 50);
        label.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));

        workLabel = new Label();
        workLabel.setSize(100,50);


        button = new JButton();
        button.setSize(50, 50);
        button.addActionListener((ActionEvent e) -> {
            if (buttonState == 0) {
                play();
                recordedTimes.add("geçen süre:"+ recordedTimes);
                System.out.println(recordedTimes);
            } else
                reset();
        });
        button.setIcon(workIcon);
        timer = new Timer(50, e -> {
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
        buttonState = 1;
    }

    private void stop(){
        timer.stop();
        buttonState = 0;
    }

    private void reset(){
        currentTime = 0;
        recordedTimes.add(label.getText());
        label.setText("0.0.0.00");
        stop();

        for(int i = 0 ; i < recordedTimes.size(); i ++){
            String str = recordedTimes.get(i);
            System.out.println(str);
        }

    }


    public void setPosition(int x, int y) {
        label.setLocation(x,y);
        button.setLocation(label.getWidth()+x,y);
        workLabel.setLocation(x,label.getHeight()+y);
    }
    @Override
    public void addToFrame(JFrame frame) {
        frame.add(label);
        frame.add(button);
        frame.add(workLabel);
    }
}
