package com.tasa.cambio;

import static com.tasa.cambio.Utility.*;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initComponent();
    }

    private void initComponent() {
        Log.i(TAG, "initComponent");
        setContentView(R.layout.activity_main);
        ImageView imageView = findViewById(R.id.imageView);
        loadImageFromUrl(Config.url, new ProcessImages(imageView));
    }
}