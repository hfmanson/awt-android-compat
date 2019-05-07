package java.awt;

import android.graphics.Canvas;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import net.pbdavey.awt.Graphics2D;
import net.pbdavey.awt.demo.DemoApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashSet;
import java.util.Set;

public class Button extends Component {
    private static final String TAG = Button.class.getSimpleName();
    private static class ButtonView extends android.support.v7.widget.AppCompatButton {
        private Set<ActionListener> actionListenerSet;
        private Button button;

        public ButtonView(Button button) {
            super(DemoApp.getContext());
            this.button = button;
            actionListenerSet = new HashSet<>();
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
            button.paint(g2);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            int x = (int) event.getX();
            int y = (int) event.getY();

            Log.d(TAG, "onTouchEvent: " + event);
            Log.d(TAG, "button text: " + getText());
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    for (ActionListener actionListener : actionListenerSet) {
                        actionListener.actionPerformed(new ActionEvent(button, 0, getText().toString()));
                    }
                    break;
                case MotionEvent.ACTION_MOVE:
                    //pointerDragged(x, y);
                    break;
                case MotionEvent.ACTION_UP:
                    //pointerReleased(x, y);
                    break;
            }
            return true;
        }

        public void addActionListener(ActionListener l) {
            actionListenerSet.add(l);
        }

        public void removeActionListener(ActionListener l) {
            actionListenerSet.remove(l);
        }

    }
    protected ButtonView buttonView;

    public Button() throws HeadlessException {

    }

    public Button(String label)
            throws HeadlessException {
        buttonView = new ButtonView(this);
        buttonView.setText(label);
    }

    public void setLabel(String label) {
        //TODO setLabel(String label)
    }

    public void addActionListener(ActionListener l) {
        buttonView.addActionListener(l);
    }

    @Override
    public View getAndroidView() {
        return buttonView;
    }

}
