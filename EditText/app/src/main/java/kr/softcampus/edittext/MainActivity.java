package kr.softcampus.edittext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edit1;
    TextView text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit1 = (EditText)findViewById(R.id.editTextTextPersonName);
        text1 = (TextView)findViewById(R.id.textView);

        EnterListner listner = new EnterListner();
        edit1.setOnEditorActionListener(listner);

        WatcherClass watcher = new WatcherClass();
        edit1.addTextChangedListener(watcher);
    }

    public void btn1Method(View view){
        edit1.setText("new string");
    }

    public void btn2Method(View view){
        String str = edit1.getText().toString();
        text1.setText("string entered: "+str);
    }

    class EnterListner implements TextView.OnEditorActionListener{
        @Override
        public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {

            String str = textView.getText().toString();

            text1.setText("string entered: "+str);

            return false; //입력 후 키보드 사라진다.
           // return true;
        }
    }

    class WatcherClass implements TextWatcher{
        //입력에 따라 변하는 텍스트 구현
        @Override
        //문자열 값이 변경되었을 때
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            text1.setText("Changing text: "+charSequence);
        }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    }
}