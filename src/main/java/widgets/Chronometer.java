package widgets;

import util.ImageLoader;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

public class Chronometer extends Widget{

    private JLabel label;
    private JButton button;
    private JButton resetButton;

    private ImageIcon playIcon;
    private ImageIcon stopIcon;
    private ImageIcon resetIcon;

    private int buttonState = 0;
    private int currentTime = 0;
    private int resetButtonState = 0;
    private Timer timer;
    private int wordcount = 0;


    public Chronometer() {
        super(WidgetType.CRONOMETER);

        init();
    }

    private void init(){
        try {
            playIcon = new ImageIcon(new ImageLoader().loadImage("icon_play.png"  ,40,40));
            stopIcon = new ImageIcon(new ImageLoader().loadImage("icon_stop.png"  ,40,40));
            resetIcon= new ImageIcon(new ImageLoader().loadImage("icon_reset.png" ,55,55));

        }catch (Exception e){
            LOGGER.warning("Chronometer button icons could not be loaded.");
        }
        label = new JLabel();
        label.setBorder(BorderFactory.createMatteBorder(1,1,1,1, Color.black));
        label.setSize(100,40);


        button = new JButton();
        button.setSize(40,40);
        button.addActionListener(e->{
            if (buttonState  == 0){
                buttonState = 1;
                play();
            }else {
                buttonState = 0;
                stop();
            }
        });
        button.setIcon(playIcon);
        timer = new Timer(50,e->{
            currentTime += 25;
            label.setText(formatTime(currentTime));
        });

        resetButton = new JButton();
        resetButton.setSize(40,40);
        resetButton.setIcon(resetIcon);
        resetButton.addActionListener(e->{
               reset();
        });

    }

    private void play(){
        button.setIcon(playIcon);
        timer.start();

    }
    private void stop(){
        button.setIcon(stopIcon);
        timer.stop();
    }
    private void reset(){

    }

    private String formatTime(int millis){

        int seconds = millis/1000;
        int minutes = seconds/60;
        int hours   = minutes/60;
        int ms   = millis % 100;


        return hours+"."+minutes+"."+seconds+"."+ms;
    }

    @Override
    public void setPosition(int x, int y) {
        label.setLocation(x,y);
        button.setLocation(label.getWidth()+x,y);
        resetButton.setLocation(button.getWidth()+label.getWidth()+x,y);

    }

    @Override
    public void addToFrame(JFrame frame) {
        frame.add(label);
        frame.add(button);
        frame.add(resetButton);
    }


}
