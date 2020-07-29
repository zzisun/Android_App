package kr.softcampus.seekbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text1;
    TextView text2;
    SeekBar bar1;
    SeekBar bar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = (TextView)findViewById(R.id.textView);
        text2 = (TextView)findViewById(R.id.textView2);
        bar1 = (SeekBar)findViewById(R.id.seekBar);
        bar2 = (SeekBar)findViewById(R.id.seekBar2);

        SeekBarListener listener = new SeekBarListener();
        bar1.setOnSeekBarChangeListener(listener);
        bar2.setOnSeekBarChangeListener(listener);
    }

    public void btn1Method(View view){
        bar1.incrementProgressBy(1);
        bar2.incrementProgressBy(1);
    }
    public void btn2Method(View view){
        bar1.incrementProgressBy(-1);
        bar2.incrementProgressBy(-1);
    }
    public void btn3Method(View view){
        bar1.setProgress(7);
        bar2.setProgress(3);
    }
    public void btn4Method(View view){
        int value1 = bar1.getProgress();
        int value2 = bar2.getProgress();

        text1.setText("bar1: "+value1);
        text2.setText("bar2: "+value2);
    }

    class SeekBarListener implements SeekBar.OnSeekBarChangeListener{
        @Override
        // react when changing value
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            int id = seekBar.getId();
            switch(id){
                case R.id.seekBar:
                    text1.setText("1st SeekBar: "+progress);
                    break;
                case R.id.seekBar2:
                    text1.setText("2nd SeekBar: "+progress);
                    break;
            }

            if(fromUser){
                text2.setText("Changed by User");
            }
            else{
                text2.setText("Changed by Code");
            }
        }

        @Override
        // called when touching to change value
        public void onStartTrackingTouch(SeekBar seekBar) {
            int id = seekBar.getId();
            switch(id){
                case R.id.seekBar:
                    text2.setText("touch the 1st SeekBar");
                    break;
                case R.id.seekBar2:
                    text2.setText("touch the 2nd SeekBar");
                    break;
            }

        }

        @Override
        // called after touching to change value
        public void onStopTrackingTouch(SeekBar seekBar) {
            int id = seekBar.getId();
            switch(id){
                case R.id.seekBar:
                    text2.setText("leave the 1st SeekBar");
                    break;
                case R.id.seekBar2:
                    text2.setText("leave the 2nd SeekBar");
                    break;
            }
        }
    }
}