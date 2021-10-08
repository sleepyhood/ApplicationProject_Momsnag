package com.example.user.applicationproject_momsnag;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Alarms> alarms = new ArrayList<>();
    AlarmListAdapter adapter;
    final int REQUEST_ALARM = 1;
    String date;
    Button b1;
    EditText et1;

    //종료버튼
    private final long FINISH_INTERVAL_TIME=2000;  //2초안에 뒤로가기 누르면 종료
    private long backPressedTime = 0;//백키를 누르는 시간 0~2

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("엄마의 잔소리");

        //b1 = (Button) findViewById(R.id.select);
        //et1 = (EditText)findViewById(R.id.search);

        setListView();
        //textFilter();
    }

    void setListView() {

        listView = (ListView) findViewById(R.id.list);
        adapter = new AlarmListAdapter(this, alarms);//!!!!!!!!!
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(MainActivity.this, AlarmState.class);
                intent.putExtra("show_Data", alarms.get(position));
                intent.putExtra("date", date);
                startActivity(intent);


            }
        });
    }

  /* void textFilter(){
        et1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                String search = s.toString();
                if(search.length()>0)
                    listView.setFilterText(search);
                else
                    listView.clearTextFilter();
            }
        });
    }
*/
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQUEST_ALARM && resultCode == RESULT_OK) {
            Alarms al = data.getParcelableExtra("All_data");
            date = data.getStringExtra("date");
            alarms.add(al);

            adapter.notifyDataSetChanged();
        }
        super.onActivityResult(requestCode, resultCode, data);

    }

    public void onClick(View v) {
        if (v.getId() == R.id.add) {
            Intent intent = new Intent(this, AlarmActivity.class);
            startActivityForResult(intent, REQUEST_ALARM);

        }
        /*else if (v.getId() == R.id.name_sort) {
            adapter.setNameAsc();
        }
        else if (v.getId() == R.id.category) {
            adapter.setCategoryAsc();
        }
        else if (v.getId() == R.id.select) {
            if (b1.getText().toString().equals("선택")) {
                b1.setText("삭제");
                adapter.showCheckBox();
            }
            else {
                b1.setText("선택");
                adapter.deleteData();
            }
        }*/
    }

    @Override//종료버튼
    public void onBackPressed() {
        long tempTime=System.currentTimeMillis();
        long intervalTime = tempTime - backPressedTime;

        if(0<= intervalTime && FINISH_INTERVAL_TIME>=intervalTime){
            super.onBackPressed();
        }
        else{
            backPressedTime=tempTime;
            Toast.makeText(getApplicationContext(),"'뒤로'버튼을한번더누르면종료됩니다.",Toast.LENGTH_SHORT).show();
        }
    }

}
