package kr.softcampus.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    // Activity 생성될 때 자동 호출
    // 화전 회면이 발생했을 때 자동 호출
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //System.out.println("onCreaate method 호출");
        Log.d("test", "onCreate 호출");
    }

    @Override
    // onCreate 호출 이후 자동으로 호출된다.
    // Activity가 정지상태에서 활동상태로 돌아올 때 호출된다.
    protected void onStart() {
        super.onStart();
        Log.d("test","onStart 호출");
    }

    @Override
    // onStart 호출 이후 자동으로 호출된다.
    // Activity가 일시정지 상태에서 돌아올 때 호출된다.
    protected void onResume() {
        super.onResume();
        Log.d("test","onResume 호출");
    }

    @Override
    // Activity가 정지상태에서 활동상태로 돌아올 때 onStart메서드 전에 호출된다.
    protected void onRestart() {
        super.onRestart();
        Log.d("test","onRestart 호출");
    }

    @Override
    // Activity가 일시정지 상태가 될때 호출된다.
    // 화면상에서 완전히 사라지거나 작은 팝업 창 나타날 때 호출
    protected void onPause() {
        super.onPause();
        Log.d("test","onPause 호출");
    }

    @Override
    // Activity 화면상에서 사라질 때 호출된다.
    protected void onStop() {
        super.onStop();
        Log.d("test","onStop 호출");
    }

    @Override
    // 현재 Activity의 수행이 완전히 종료되어 메모리 상에서 제거될 때
    protected void onDestroy() {
        super.onDestroy();
        Log.d("test","onDestroy 호출");
    }
}