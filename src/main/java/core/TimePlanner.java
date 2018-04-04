package core;

import widgets.Widget;

import javax.swing.*;

public class TimePlanner {

    private final JFrame mainFrame;

    public TimePlanner(){
        mainFrame = new JFrame();

        init();
    }

    private void init(){
        mainFrame.setSize(800,600);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setResizable(true);
        mainFrame.setLayout(null);

    }
     public void start() {
        mainFrame.setVisible(true);
        mainFrame.repaint();
    }

    public void add(Widget widget){
        switch (widget.getWidgetType()){
            case UTCCLOCK:
                widget.setPosition(0,0);
                break;
            case TODAY:
                widget.setPosition(56,0);
                break;
            case CRONOMETER:
                widget.setPosition(0,41);
                break;
            case WORKTIMER:
                widget.setPosition(0,100);
                break;
        }

        widget.addToFrame(mainFrame);
    }


}
