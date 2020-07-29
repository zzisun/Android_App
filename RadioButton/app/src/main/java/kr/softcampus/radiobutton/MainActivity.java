package kr.softcampus.radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RadioButton radio3, radio4;
    RadioGroup group1, group2;
    TextView text1, text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = (TextView)findViewById(R.id.textView3);
        text2 = (TextView)findViewById(R.id.textView4);
        radio3 = (RadioButton)findViewById(R.id.radioButton3);
        radio4 = (RadioButton)findViewById(R.id.radioButton4);
        group1 = (RadioGroup)findViewById(R.id.group1);
        group2 = (RadioGroup)findViewById(R.id.group2);

        //라디오 그룹에 리스너를 설정한다.
        RadioListener listener = new RadioListener();
        group1.setOnCheckedChangeListener(listener);
        group2.setOnCheckedChangeListener(listener);
    }

    public void btn1Method(View view){
        radio3.setChecked(true);
        radio4.setChecked(true);
    }

    public void btn2Method(View view){
        // 각 라디오 그룹 내에서 선택되어 있는 라디오 버튼의 id값을 가져온다.
        int id1 = group1.getCheckedRadioButtonId();
        int id2 = group2.getCheckedRadioButtonId();

        switch(id1){
            case R.id.radioButton:
                text1.setText("Radio 1-1 이 선택되었습니다.");
                break;
            case R.id.radioButton2:
                text1.setText("Radio 1-2 이 선택되었습니다.");
                break;
            case R.id.radioButton3:
                text1.setText("Radio 1-3 이 선택되었습니다.");
                break;
        }

        switch(id2){
            case R.id.radioButton4:
                text2.setText("Radio 2-1 이 선택되었습니다.");
                break;
            case R.id.radioButton5:
                text2.setText("Radio 2-2 이 선택되었습니다.");
                break;
            case R.id.radioButton6:
                text2.setText("Radio 2-3 이 선택되었습니다.");
                break;
        }
    }

    class RadioListener implements RadioGroup.OnCheckedChangeListener{
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
            // 체크 상태가 변경된 라디오 그룹의 아이디를 추출한다.
            int id = radioGroup.getId();

            switch(id){
                case R.id.group1:
                    switch(checkedId){
                        case R.id.radioButton:
                            text1.setText("라디오 버튼 이벤트: 1-1");
                            break;
                        case R.id.radioButton2:
                            text1.setText("라디오 버튼 이벤트: 1-2");
                            break;
                        case R.id.radioButton3:
                            text1.setText("라디오 버튼 이벤트: 1-3");
                            break;
                    }
                    break;
                case R.id.group2:
                    switch(checkedId){
                        case R.id.radioButton4:
                            text2.setText("라디오 버튼 이벤트: 2-1");
                            break;
                        case R.id.radioButton5:
                            text2.setText("라디오 버튼 이벤트: 2-2");
                            break;
                        case R.id.radioButton6:
                            text2.setText("라디오 버튼 이벤트: 2-3");
                            break;
                    }
                    break;
            }
        }
    }
}