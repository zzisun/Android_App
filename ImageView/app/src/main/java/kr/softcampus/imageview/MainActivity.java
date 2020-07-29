package kr.softcampus.imageview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView img3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img3 = (ImageView)findViewById(R.id.imageView3);

        //이미지 세팅한다.
        img3.setImageResource(R.drawable.img_android);
    }
}