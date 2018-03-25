package widgets;

import javax.swing.*;

public abstract class Widget {


    protected final WidgetType widgetType;
    
    public Widget(WidgetType widgetType) {
       this.widgetType = widgetType;
    }
    public abstract void setPosition(int x, int y);

    public  abstract void addToFrame(JFrame frame);

    public WidgetType getWidgetType() {
        return widgetType;
    }
}
