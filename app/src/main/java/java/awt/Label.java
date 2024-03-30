package java.awt;

import android.graphics.Canvas;
import android.view.Gravity;
import android.view.View;

import net.pbdavey.awt.Graphics2D;
import net.pbdavey.awt.demo.DemoApp;

public class Label extends Component {
    /**
     * Indicates that the label should be left justified.
     */
    public static final int LEFT        = 0;

    /**
     * Indicates that the label should be centered.
     */
    public static final int CENTER      = 1;

    /**
     * Indicates that the label should be right justified.
     * @since   JDK1.0t.
     */
    public static final int RIGHT       = 2;

    private LabelView labelView;

    private static class LabelView extends androidx.appcompat.widget.AppCompatTextView {
        private Label label;

        public void setAlignment(int alignment) {
            setGravity(alignment == LEFT ? Gravity.LEFT : alignment == RIGHT ? Gravity.RIGHT : Gravity.CENTER);
        }

        public LabelView(Label label, String text, int alignment) {
            super(DemoApp.getContext());
            this.label = label;
            setText(text);
            setAlignment(alignment);
        }

        @Override
        protected final void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Graphics2D g2 = new Graphics2D(canvas);
            label.paint(g2);
        }

    }


    /**
     * Constructs an empty label.
     * The text of the label is the empty string <code>""</code>.
     * @exception HeadlessException if GraphicsEnvironment.isHeadless()
     * returns true.
     * @see java.awt.GraphicsEnvironment#isHeadless
     */
    public Label() throws HeadlessException {
        this("", LEFT);
    }

    /**
     * Constructs a new label with the specified string of text,
     * left justified.
     * @param text the string that the label presents.
     *        A <code>null</code> value
     *        will be accepted without causing a NullPointerException
     *        to be thrown.
     * @exception HeadlessException if GraphicsEnvironment.isHeadless()
     * returns true.
     * @see java.awt.GraphicsEnvironment#isHeadless
     */
    public Label(String text) throws HeadlessException {
        this(text, LEFT);
    }

    public Label(String text, int alignment) throws HeadlessException {
        labelView = new LabelView(this, text, alignment);
    }

    public void setText(String text) {
        labelView.setText(text);
    }

    public void setAlignment(int alignment) {
        labelView.setAlignment(alignment);
    }

    @Override
    public View getAndroidView() {
        return labelView;
    }
}
