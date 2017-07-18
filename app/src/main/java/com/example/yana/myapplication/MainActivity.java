package com.example.yana.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button mClearButton;
    private Button mSendButton;
    private EditText mInputEditText;
    private String mAnswer;

    private final static int REQUEST_SEND = 0;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SEND) {
            if(resultCode == RESULT_OK) {
                if (data != null) {
                    mAnswer = Main2Activity.wasAnswer(data);
                    mInputEditText.setText(mAnswer);
                }
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                mAnswer = Main2Activity.wasAnswerReject(data);
                mInputEditText.setText(mAnswer);
            }
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mInputEditText = (EditText)findViewById(R.id.input_edit_text);

        mClearButton = (Button) findViewById(R.id.clear_button);
        mClearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               mInputEditText.setText("");
            }
        });

        mSendButton = (Button)findViewById(R.id.send_button);
        mSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = mInputEditText.getText().toString();
                    Intent i = Main2Activity.newIntent(MainActivity.this, text);
                    startActivityForResult(i, REQUEST_SEND);

            }
        });

    }
}
