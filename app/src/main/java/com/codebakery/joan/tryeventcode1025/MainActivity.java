package com.codebakery.joan.tryeventcode1025;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,View.OnLongClickListener{

    private Button button1,button2;
    private TextView textView;
    public static final int REQUEST_CODE = 2000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
        * activity_main.xml을 화면에 띄움.
        * 지금부터 사용자는 화면에 보이는 버튼을 누를수 있음.
        * 즉, 버튼의 이벤트 핸들러(=리스너)를 이 메서드(onCreate)에 등록하고 이벤트를 기다려야함.
        * */
        setContentView(R.layout.activity_main);

        /*
        * activity_main에 있는 버튼과 텍스트 뷰를 가져옴
        * */
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        textView = (TextView) findViewById(R.id.text1);

        /*
        * 버튼을 짧게 클릭 했을때,
        * this를 파라미터로 넘긴것은 여기-MainActivity Class-에 View.OnClickListener.onClick(View v)가 구현되어 있기때문에.
        * 즉 this는 MainActivity 클래스 이지만,
         * View.OnClickListener 클래스 이기도 함.
        * setOnClickListener(View.OnClickListener l)
        * */
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

        /*
        * 버튼을 길게 클릭했을때,
        * this를 넘겨준것은  여기에 View.OnLongClickListener.setOnLongClickListener(View v)가 구현되어 있기때문에.
        * 즉 this는 MainActivity 클래스 이지만,
         *View.OnLongClickListener 클래스 이기도 함.
        * setOnLongClickListener(View.OnLongClickListener l)
        * */
        button1.setOnLongClickListener(this);
        button2.setOnLongClickListener(this);
    }



    /*
    * 부모의 부모 클래스인 FragmentActivity의 메서드 오버라이드
    * MainActivity->AppCompatActivity->FragmentActivity->Activity 를 상속
    * */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(REQUEST_CODE == requestCode && resultCode == RESULT_OK && data != null) {
            textView.setText(data.getStringExtra("result"));
        }
    }



    /*
    * implements 한 View.OnClickListener의 메서드 오버라이드.
    * activity_main에 보이는 버튼을 짧게 클릭하면 호출되는 메서드.
    * */
    @Override
    public void onClick(View view) {
        //activity_main에 있는 텍스트 뷰에 버튼이름 표시
        textView.setText(((Button)view).getText().toString());
    }



    /*
     * implements 한 View.OnLongClickListener의 메서드 오버라이드
     * activity_main에 보이는 버튼을 길게 클릭하면 호출되는 메서드.
     * */
    @Override
    public boolean onLongClick(View view) {

        // Intent 객체에 버튼의 텍스트를 넣어서 다른 화면 ResultActivity로 보냄.
        // 메세지(데이터)를 들고있는 집배원?
        Intent intent = new Intent(this,ResultActivity.class);
        intent.putExtra("buttonText", ((Button)view).getText().toString());

        //FragmentActivity에 구현되어 있는 메서드를 사용
        // intent를 담아서 적혀있는 주소(ResultActivity.class)로 보냄.
        startActivityForResult(intent,REQUEST_CODE);
        return true;
    }
}
