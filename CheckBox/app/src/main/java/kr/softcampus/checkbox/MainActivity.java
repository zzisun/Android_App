package kr.softcampus.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //뷰의 주소값을 담을 참조변수
    TextView text1;
    CheckBox check1,check2,check3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = (TextView)findViewById(R.id.textView);
        check1 = (CheckBox)findViewById(R.id.checkBox);
        check2 = (CheckBox)findViewById(R.id.checkBox2);
        check3 = (CheckBox)findViewById(R.id.checkBox3);

        //체크박스의 리스너 설정한다.
        CheckBoxListener listener = new CheckBoxListener();
        check1.setOnCheckedChangeListener(listener);
        check2.setOnCheckedChangeListener(listener);
        check3.setOnCheckedChangeListener(listener);
    }

    //체크상태를 확인한다. (첫번째 버튼과 연결)
    public void btn1Method(View view){
        text1.setText("");

        boolean a1 = check1.isChecked();
        boolean a2 = check2.isChecked();
        boolean a3 = check3.isChecked();

        if(a1){
            text1.append("첫번째 체크박스가 체크되었습니다.\n");
        }
        if(a2){
            text1.append("두번째 체크박스가 체크되었습니다.\n");
        }
        if(a3){
            text1.append("세번째 체크박스가 체크되었습니다.\n");
        }
    }

    //모든 체크박스의 상태를 체크상태로 설정한다. (두번째 버튼과 연결)
    public void btn2Method(View view){
        check1.setChecked(true);
        check2.setChecked(true);
        check3.setChecked(true);
    }

    // 모든 체크박스의 상태를 체크해제로 설정한다. (세번째 버튼과 연결)
    public void btn3Method(View view){
        check1.setChecked(false);
        check2.setChecked(false);
        check3.setChecked(false);
    }

    // 모든 체크박스의 상태를 반전시킨다. (네번째 버튼과 연결)
    public void btn4Method(View view){
        check1.toggle();
        check2.toggle();
        check3.toggle();
    }

    //체크박스의 체크상태가 변경되면 반응하는 리스너
    class CheckBoxListener implements CompoundButton.OnCheckedChangeListener{
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            //체크상태가 변경된 체크박스의 id를 가져온다.
            int id = compoundButton.getId();
            switch(id){
                case R.id.checkBox:
                    if(b){
                        text1.setText("첫번째 체크 박스가 체크되었습니다.");
                    }
                    else{
                        text1.setText("첫번째 체크 박스가 체크 해제되었습니다.");
                    }
                    break;
                case R.id.checkBox2:
                    if(b){
                        text1.setText("두번째 체크 박스가 체크되었습니다.");
                    }
                    else{
                        text1.setText("두번째 체크 박스가 체크 해제되었습니다.");
                    }
                    break;
                case R.id.checkBox3:
                    if(b){
                        text1.setText("세번째 체크 박스가 체크되었습니다.");
                    }
                    else{
                        text1.setText("세번째 체크 박스가 체크 해제되었습니다.");
                    }
                    break;
            }
        }
    }

}