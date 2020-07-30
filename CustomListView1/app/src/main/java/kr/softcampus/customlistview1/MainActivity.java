package kr.softcampus.customlistview1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
// ListView 항목히나에 문자열 1개만 배열
    ListView list1;
    String [] data = {
            "data1", "data2", "data3", "data4", "data5"
    };

    TextView text2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list1 = (ListView)findViewById(R.id.list1);
        text2 = (TextView)findViewById(R.id.textView2);

        // create adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.row,R.id.textView, data); // row 파일 내에 adapter 생성 후 textView에 data를 넣어라
        list1.setAdapter(adapter);//listView를 adapter에 셋팅한다.

        ListListener listListener = new ListListener();
        list1.setOnItemClickListener(listListener);
    }

    class ListListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            text2.setText( "select: "+ data[position]);
        }
    }
}