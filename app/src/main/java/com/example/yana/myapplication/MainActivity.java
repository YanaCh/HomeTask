package com.example.yana.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mClearButton;
    private Button mSendButton;
    private EditText mInputEditText;
    private String mAnswer;

    private final static int REQUEST_SEND = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mInputEditText = (EditText) findViewById(R.id.input_edit_text);

        mClearButton = (Button) findViewById(R.id.clear_button);
        mClearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mInputEditText.setText("");
            }
        });

        mSendButton = (Button) findViewById(R.id.send_button);
        mSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if(!mInputEditText.getText().toString().equals("")) {
                        String text = mInputEditText.getText().toString();
                        Intent i = Main2Activity.newIntent(MainActivity.this, text);
                        startActivityForResult(i, REQUEST_SEND);
                    }

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQUEST_SEND && data != null) {
            if(resultCode == Activity.RESULT_OK){
                Toast.makeText(this, R.string.info_confirm_toast, Toast.LENGTH_SHORT)
                        .show();
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                Toast.makeText(this, R.string.info_reject_toast, Toast.LENGTH_SHORT)
                        .show();
            }
        }
        mAnswer = Main2Activity.wasAnswer(data);
        mInputEditText.setText(mAnswer);
         }
}
