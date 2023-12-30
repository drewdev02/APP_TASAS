package com.tasa.cambio;

import static com.tasa.cambio.Utility.cropImage;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RemoteViews;

import com.squareup.picasso.Picasso.LoadedFrom;
import com.squareup.picasso.Target;

public class ProcessImages implements Target {
    private static final String TAG = "ProcesImages";
    private ImageView imageView;
    private Context context;
    private AppWidgetManager appWidgetManager;
    private int appWidgetId;

    public ProcessImages(ImageView imageView) {
        this.imageView = imageView;
    }

    public ProcessImages(Context context, AppWidgetManager appWidgetManager, int appWidgetId) {
        this.context = context;
        this.appWidgetManager = appWidgetManager;
        this.appWidgetId = appWidgetId;

    }

    @Override
    public void onBitmapLoaded(Bitmap bitmap, LoadedFrom from) {
        int width = bitmap.getWidth();
        int startX = 0;
        int startY = 1216;
        final int height = 1210;

        Bitmap croppedBitmap = cropImage(bitmap,
                startX,
                startY,
                width,
                height);

        if (imageView != null) {
            Log.i(TAG, "onBitmapLoaded");
            imageView.setImageBitmap(croppedBitmap);
        } else {
            Log.i(TAG, "widgetLoaded");
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_layout);
            views.setImageViewBitmap(R.id.imageView, croppedBitmap);
            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }

    @Override
    public void onBitmapFailed(Exception e, Drawable errorDrawable) {
        Log.e(TAG, "onBitmapFailed: ", e);
    }

    @Override
    public void onPrepareLoad(Drawable placeHolderDrawable) {
        Log.i(TAG, "onPrepareLoad");
    }
}