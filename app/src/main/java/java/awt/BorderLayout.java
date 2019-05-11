package java.awt;

import android.support.v7.widget.GridLayout;
import android.view.View;
import android.view.ViewGroup;

import net.pbdavey.awt.demo.DemoApp;
import net.pbdavey.awt.demo.R;

import java.io.Serializable;

public class BorderLayout implements LayoutManager2, Serializable {
    /**
     * The north layout constraint (top of container).
     */
    public static final String NORTH  = "North";

    /**
     * The south layout constraint (bottom of container).
     */
    public static final String SOUTH  = "South";

    /**
     * The east layout constraint (right side of container).
     */
    public static final String EAST   = "East";

    /**
     * The west layout constraint (left side of container).
     */
    public static final String WEST   = "West";

    /**
     * The center layout constraint (middle of container).
     */
    public static final String CENTER = "Center";

    Container parent;

    public BorderLayout() {
    }

    @Override
    public void addLayoutComponent(String name, Component comp) {
    }

    @Override
    public void removeLayoutComponent(Component comp) {
    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        return null;
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        return null;
    }


    @Override
    public void addLayoutComponent(Component comp, Object constraints) {
        String name = (String) constraints;
        int index;

        switch (name) {
            case NORTH:
                index = 0;
                break;
            case SOUTH:
                index = 1;
                break;
            case WEST:
                index = 2;
                break;
            case EAST:
                index = 3;
                break;
            case CENTER:
                index = 4;
                break;
            default:
                index = -1;
                break;
        }
        if (index != -1) {
            ViewGroup borderLayoutViewGroup = (ViewGroup) parent.componentView;
            View oldView = borderLayoutViewGroup.getChildAt(index);
            ViewGroup.LayoutParams params = oldView.getLayoutParams();
            int oldId = oldView.getId();
            borderLayoutViewGroup.removeViewAt(index);
            View view = comp.getAndroidView();
            view.setLayoutParams(params);
            view.setId(oldId);
            comp.parent = parent;
            borderLayoutViewGroup.addView(view, index);
        }

    }

    @Override
    public Dimension maximumLayoutSize(Container target) {
        return null;
    }

    @Override
    public float getLayoutAlignmentX(Container target) {
        return 0;
    }

    @Override
    public float getLayoutAlignmentY(Container target) {
        return 0;
    }

    @Override
    public void invalidateLayout(Container target) {

    }
    @Override
    public void layoutContainer(Container parent) {
        this.parent = parent;
        parent.componentView = View.inflate(DemoApp.getContext(),R.layout.borderlayout, (ViewGroup) parent.componentView);
    }
}
