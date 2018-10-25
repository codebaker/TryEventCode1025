package com.codebakery.joan.tryeventcode1025;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText;
    private Button resultButton;
    String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        str = getIntent().getStringExtra("buttonText");
        editText = (EditText) findViewById(R.id.editText);
        editText.setText(str);
        resultButton = (Button) findViewById(R.id.result_button);
        resultButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        str = editText.getText().toString();
        Intent intent = new Intent();
        intent.putExtra("result", str);

        setResult(RESULT_OK,intent);
        //setResult(RESULT_CANCELED,intent);
        //setResult(RESULT_FIRST_USER,intent);

        finish();
    }
}
