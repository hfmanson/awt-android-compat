package java.awt;

import android.view.View;
import android.view.ViewGroup;

import net.pbdavey.awt.demo.DemoApp;

import java.io.Serializable;

public class GridLayout implements LayoutManager2, Serializable {
    private androidx.gridlayout.widget.GridLayout gridLayout;
    Container parent;

    public GridLayout(int rows, int cols) {
        gridLayout = new androidx.gridlayout.widget.GridLayout(DemoApp.getContext());
        ViewGroup.LayoutParams layoutParams =
                new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                );
        gridLayout.setLayoutParams(layoutParams);
        gridLayout.setRowCount(rows);
        gridLayout.setColumnCount(cols);
    }

    @Override
    public void addLayoutComponent(Component comp, Object constraints) {
        View child = comp.getAndroidView();
//https://stackoverflow.com/a/47971896/433626
// weight = 1f, gravity = GridLayout.FILL
        androidx.gridlayout.widget.GridLayout.LayoutParams params =
            new androidx.gridlayout.widget.GridLayout.LayoutParams(
                androidx.gridlayout.widget.GridLayout.spec(
                    androidx.gridlayout.widget.GridLayout.UNDEFINED,
                    androidx.gridlayout.widget.GridLayout.FILL,
                    1f),
                androidx.gridlayout.widget.GridLayout.spec(
                    androidx.gridlayout.widget.GridLayout.UNDEFINED,
                    androidx.gridlayout.widget.GridLayout.FILL,
                    1f)
                );

// Layout_height = 0, Layout_weight = 0
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        params.width  = ViewGroup.LayoutParams.WRAP_CONTENT;
        child.setLayoutParams(params);
        comp.parent = parent;
        gridLayout.addView(child);
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
    public void layoutContainer(Container parent) {
        this.parent = parent;
        parent.componentView = gridLayout;
    }
}
