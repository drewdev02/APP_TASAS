package com.tasa.cambio;

import static com.tasa.cambio.Utility.loadImageFromUrl;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;

import java.util.Arrays;
import java.util.Objects;

public class Widget extends AppWidgetProvider {
    public static final String TAG = "Widget";
    @Override
    public void onEnabled(Context context) {
        Log.i(TAG, "onEnabled");
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        Log.i(TAG, "onUpdate");
        Arrays.stream(appWidgetIds).forEach(appWidgetId -> updateWidget(context, appWidgetManager, appWidgetId));
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "onReceive");
        if (Objects.nonNull(intent.getAction())) {
            Log.i(TAG, Objects.requireNonNull(intent.getAction()));
        }
    }

    @Override
    public void onAppWidgetOptionsChanged(Context context, AppWidgetManager appWidgetManager, int appWidgetId, Bundle newOptions) {
        Log.i(TAG, "onAppWidgetOptionsChanged");
        updateWidget(context, appWidgetManager, appWidgetId);
    }

    @Override
    public void onRestored(Context context, int[] oldWidgetIds, int[] newWidgetIds) {
        Log.i(TAG, "onRestored");
    }
    private void updateWidget(@NonNull Context context, @NonNull AppWidgetManager appWidgetManager, int appWidgetId) {
        Log.i(TAG, "updateWidget");
        loadImageFromUrl(Config.url, new ProcessImages(context, appWidgetManager, appWidgetId));
    }
}
