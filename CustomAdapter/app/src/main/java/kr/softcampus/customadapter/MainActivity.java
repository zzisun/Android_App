package kr.softcampus.customadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
//  listView 항목에 button 2개를 배치한다.

    ListView list1;
    TextView text1;
    String [] data = {
            "data1", "data2", "data3", "data4", "data5", "data6"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list1 = (ListView)findViewById(R.id.list1);
        text1 = (TextView)findViewById(R.id.textView2);

        // adapter setting
        ListAdapter adapter = new ListAdapter();
        list1.setAdapter(adapter);
    }

    class ListAdapter extends BaseAdapter{

        BtnListener listener = new BtnListener();

        @Override
        public int getCount() {// listView 전체 항목의 개수를 반환
            return data.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {// ListView 항목 하나를 구성하여 반환
            // 재사용 가능한 뷰가 없다면 뷰를 만들어준다.
            if(view == null){
                LayoutInflater inflater = getLayoutInflater();
                view = inflater.inflate(R.layout.row, null);
            }

            // 뷰를 구성한다.
            TextView sub_text = (TextView)view.findViewById(R.id.textView);
            Button sub_btn1 = (Button)view.findViewById(R.id.button2);
            Button sub_btn2 = (Button)view.findViewById(R.id.button3);

            sub_btn1.setOnClickListener(listener);
            sub_btn2.setOnClickListener(listener);

            sub_text.setText(data[i]);

            //버튼의 인덱스 값을 저장한다.
            sub_btn1.setTag(i+1);
            sub_btn2.setTag(i+1);

            //뷰를 반환한다.
            return view;
        }
    }

    class BtnListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            // 버튼의 아이디를 추출한다.
            int id = view.getId();

            //  리스트의 인덱스 값 추출한다.
            int position = (Integer)view.getTag();

            switch(id){
                case R.id.button2:
                    text1.setText("data"+position+": Button1 is clicked.");
                    break;
                case R.id.button3:
                    text1.setText("data"+position+": Button2 is clicked.");
                    break;
            }
        }
    }
}