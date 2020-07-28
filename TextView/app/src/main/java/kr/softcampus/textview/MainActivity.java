package kr.softcampus.textview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);// 주소값 설정
        // id 속성이 text2인 뷰의 주소값을 얻어왔다.
        text1 = (TextView)findViewById(R.id.text2);
        text1.setText("새로운 문자열");
    }
}