package net.pbdavey.awt.demo;

import android.app.Application;
import android.content.Context;

public class DemoApp extends Application {
    private static DemoApp instance;

    public DemoApp() {
        instance = this;
    }

    public static Context getContext() {
        return instance;
    }
}
