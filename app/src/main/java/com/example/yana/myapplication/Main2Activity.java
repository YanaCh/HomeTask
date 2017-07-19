package com.example.yana.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {
    public final static String EXTRA_SEND =
            "com.example.yana.myapplication.send";
    public static final String EXTRA_ANSWER = "com.example.yana.myapplication.answer";
    public static  String EXTRA_ANSWER_REJECT = "com.example.yana.myapplication.answer_reject";

    private String mTextSend;
    private Button mConfirmButton;
    private Button mRejectButton;
    private EditText mEditText;

    public static Intent newIntent (Context context, String isSend){
        Intent i = new Intent(context,Main2Activity.class);
        i.putExtra(EXTRA_SEND, isSend);
            return i;
    }

    private void setAnswer(String answer) {
        Intent data = new Intent(Main2Activity.this,MainActivity.class);
        startActivity(data);
        data.putExtra(EXTRA_ANSWER, answer);
        setResult(RESULT_OK, data);
    }
    public static String wasAnswer(Intent result){
        return result.getStringExtra(EXTRA_ANSWER);
    }

    private void setAnswerReject(String answer) {
        Intent data = new Intent(Main2Activity.this,MainActivity.class);
        data.putExtra(EXTRA_ANSWER_REJECT, answer);
        setResult(RESULT_CANCELED, data);
        startActivity(data);
    }
    public static String wasAnswerReject(Intent result){
        return result.getStringExtra(EXTRA_ANSWER_REJECT);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mTextSend = getIntent().getStringExtra(EXTRA_SEND);

        mConfirmButton = (Button)findViewById(R.id.confirm_button);
        mRejectButton = (Button)findViewById(R.id.reject_button);
        mEditText = (EditText)findViewById(R.id.edit_text);

        mEditText.setText(mTextSend);

        mConfirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setAnswer("");
            }
        });

        mRejectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setAnswerReject(mTextSend);
            }
        });


    }

}
