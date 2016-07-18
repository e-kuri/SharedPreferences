package com.example.admin.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = ((EditText) findViewById(R.id.editText));

        sp = getPreferences(MODE_PRIVATE);

        et.setText(sp.getString("text", "hello"));
    }

    @Override
    protected void onStop() {
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("text", et.getText().toString());
        editor.commit();
        super.onStop();
    }
}
