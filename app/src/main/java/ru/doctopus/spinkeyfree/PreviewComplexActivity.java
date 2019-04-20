package ru.doctopus.spinkeyfree;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import ru.doctopus.spinkeyfree.R;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PreviewComplexActivity extends AppCompatActivity {

    private ImageView logo;
    private TextView info;
    private Button btn;

    private String action = null;

    DownloadProActivity downloadProActivity = new DownloadProActivity();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview_complex);
        action = getIntent().getExtras().getString("action", null);

        logo = findViewById(R.id.logo);
        info = findViewById(R.id.info);
        btn = findViewById(R.id.btn);

        // установка toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            if (getSupportActionBar() != null) {
                getSupportActionBar().setDisplayShowTitleEnabled(false);
                toolbar.setTitle(action);
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                getSupportActionBar().setDisplayShowHomeEnabled(true);
            }
        }

        chooseActivity(action);
    }


    private void chooseActivity(String action) {
        if (action.equals(getString(R.string.app_name))) {
            logo.setVisibility(View.VISIBLE);
            info.setText(getString(R.string.info_about));
            btn.setText(getString(R.string.download));
        }
        if (action.equals(getString(R.string.complex_1))) {
            info.setText(getString(R.string.info_complex_1));
            btn.setText(getString(R.string.start_complex));
        }
        if (action.equals(getString(R.string.complex_2))) {
            info.setText(getString(R.string.info_complex_2));
            btn.setText(getString(R.string.start_complex));
        }
        if (action.equals(getString(R.string.complex_3))) {
            info.setText(getString(R.string.info_complex_3));
            btn.setText(getString(R.string.start_complex));
        }
        if (action.equals(getString(R.string.complex_4))) {
            info.setText(getString(R.string.info_complex_4));
            btn.setText(getString(R.string.start_complex));
        }
        if (action.equals(getString(R.string.complex_5))) {
            info.setText(getString(R.string.info_complex_5));
            btn.setText(getString(R.string.start_complex));
        }
        if (action.equals(getString(R.string.recommendations))) {
            info.setText(getString(R.string.info_recommendations));
            btn.setText(getString(R.string.choose_complex));
        }
        if (action.equals(getString(R.string.progress))) {
            info.setText(getString(R.string.info_progress));
            btn.setVisibility(View.GONE);
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

    public void startComplex(View view) {
        if (action.equals(getString(R.string.app_name)))
            download();
        else if (action.equals(getString(R.string.recommendations)))
            startActivity(new Intent(this, MainActivity.class));
        else if (action.equals(getString(R.string.complex_1)))
            startActivity(new Intent(this, ComplexActivity.class));

        /** нижнеследующий блок else if закрыт в бесплатной версии, чтобы ограничить доступ к полному набору комплексов упражнений

        else if (action.equals(getString(R.string.complex_2)))
            startActivity(new Intent(this, ComplexActivity.class));
        else if (action.equals(getString(R.string.complex_3)))
            startActivity(new Intent(this, ComplexActivity.class));
        else if (action.equals(getString(R.string.complex_4)))
            startActivity(new Intent(this, ComplexActivity.class));
        else if (action.equals(getString(R.string.complex_5)))
            startActivity(new Intent(this, ComplexActivity.class));

         */

        else
            startActivity(new Intent(this, DownloadProActivity.class));
    }


    public void download() {
        String appPackageName = "ru.bruimafia.spinkey"; // здесь должно быть имя пакета платной версии приложения
        try {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
        } catch (android.content.ActivityNotFoundException anfe) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
        }
    }

}