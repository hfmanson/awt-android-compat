package java.awt;

import android.view.View;
import android.view.ViewGroup;

public class Container extends Component {
    LayoutManager layoutMgr;
    protected ViewGroup viewGroup;

    public Container() {
        super();
        viewGroup = null;
    }

    /**
     * Appends the specified component to the end of this container.
     * This is a convenience method for {@link #addImpl}.
     * <p>
     * This method changes layout-related information, and therefore,
     * invalidates the component hierarchy. If the container has already been
     * displayed, the hierarchy must be validated thereafter in order to
     * display the added component.
     *
     * @param     comp   the component to be added
     * @exception NullPointerException if {@code comp} is {@code null}
     * @see #addImpl
     * @see #invalidate
     * @see #validate
     * @see javax.swing.JComponent#revalidate()
     * @return    the component argument
     */
    public Component add(Component comp) {
        addImpl(comp, null, -1);
        return comp;
    }

    /**
     * Adds the specified component to this container.
     * This is a convenience method for {@link #addImpl}.
     * <p>
     * This method is obsolete as of 1.1.  Please use the
     * method <code>add(Component, Object)</code> instead.
     * <p>
     * This method changes layout-related information, and therefore,
     * invalidates the component hierarchy. If the container has already been
     * displayed, the hierarchy must be validated thereafter in order to
     * display the added component.
     *
     * @exception NullPointerException if {@code comp} is {@code null}
     * @see #add(Component, Object)
     * @see #invalidate
     */
    public Component add(String name, Component comp) {
        addImpl(comp, name, -1);
        return comp;
    }

    /**
     * Adds the specified component to this container at the given
     * position.
     * This is a convenience method for {@link #addImpl}.
     * <p>
     * This method changes layout-related information, and therefore,
     * invalidates the component hierarchy. If the container has already been
     * displayed, the hierarchy must be validated thereafter in order to
     * display the added component.
     *
     *
     * @param     comp   the component to be added
     * @param     index    the position at which to insert the component,
     *                   or <code>-1</code> to append the component to the end
     * @exception NullPointerException if {@code comp} is {@code null}
     * @exception IllegalArgumentException if {@code index} is invalid (see
     *            {@link #addImpl} for details)
     * @return    the component <code>comp</code>
     * @see #addImpl
     * @see #remove
     * @see #invalidate
     * @see #validate
     * @see javax.swing.JComponent#revalidate()
     */
    public Component add(Component comp, int index) {
        addImpl(comp, null, index);
        return comp;
    }

    /**
     * Adds the specified component to the end of this container.
     * Also notifies the layout manager to add the component to
     * this container's layout using the specified constraints object.
     * This is a convenience method for {@link #addImpl}.
     * <p>
     * This method changes layout-related information, and therefore,
     * invalidates the component hierarchy. If the container has already been
     * displayed, the hierarchy must be validated thereafter in order to
     * display the added component.
     *
     *
     * @param     comp the component to be added
     * @param     constraints an object expressing
     *                  layout constraints for this component
     * @exception NullPointerException if {@code comp} is {@code null}
     * @see #addImpl
     * @see #invalidate
     * @see #validate
     * @see javax.swing.JComponent#revalidate()
     * @see       LayoutManager
     * @since     JDK1.1
     */
    public void add(Component comp, Object constraints) {
        addImpl(comp, constraints, -1);
    }

    /**
     * Adds the specified component to this container with the specified
     * constraints at the specified index.  Also notifies the layout
     * manager to add the component to the this container's layout using
     * the specified constraints object.
     * This is a convenience method for {@link #addImpl}.
     * <p>
     * This method changes layout-related information, and therefore,
     * invalidates the component hierarchy. If the container has already been
     * displayed, the hierarchy must be validated thereafter in order to
     * display the added component.
     *
     *
     * @param comp the component to be added
     * @param constraints an object expressing layout constraints for this
     * @param index the position in the container's list at which to insert
     * the component; <code>-1</code> means insert at the end
     * component
     * @exception NullPointerException if {@code comp} is {@code null}
     * @exception IllegalArgumentException if {@code index} is invalid (see
     *            {@link #addImpl} for details)
     * @see #addImpl
     * @see #invalidate
     * @see #validate
     * @see javax.swing.JComponent#revalidate()
     * @see #remove
     * @see LayoutManager
     */
    public void add(Component comp, Object constraints, int index) {
        addImpl(comp, constraints, index);
    }

    /**
     * Adds the specified component to this container at the specified
     * index. This method also notifies the layout manager to add
     * the component to this container's layout using the specified
     * constraints object via the <code>addLayoutComponent</code>
     * method.
     * <p>
     * The constraints are
     * defined by the particular layout manager being used.  For
     * example, the <code>BorderLayout</code> class defines five
     * constraints: <code>BorderLayout.NORTH</code>,
     * <code>BorderLayout.SOUTH</code>, <code>BorderLayout.EAST</code>,
     * <code>BorderLayout.WEST</code>, and <code>BorderLayout.CENTER</code>.
     * <p>
     * The <code>GridBagLayout</code> class requires a
     * <code>GridBagConstraints</code> object.  Failure to pass
     * the correct type of constraints object results in an
     * <code>IllegalArgumentException</code>.
     * <p>
     * If the current layout manager implements {@code LayoutManager2}, then
     * {@link LayoutManager2#addLayoutComponent(Component,Object)} is invoked on
     * it. If the current layout manager does not implement
     * {@code LayoutManager2}, and constraints is a {@code String}, then
     * {@link LayoutManager#addLayoutComponent(String,Component)} is invoked on it.
     * <p>
     * If the component is not an ancestor of this container and has a non-null
     * parent, it is removed from its current parent before it is added to this
     * container.
     * <p>
     * This is the method to override if a program needs to track
     * every add request to a container as all other add methods defer
     * to this one. An overriding method should
     * usually include a call to the superclass's version of the method:
     *
     * <blockquote>
     * <code>super.addImpl(comp, constraints, index)</code>
     * </blockquote>
     * <p>
     * This method changes layout-related information, and therefore,
     * invalidates the component hierarchy. If the container has already been
     * displayed, the hierarchy must be validated thereafter in order to
     * display the added component.
     *
     * @param     comp       the component to be added
     * @param     constraints an object expressing layout constraints
     *                 for this component
     * @param     index the position in the container's list at which to
     *                 insert the component, where <code>-1</code>
     *                 means append to the end
     * @exception IllegalArgumentException if {@code index} is invalid;
     *            if {@code comp} is a child of this container, the valid
     *            range is {@code [-1, getComponentCount()-1]}; if component is
     *            not a child of this container, the valid range is
     *            {@code [-1, getComponentCount()]}
     *
     * @exception IllegalArgumentException if {@code comp} is an ancestor of
     *                                     this container
     * @exception IllegalArgumentException if adding a window to a container
     * @exception NullPointerException if {@code comp} is {@code null}
     * @see       #add(Component)
     * @see       #add(Component, int)
     * @see       #add(Component, java.lang.Object)
     * @see #invalidate
     * @see       LayoutManager
     * @see       LayoutManager2
     * @since     JDK1.1
     */
    protected void addImpl(Component comp, Object constraints, int index) {
        if (layoutMgr == null) {
            viewGroup.addView(comp.getAndroidView());
        } else {
            /* Notify the layout manager of the added component. */
            if (layoutMgr != null) {
                if (layoutMgr instanceof LayoutManager2) {
                    ((LayoutManager2)layoutMgr).addLayoutComponent(comp, constraints);
                } else if (constraints instanceof String) {
                    layoutMgr.addLayoutComponent((String)constraints, comp);
                }
            }
        }
    }

    public void remove(Component comp) {
        //TODO remove()
    }

    public void setLayout(LayoutManager mgr) {
        layoutMgr = mgr;
        mgr.layoutContainer(this);
        //TODO invalidateIfValid();
    }

    @Override
    public View getAndroidView() {
        return viewGroup;
    }

}
