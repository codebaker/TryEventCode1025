package com.codebakery.joan.tryeventcode1025;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button button1,button2;
    private TextView textView;
    public static final int REQUEST_CODE = 2000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        // this를 넘겨준것은  여기에 View.OnClickListener.onClick(View v)가 구현되어 있다고 알려줌.
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        textView = (TextView) findViewById(R.id.text1);
    }

    //FragmentActivity에서 오버라이드
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(REQUEST_CODE == requestCode && resultCode == RESULT_OK && data != null) {
            textView.setText(data.getStringExtra("result"));
        }
    }

    @Override
    public void onClick(View v) {
        textView.setText(((Button)v).getText().toString());
        Intent intent = new Intent(this,ResultActivity.class);
        intent.putExtra("buttonText", ((Button)v).getText().toString());

        startActivityForResult(intent,REQUEST_CODE);
    }


}
