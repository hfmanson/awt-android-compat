package net.pbdavey.awt;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import java.awt.Graphics;
import java.awt.Image;

public class ImageImpl extends Image {
    private Bitmap bitmap;
    private Canvas canvas;

    ImageImpl() {
    }

    public ImageImpl(int width, int height) {
        bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
    }

    @Override
    public Graphics getGraphics() {
        return new Graphics2D(canvas);
    }

    Bitmap getAndroidBitmap() {
        return bitmap;
    }
}
