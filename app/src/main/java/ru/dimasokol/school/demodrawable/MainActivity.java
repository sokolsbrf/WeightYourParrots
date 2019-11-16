package ru.dimasokol.school.demodrawable;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private SeekBar mLevelBar;
    private ImageView mDemoDrawableView;
    private View mButton;
    private TextView mParrotsView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDemoDrawableView = findViewById(R.id.demo_drawable);
        mButton = findViewById(R.id.button);
        mParrotsView = findViewById(R.id.demo_quantity);

        mLevelBar = findViewById(R.id.seek_level);
        mLevelBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mDemoDrawableView.setImageLevel(progress);
                String parrots = getResources().getQuantityString(R.plurals.parrots, progress, progress);
                mParrotsView.setText(parrots);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mButton.setEnabled(false);
            }
        });
    }
}
