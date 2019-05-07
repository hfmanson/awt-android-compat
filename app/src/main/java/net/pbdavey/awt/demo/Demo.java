package net.pbdavey.awt.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import java.awt.Button;
import java.awt.event.MouseListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import awttests.ButtonGrid;

public class Demo extends Activity {
    private View getJarSwampView() {
        try {
            Class swampClass = Class.forName("swamp");
            Constructor swampConstructor = swampClass.getDeclaredConstructor(boolean.class, Button.class, String.class, String.class, String.class, boolean.class);
            swampConstructor.setAccessible(true);
            Object swamp = swampConstructor.newInstance(false, new Button(), "750163142401214144", "3125402453235313641245", "",false);
            Method addMouseListener = swampClass.getMethod("addMouseListener", MouseListener.class);
            addMouseListener.invoke(swamp, swamp);
            Method getAndroidView = swampClass.getMethod("getAndroidView");
            return (View) getAndroidView.invoke(swamp);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    private View getJarPlanksView() {
        try {
            //planks planks = new planks();
            //planks.init();
            //return planks1.getAndroidView();
            Class planksClass = Class.forName("planks");
            Object planks = planksClass.newInstance();
            Method init = planksClass.getMethod("init");
            init.invoke(planks);
            Method getAndroidView = planksClass.getMethod("getAndroidView");
            return (View) getAndroidView.invoke(planks);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    private View getAwtTestView() {
        ButtonGrid buttonGrid = new ButtonGrid();
        buttonGrid.init();
        return buttonGrid.getAndroidView();
    }
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.borderlayout);
        //setContentView(getAwtTestView());
        setContentView(getJarPlanksView());
    }
}
