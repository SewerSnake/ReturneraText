package com.example.returnerainfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TestActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        textView = (TextView) findViewById(R.id.textView);
    }

    public void onEditClicked(View view) {
        Intent intent = new Intent(this, EditActivity.class);
        intent.putExtra("text", textView.getText().toString());
        startActivity(intent);
    }
}
