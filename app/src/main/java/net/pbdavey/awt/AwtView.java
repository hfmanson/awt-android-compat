package net.pbdavey.awt;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashSet;
import java.util.Set;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;


public abstract class AwtView extends View {
	private static final String TAG = AwtView.class.getSimpleName();
	private Color color;
	private static AwtView awtView;
	private Set<MouseListener> mouseListenerSet;

	public AwtView(Context context) {
		super(context);
		init();
	}

	public AwtView(Context context, AttributeSet attribSet) {
		super(context, attribSet);
		init();
	}

	public void setBackground(Color bgColor) {
		this.setBackgroundColor(bgColor.getRGB());
	}

	public void setForeground(Color bgColor) {
		this.color = bgColor;
	}

	public Dimension getSize() {
		return new Dimension(this.getWidth(), this.getHeight());
	}
	
	public void init() {
		awtView = this;
		mouseListenerSet = new HashSet<>();
	}

	public static AwtView getAwtView() {
		return awtView;
	}

	public void addMouseListener(MouseListener l) {
		mouseListenerSet.add(l);
	}

	public void mouseClicked(MouseEvent mouseEvent) {
		for (MouseListener l : mouseListenerSet) {
			l.mouseClicked(mouseEvent);
		}
	}
	@Override
	protected final void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		Graphics2D g2 = new Graphics2D(canvas);
		if (color != null)
			g2.setColor(color);
		paint(g2);
	}
	
	public abstract void paint(Graphics2D g2);

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		int x = (int) event.getX();
		int y = (int) event.getY();

		MouseEvent mouseEvent = new MouseEvent(null, 0, 0, 0, x, y, 1, false);
		Log.d(TAG, "onTouchEvent: " + event);
		switch (event.getAction()) {
			case MotionEvent.ACTION_DOWN:
				//pointerPressed(x, y);
				mouseClicked(mouseEvent);
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
}
