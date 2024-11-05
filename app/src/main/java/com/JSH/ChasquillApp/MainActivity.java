package com.JSH.ChasquillApp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonAdminMode=findViewById(R.id.buttonAdminMode);

        buttonAdminMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AdminModeActivity.class));
            }
        });

        Button buttonShowMastersList=findViewById(R.id.buttonShowMastersList);
        buttonShowMastersList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MastersListActivity.class));
            }
        });
    }
}