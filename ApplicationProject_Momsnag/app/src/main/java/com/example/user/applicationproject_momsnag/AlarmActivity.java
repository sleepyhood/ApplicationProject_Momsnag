package com.example.user.applicationproject_momsnag;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AlarmActivity extends AppCompatActivity {

    /*Chronometer chrono;*/
    Button saveButton, btnComplete;
    RadioButton rCal, rTime; // 캘린더, 시간 라디오 버튼
    TimePicker tPicker;
    // CalendarView calView;
    TextView tvYear, tvMonth, tvDay, tvHour, tvMinute; //출력
    int selectYear, selectMonth, selectDay;
    DatePicker dPicker;

    //객체 선언
    EditText titleText;
    EditText contentText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        setTitle("잔소리 설정");
        program();
        /*
        Intent intent= new Intent (this.getIntent());//intent 가져옴

        int a= intent.getIntExtra("intData:",0);
        String b= intent.getStringExtra("stringData");

        Toast.makeText(getApplicationContext(), "전달 받음 INT: "+a +"전달받은 STRING: "+b, Toast.LENGTH_SHORT).show();
*/


/*
        Button button = (Button) findViewById(R.id.saveButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //EditText로 입력된 값을 클래스로?
                String title = AlarmTitleText.getText().toString();
                String content = AlarmContentText.getText().toString();
                //String[] Alarm=new String [AlarmTitle.length()];

                Intent intent = new Intent(getApplicationContext(), AlarmitemView.class);
                //Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("title", title);
                intent.putExtra("content", content);

                setResult(RESULT_OK, intent);

                finish();
            }
        });*/


//시간 설정
        /*chrono = (Chronometer)findViewById(R.id.chrono);
        btnStart = (Button) findViewById(R.id.btnStart);*/
        btnComplete = (Button) findViewById(R.id.btnComplete);
        rCal = (RadioButton)findViewById(R.id.rCal);
        rTime = (RadioButton)findViewById(R.id.rTime);
        tPicker = (TimePicker)findViewById(R.id.tPicker);
        // calView = (CalendarView)findViewById(R.id.calView);
        dPicker = (DatePicker)findViewById(R.id.dPicker);

        tPicker.setVisibility(View.INVISIBLE);
        //  calView.setVisibility(View.INVISIBLE);
        dPicker.setVisibility(View.INVISIBLE);


        tvYear = (TextView) findViewById(R.id.tvYear);
        tvMonth = (TextView) findViewById(R.id.tvMonth);
        tvDay = (TextView) findViewById(R.id.tvDay);
        tvHour = (TextView) findViewById(R.id.tvHour);
        tvMinute = (TextView) findViewById(R.id.tvMinute);

        rCal.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                dPicker.setVisibility(View.VISIBLE);
                tPicker.setVisibility(View.INVISIBLE);
            }
        });
        rTime.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                dPicker.setVisibility(View.INVISIBLE);
                tPicker.setVisibility(View.VISIBLE);
            }
        });

        /*btnStart.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                chrono.setBase(SystemClock.elapsedRealtime());
                chrono.start();
                chrono.setTextColor(Color.RED);
                rCal.setVisibility(View.VISIBLE);
                rTime.setVisibility(View.VISIBLE);
            }
        });*/

        btnComplete.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                /*chrono.stop();
                chrono.setTextColor(Color.BLUE);*/

                tvYear.setText(Integer.toString(dPicker.getYear()));
                tvMonth.setText(Integer.toString(1 + dPicker.getMonth()));
                tvDay.setText(Integer.toString(dPicker.getDayOfMonth()));

                tvHour.setText(Integer.toString(tPicker.getCurrentHour()));
                tvMinute.setText(Integer.toString(tPicker.getCurrentMinute()));

                rCal.setVisibility(View.INVISIBLE);
                rTime.setVisibility(View.INVISIBLE);
                tPicker.setVisibility(View.INVISIBLE);
                dPicker.setVisibility(View.INVISIBLE);

/*                java.util.Calendar curDate = java.util.Calendar.getInstance();
                curDate.setTimeInMillis(calView.getDate());
                tvYear.setText(Integer.toString(selectYear));
                tvMonth.setText(Integer.toString(selectMonth));
                tvDay.setText(Integer.toString(selectDay));
                tvHour.setText(Integer.toString(tPicker.getCurrentHour()));
                tvMinute.setText(Integer.toString(tPicker.getCurrentMinute()));*/
            }
        });


    }

    void program() {
        titleText = (EditText) findViewById(R.id.titleTextEdit);//정보 가져옴
        contentText = (EditText) findViewById(R.id.contentTextEdit);
    }

    public void onClick(View v) {
        if (v.getId() == R.id.saveButton) {
            Alarms al = new Alarms(titleText.getText().toString(), contentText.getText().toString());//클래스 호출 후 대입
            Intent intent = getIntent();
            intent.putExtra("All_data", al);
            String date = getTime();
            intent.putExtra("date", date);
            setResult(RESULT_OK,intent);
            Toast.makeText(getApplicationContext(),"잔소리 설정 완료!"  ,Toast.LENGTH_SHORT).show();

            finish();
        }
    }


    String getTime(){
        long now = System.currentTimeMillis();
        Date date = new Date(now);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String format = sdf.format(date);
        return format;
    }

   /* public void onButtonClicked(View v){
        Intent intent=new Intent(this, AlarmActivity.class);
        startActivity(intent);
    }*/
}
