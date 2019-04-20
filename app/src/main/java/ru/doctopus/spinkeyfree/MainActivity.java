package ru.doctopus.spinkeyfree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.about).setOnClickListener(this);
        findViewById(R.id.complex_1).setOnClickListener(this);
        findViewById(R.id.complex_2).setOnClickListener(this);
        findViewById(R.id.complex_3).setOnClickListener(this);
        findViewById(R.id.complex_4).setOnClickListener(this);
        findViewById(R.id.complex_5).setOnClickListener(this);
        findViewById(R.id.recommendations).setOnClickListener(this);
        findViewById(R.id.progress).setOnClickListener(this);

        // установка toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        if (toolbar != null) {
            toolbar.setTitle(getString(R.string.main_name));
            setSupportActionBar(toolbar);
            
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.about:
                startActivity(new Intent(this, PreviewComplexActivity.class).putExtra("action", getString(R.string.app_name)));
                break;
            case R.id.complex_1:
                startActivity(new Intent(this, PreviewComplexActivity.class).putExtra("action", getString(R.string.complex_1)));
                break;
            case R.id.complex_2:
                startActivity(new Intent(this, PreviewComplexActivity.class).putExtra("action", getString(R.string.complex_2)));
                break;
            case R.id.complex_3:
                startActivity(new Intent(this, PreviewComplexActivity.class).putExtra("action", getString(R.string.complex_3)));
                break;
            case R.id.complex_4:
                startActivity(new Intent(this, PreviewComplexActivity.class).putExtra("action", getString(R.string.complex_4)));
                break;
            case R.id.complex_5:
                startActivity(new Intent(this, PreviewComplexActivity.class).putExtra("action", getString(R.string.complex_5)));
                break;
            case R.id.recommendations:
                startActivity(new Intent(this, PreviewComplexActivity.class).putExtra("action", getString(R.string.recommendations)));
                break;
            case R.id.progress:
                startActivity(new Intent(this, PreviewComplexActivity.class).putExtra("action", getString(R.string.progress)));
                break;
        }
    }

}