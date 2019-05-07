package java.awt;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.widget.TextView;

import net.pbdavey.awt.Graphics2D;
import net.pbdavey.awt.demo.DemoApp;

public class Label extends Component {
    private LabelView labelView;

    private static class LabelView extends android.support.v7.widget.AppCompatTextView {
        private Label label;
        public LabelView(Label label) {
            super(DemoApp.getContext());
            this.label = label;
        }
        @Override
        protected final void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Graphics2D g2 = new Graphics2D(canvas);
            label.paint(g2);
        }

    }


    public Label() throws HeadlessException {
        labelView = new LabelView(this);
    }

    public Label(String text) throws HeadlessException {
        this();
        labelView.setText(text);
    }


    public void setText(String text) {
        labelView.setText(text);
    }

    public void setAlignment(int alignment) {
        //TODO setAlignment(int alignment)

    }
    @Override
    public View getAndroidView() {
        return labelView;
    }
}
