package com.example.returnerainfo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TestActivity extends AppCompatActivity {

    private TextView textView;

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        textView = (TextView) findViewById(R.id.textView);

        sharedPreferences = getSharedPreferences("TestActivity", 0);

        textView.setText(sharedPreferences.getString("textView", "Default Value on first run"));
    }

    public void onEditClicked(View view) {
        Intent intent = new Intent(this, EditActivity.class);
        intent.putExtra("text", textView.getText().toString());
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            textView.setText(data.getStringExtra("answer"));
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("textView", data.getStringExtra("answer"));
            editor.apply(); //or commit() if return value is important. Saves data to a small file
            //in your phone. It is exclusive for that application.
        }
    }
}
