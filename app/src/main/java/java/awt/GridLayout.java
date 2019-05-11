package java.awt;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import net.pbdavey.awt.demo.DemoApp;

import java.io.Serializable;

public class GridLayout implements LayoutManager2, Serializable {
    private android.support.v7.widget.GridLayout gridLayout;
    Container parent;

    public GridLayout(int rows, int cols) {
        gridLayout = new android.support.v7.widget.GridLayout(DemoApp.getContext());
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
        android.support.v7.widget.GridLayout.LayoutParams params =
            new android.support.v7.widget.GridLayout.LayoutParams(
                android.support.v7.widget.GridLayout.spec(
                    android.support.v7.widget.GridLayout.UNDEFINED,
                    android.support.v7.widget.GridLayout.FILL,
                    1f),
                android.support.v7.widget.GridLayout.spec(
                    android.support.v7.widget.GridLayout.UNDEFINED,
                    android.support.v7.widget.GridLayout.FILL,
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
