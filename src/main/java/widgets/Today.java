package widgets;

import util.DateUtils;

import javax.swing.*;
import java.awt.*;

public class Today extends Widget{

    private JLabel label ;

    public Today() {
        super(WidgetType.TODAY);
        init();
    }

    private void init(){
        label = new JLabel();
        label.setSize(100,40);
        label.setBorder(BorderFactory.createMatteBorder(1,1,1,1, Color.black));
        label.setText(DateUtils.getToday());
        label.setHorizontalAlignment(SwingConstants.CENTER);


    }

    @Override
    public void setPosition(int x, int y) {
        label.setLocation(x,y);
    }

    @Override
    public void addToFrame(JFrame frame) {
        frame.add(label);
    }
}
