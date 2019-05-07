package java.awt.event;

import java.awt.Component;
import java.awt.Point;

public class MouseEvent {
    private Point point;

    public MouseEvent(Component source,
                      int id,
                      long when,
                      int modifiers,
                      int x,
                      int y,
                      int clickCount,
                      boolean popupTrigger)
    {
        point = new Point(x, y);
    }

    public Point getPoint() {
        return point;
    }
}
