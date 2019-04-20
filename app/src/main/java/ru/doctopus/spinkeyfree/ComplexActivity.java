package ru.doctopus.spinkeyfree;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import ru.doctopus.spinkeyfree.R;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ComplexActivity extends AppCompatActivity {

    private ImageView demonstrative;
    private TextView info;
    private Toolbar toolbar;

    private MediaPlayer mPlayer;

    private ArrayList<String> namesExercise = new ArrayList<>(); // названия упражнений комплекса 1
    private ArrayList<String> instructions = new ArrayList<>(); // информация упражнений комплекса 1
    private ArrayList<Integer> imagesBoy = new ArrayList<>(); // картинки с инструкциями (мальчик)
//    private ArrayList<Integer> imagesGirl = new ArrayList<>(); // картинки с инструкциями (девочка)
    private int currentExercise = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complex);

        setData(); // загружаем данные

        demonstrative = findViewById(R.id.demonstrative);
        info = findViewById(R.id.info);
        toolbar = findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            if (getSupportActionBar() != null) {
                getSupportActionBar().setDisplayShowTitleEnabled(false);
                toolbar.setTitle(namesExercise.get(currentExercise));
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                getSupportActionBar().setDisplayShowHomeEnabled(true);
            }
        }

        // устанавливаем первое упражнение
        demonstrative.setImageDrawable(getResources().getDrawable(R.drawable.gimnastika_boy_01));
        info.setText(instructions.get(currentExercise));

        // изначально освобождаем ресурсы проигрывателя
        releaseMP();

        // создаем плеер и задаем источник
        mPlayer = MediaPlayer.create(this, R.raw.see_saw);
        mPlayer.setLooping(true);
        mPlayer.start();


    }


    // переход на следующее упражнение
    public void nextExercise(View view) {
        currentExercise++;
        Log.i("test", currentExercise+"");
        if (currentExercise == namesExercise.size()) {
            toolbar.setTitle(R.string.finish_exercise);
            demonstrative.setImageResource(R.drawable.logo);
            info.setText(getString(R.string.praise));
            findViewById(R.id.btn).setVisibility(View.GONE);
            if (mPlayer.isPlaying())
                mPlayer.pause();
        } else
            updateUI();
    }


    // обновление интерфейса
    private void updateUI() {
        toolbar.setTitle(namesExercise.get(currentExercise));
        demonstrative.setImageResource(imagesBoy.get(currentExercise));
        info.setText(instructions.get(currentExercise));
    }


    // загружаем данные
    private void setData() {
        namesExercise.add(getString(R.string.complex_1_exercise_1_name));
        namesExercise.add(getString(R.string.complex_1_exercise_2_name));
        namesExercise.add(getString(R.string.complex_1_exercise_3_name));
        namesExercise.add(getString(R.string.complex_1_exercise_4_name));
        namesExercise.add(getString(R.string.complex_1_exercise_5_name));
        namesExercise.add(getString(R.string.complex_1_exercise_6_name));
        namesExercise.add(getString(R.string.complex_1_exercise_7_name));
        namesExercise.add(getString(R.string.complex_1_exercise_8_name));
        namesExercise.add(getString(R.string.complex_1_exercise_9_name));
        namesExercise.add(getString(R.string.complex_1_exercise_10_name));
        namesExercise.add(getString(R.string.complex_1_exercise_11_name));
        namesExercise.add(getString(R.string.complex_1_exercise_12_name));

        instructions.add(getString(R.string.complex_1_exercise_1_info));
        instructions.add(getString(R.string.complex_1_exercise_2_info));
        instructions.add(getString(R.string.complex_1_exercise_3_info));
        instructions.add(getString(R.string.complex_1_exercise_4_info));
        instructions.add(getString(R.string.complex_1_exercise_5_info));
        instructions.add(getString(R.string.complex_1_exercise_6_info));
        instructions.add(getString(R.string.complex_1_exercise_7_info));
        instructions.add(getString(R.string.complex_1_exercise_8_info));
        instructions.add(getString(R.string.complex_1_exercise_9_info));
        instructions.add(getString(R.string.complex_1_exercise_10_info));
        instructions.add(getString(R.string.complex_1_exercise_11_info));
        instructions.add(getString(R.string.complex_1_exercise_12_info));

        imagesBoy.add(R.drawable.gimnastika_boy_01);
        imagesBoy.add(R.drawable.gimnastika_boy_02);
        imagesBoy.add(R.drawable.gimnastika_boy_03);
        imagesBoy.add(R.drawable.gimnastika_boy_04);
        imagesBoy.add(R.drawable.gimnastika_boy_05);
        imagesBoy.add(R.drawable.gimnastika_boy_06);
        imagesBoy.add(R.drawable.gimnastika_boy_07);
        imagesBoy.add(R.drawable.gimnastika_boy_08);
        imagesBoy.add(R.drawable.gimnastika_boy_09);
        imagesBoy.add(R.drawable.gimnastika_boy_10);
        imagesBoy.add(R.drawable.gimnastika_boy_11);
        imagesBoy.add(R.drawable.gimnastika_boy_12);

     /*   imagesGirl.add(R.drawable.gimnastika_girl_01);
        imagesGirl.add(R.drawable.gimnastika_girl_02);
        imagesGirl.add(R.drawable.gimnastika_girl_03);
        imagesGirl.add(R.drawable.gimnastika_girl_04);
        imagesGirl.add(R.drawable.gimnastika_girl_05);
        imagesGirl.add(R.drawable.gimnastika_girl_06);
        imagesGirl.add(R.drawable.gimnastika_girl_07);
        imagesGirl.add(R.drawable.gimnastika_girl_08);
        imagesGirl.add(R.drawable.gimnastika_girl_09);
        imagesGirl.add(R.drawable.gimnastika_girl_10);
        imagesGirl.add(R.drawable.gimnastika_girl_11);
        imagesGirl.add(R.drawable.gimnastika_girl_12);*/
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


    // освобождаем ресурсы проигрывателя при выходе из приложения
    @Override
    public void onDestroy() {
        super.onDestroy();
        releaseMP();
    }


    // освобождаем ресурсы проигрывателя
    private void releaseMP() {
        if (mPlayer != null) {
            try {
                mPlayer.release();
                mPlayer = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}