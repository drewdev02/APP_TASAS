package com.tasa.cambio;

import android.graphics.Bitmap;
import android.util.Log;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class Utility {
    public static final String TAG = "Utility";

    private Utility() {
    }

    public static void loadImageFromUrl(String url, Target target) {
        Log.i(TAG, "loadImageFromUrl");
        Picasso.get().load(url)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(target);
    }
    public static Bitmap cropImage(Bitmap originalBitmap, int startX, int startY, int width, int height) {
        return Bitmap.createBitmap(originalBitmap, startX, startY, width, height);
    }
}
