package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private int variable = 0;

    private ActivityMainBinding binding;

    public MainActivity() {
        // super(R.layout.activity_main);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_second);

        // View view = getLayoutInflater().inflate(R.layout.activity_second, null);
        // setContentView(view);

        // TextView elementOne = findViewById(R.id.elementOne);
        // String text = elementOne.getText().toString();

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String text = binding.elementOne.toString();
        Log.d("MY_APP_DEBUG_TAG", "Element one text: " + text);

        // Context applicationContext = getApplicationContext();
        // Context activityContext = this;
        // Activity = Context

        // String appName = activityContext.getResources().getString()


        /*binding.elementOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });*/

        String textFromResources = getString(R.string.element_text);

        binding.elementOne.setOnClickListener(view -> {
            variable += 1;
            String textFormatted = String.format(textFromResources, variable);
            binding.elementOne.setText(textFormatted);
        });

        // binding.elementOne.setText(R.string.element_text);

        binding.elementTwo.setOnClickListener(v -> {
            // Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
            // startActivity(intent);
            Intent intent = new Intent(this, SecondActivity.class);
            startActivity(intent);
        });
    }
}
