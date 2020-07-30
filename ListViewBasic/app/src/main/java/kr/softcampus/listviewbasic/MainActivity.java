package kr.softcampus.listviewbasic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text1;
    ListView list1;
    String [] data1 = {//리스트뷰 구성을 위해 필요한 문자열 배열
        "list1", "list2", "list3", "list4", "list5", "list6", "list7", "list8", "list9", "list10", "list11", "list12", "list13", "list14", "list15", "list16","list17", "list18"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = (TextView)findViewById(R.id.textView);
        list1 = (ListView)findViewById(R.id.list1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data1);

        list1.setAdapter(adapter);

        ListListener listListener = new ListListener();
        list1.setOnItemClickListener(listListener);
    }

    class ListListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            text1.setText(data1[position]);
        }
    }
}