package kr.softcampus.twolinelistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    String [] data1 = {
            "string1", "string2", "string3", "string4", "string5"
    };
    String [] data2 = {
            "문자열1", "문자열2", "문자열3", "문자열4", "문자열5"
    };

    ListView list1;
    TextView text1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list1 = (ListView)findViewById(R.id.list1);
        text1 = (TextView)findViewById(R.id.textView);
        //데이터를 담을 ArrayList
        ArrayList<HashMap<String, String>> data_list = new ArrayList<>();
        for(int i=0; i< data1.length; i++){
            HashMap<String,String> map = new HashMap<>();
            map.put("str1", data1[i]);
            map.put("str2", data2[i]);

            data_list.add(map);
        }
        String [] keys = {"str1", "str2"};
        int [] ids = {android.R.id.text1, android.R.id.text2};
      //  android.R.layout.simple_list_item_2
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, data_list, android.R.layout.simple_list_item_2, keys, ids);
        list1.setAdapter(simpleAdapter);

        ListListener listListener = new ListListener();
        list1.setOnItemClickListener(listListener);
    }
    class ListListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            text1.setText("select: "+data1[i]+data2[i]);
        }
    }
}