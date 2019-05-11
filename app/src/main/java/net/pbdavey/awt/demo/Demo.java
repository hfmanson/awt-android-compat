package net.pbdavey.awt.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import java.awt.Button;
import java.awt.event.MouseListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

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

    private View getAppletView(String appletClassName, Map<String, String> parameters) {
        try {
            Class appletClass = Class.forName(appletClassName);
            Object applet = appletClass.newInstance();
            Method setParameters = appletClass.getMethod("setParameters", Map.class);
            setParameters.invoke(applet, parameters);
            Method init = appletClass.getMethod("init");
            init.invoke(applet);
            Method getAndroidView = appletClass.getMethod("getAndroidView");
            return (View) getAndroidView.invoke(applet);
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

    private View getPlanksSampleView() {
        String appletClassName = "planks";
        Map<String, String> parameters = new HashMap<>();
        parameters.put("positions", "730161011122421040,A30191012150806162,A30191404101212252,A30191012120211242,A30191303110300131");
        parameters.put("nodes", "2144013641245,4145850246941368,4145850246942568,51246750257941458,4136850347942467");
        parameters.put("titles", "sample, sample, sample, sample, sample");
        return getAppletView(appletClassName, parameters);
    }

    private View getPlanks3PuzzlesView() {
        String appletClassName = "planks";
        Map<String, String> parameters = new HashMap<>();
        parameters.put("positions", "750163142401214144,A80295636402222427,B902A6657548680232");
        parameters.put("nodes", "3125402453235313641245,51247832385025674136841246534579315842356,413484367940357612458931474367952348A51358941469");
        parameters.put("titles", "Deep-End, Smash-Hit, Route-66");
        return getAppletView(appletClassName, parameters);
    }

    private View getPlanksHexView() {
        String appletClassName = "planks";
        Map<String, String> parameters = new HashMap<>();
        parameters.put("positions", "97028450514565023226666");
        parameters.put("nodes", "31454135630372354247831463267");
        parameters.put("titles", "Four-by-four");
        return getAppletView(appletClassName, parameters);
    }

    private View getNoLeftTurnView() {
        String appletClassName = "lrs2";
        return getAppletView(appletClassName, null);
    }

    private View getOMazeView() {
        String appletClassName = "OMaze";
        return getAppletView(appletClassName, null);
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
        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //setContentView(R.layout.borderlayout);
        //setContentView(getAwtTestView());
        //View appletView = getPlanks3PuzzlesView();
        //View appletView = getPlanksHexView();
        View appletView = getNoLeftTurnView();
        //View appletView = getOMazeView();
        setContentView(appletView);
    }
}
