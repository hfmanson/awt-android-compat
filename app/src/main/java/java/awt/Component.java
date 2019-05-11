package java.awt;

import android.graphics.Canvas;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;

import net.pbdavey.awt.Graphics2D;
import net.pbdavey.awt.ImageImpl;
import net.pbdavey.awt.demo.DemoApp;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;
import java.util.HashSet;
import java.util.Set;

public class Component implements ImageObserver {
    private static final String TAG = Component.class.getSimpleName();

    View componentView;
    Container parent;

    public Component() {
        componentView = new ComponentView(this);
        componentView.setFocusable(true);
    }

    @Override
    public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
        return false;
    }

    private static class ComponentView extends View {
        private Set<MouseListener> mouseListenerSet;
        private Component component;

        public ComponentView(Component component) {
            super(DemoApp.getContext());
            this.component = component;
            mouseListenerSet = new HashSet<>();
        }

        @Override
        protected void onSizeChanged(int w, int h, int oldw, int oldh) {
            super.onSizeChanged(w, h, oldw, oldh);
            invalidate();
        }

        @Override
        protected final void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Graphics2D g2 = new Graphics2D(canvas);
            component.paint(g2);
        }

        private boolean processKeyDown(Component component, Event event, int keyCode) {
            boolean processed = false;
            while (component != null && !(processed = component.keyDown(event, keyCode))) {
                component = component.parent;
            }
            return processed;
        }

        @Override
        public boolean onKeyDown(int keyCode, KeyEvent event) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_DPAD_LEFT:
                    return processKeyDown(component, null, Event.LEFT);
                case KeyEvent.KEYCODE_DPAD_RIGHT:
                    return processKeyDown(component, null, Event.RIGHT);
                case KeyEvent.KEYCODE_DPAD_UP:
                    return processKeyDown(component, null, Event.UP);
                case KeyEvent.KEYCODE_DPAD_DOWN:
                    return processKeyDown(component, null, Event.DOWN);
            }
            return super.onKeyDown(keyCode, event);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            int x = (int) event.getX();
            int y = (int) event.getY();

            MouseEvent mouseEvent = new MouseEvent(null, 0, 0, 0, x, y, 1, false);
            Log.d(TAG, "onTouchEvent: " + event);
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    for (MouseListener mouseListener : mouseListenerSet) {
                        mouseListener.mouseClicked(mouseEvent);
                    }
                    break;
                case MotionEvent.ACTION_MOVE:
                    //pointerDragged(x, y);
                    break;
                case MotionEvent.ACTION_UP:
                    for (MouseListener mouseListener : mouseListenerSet) {
                        mouseListener.mouseReleased(mouseEvent);
                    }
                    break;
            }
            return true;
        }

        public void addMouseListener(MouseListener l) {
            mouseListenerSet.add(l);
        }

        public void removeMouseListener(MouseListener l) {
            mouseListenerSet.remove(l);
        }

    }

    public void repaint() {
        componentView.invalidate();
    }

    public Dimension getSize() {
        return new Dimension(componentView.getWidth(), componentView.getHeight());
    }

    public void paint(Graphics g) {

    }


    public void setSize(int width, int height) {
        // ignored
    }

    public void addMouseListener(MouseListener l) {
        if (componentView instanceof ComponentView) {
            ((ComponentView) componentView).addMouseListener(l);
        }
    }

    public void removeMouseListener(MouseListener l) {
        if (componentView instanceof ComponentView) {
            ((ComponentView) componentView).removeMouseListener(l);
        }
    }

    public Image createImage(int width,
                             int height) {
        return new ImageImpl(width, height);
    }

    public Rectangle getBounds() {
        //TODO getBounds()
        return null;
    }

    public void setBounds(Rectangle r) {
        //TODO setBounds()
    }

    public Color getBackground() {
        //TODO getBackground()
        return Color.WHITE;
    }

    public void setBackground(Color c) {
        //TODO setBackground(Color c)
    }

    public Point getLocationOnScreen() {
        //TODO getLocationOnScreen()
        return null;
    }

    public void setForeground(Color c) {
        //TODO setForeground(Color c)
    }

    @Deprecated
    public void resize(Dimension d) {
        //TODO resize(Dimension d)
    }

    @Deprecated
    public void resize(int width, int height) {
        //TODO resize(int width, int height)

    }

    @Deprecated
    public void show() {
        //TODO show()
    }


    @Deprecated
    public Dimension size() {
        return new Dimension(componentView.getWidth(), componentView.getHeight());
    }

    public void requestFocus() {
        //TODO requestFocus()
    }


    @Deprecated
    public boolean keyDown(Event evt, int key) {
        return false;
    }

    @Deprecated
    boolean	action(Event evt, Object what) {
        return false;
    }

    public Container getParent() {
        return parent;
    }

    // Android specific
    public View getAndroidView() {
        return componentView;
    }
}
