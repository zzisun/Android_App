package kr.softcampus.customlistview2;

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
//SimpleAdapter를 사용하여 english, korean 두개의 뷰에 데이터를 세팅한다.
    //listView data
    int [] imgRes = {
            R.drawable.imgflag1, R.drawable.imgflag2, R.drawable.imgflag3, R.drawable.imgflag4, R.drawable.imgflag5, R.drawable.imgflag6, R.drawable.imgflag7, R.drawable.imgflag8
    };
    String [] data1 = {
            "Togo", "France", "Swiss", "Spain", "Japan", "Germany", "Brazil", "Korea"
    };
    String [] data2 = {
            "토고", "프랑스", "스위스", "스페인", "일본", "독일", "브라질", "대한민국"
    };
    ListView list1;

    TextView select;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list1 = (ListView)findViewById(R.id.list1);
        select = (TextView)findViewById(R.id.textView3);
        select.setText("what you select!");

        //데이터를 가지고 있는 ArrayList 생성한다.
        ArrayList<HashMap<String,Object>> data_list = new ArrayList<>();

        for(int i=0; i<imgRes.length; i++){
            //항목 하나를 구성하기 위해 데이터를 해시맵에 담는다.
            HashMap<String, Object> map = new HashMap<>();
            map.put("flag", imgRes[i]);
            map.put("data1", data1[i]);
            map.put("data2", data2[i]);

            data_list.add(map);
        }
        //해시 맵 객체에 데이터를 저장할 때 사용한 이름 배열
        String [] keys = {"flag", "data1", "data2"};
        //데이터를 세팅할 뷰의 id
        int [] ids = {R.id.imageView, R.id.textView, R.id.textView2};

        SimpleAdapter simpleAdapter = new SimpleAdapter(this, data_list, R.layout.row, keys, ids);
        list1.setAdapter(simpleAdapter);

        ListListener listListener = new ListListener();
        list1.setOnItemClickListener(listListener);
    }

    class ListListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            select.setText("select: "+data1[position]+data2[position]);
        }
    }

}