package java.awt;

import java.util.EventObject;

public class AWTEvent extends EventObject {
    /**
     * The event's id.
     * @serial
     * @see #getID()
     * @see #AWTEvent
     */
    protected int id;

    public AWTEvent(Object source, int id) {
        super(source);
    }
}
