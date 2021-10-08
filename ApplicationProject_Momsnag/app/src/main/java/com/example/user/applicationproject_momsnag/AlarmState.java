package com.example.user.applicationproject_momsnag;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class AlarmState extends AppCompatActivity {
    TextView t1, t2;
    //ImageView iv1;
    Alarms al;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main33);
        program();
    }

    void program(){
        t1 = (TextView)findViewById(R.id.titleTextView);
        t2 = (TextView)findViewById(R.id.contentTextView);

        Intent intent = getIntent();
        al = intent.getParcelableExtra("show_Data");
        String date = intent.getStringExtra("date");

        t1.setText(al.getTitle());
        t2.setText(al.getContent());
       /* t3.setText(al.getMenu2());
        t4.setText(rs.getMenu3());
        t5.setText(rs.getPhoneNum());
        t6.setText(rs.getHomepage());
        t7.setText(date);

        iv1.setImageResource(rs.getCategory());*/
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.backButton:
                finish();
                break;
          /*  case R.id.imageView2:
                Intent call = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:/" + rs.getPhoneNum()));
                startActivity(call);
                break;
            case R.id.imageView3:
                Intent view = new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+rs.getHomepage()));
                startActivity(view);
                break;*/
        }

    }
}
