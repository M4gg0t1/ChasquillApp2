package com.JSH.ChasquillApp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MastersListActivity extends AppCompatActivity {

    private ListView listViewMasters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masters_list);

        listViewMasters=findViewById(R.id.listViewMasters);

        DataBase database=new DataBase(this);

        ArrayList<String> mastersList=database.getAllTareas();

        MasterAdapter adapter=new MasterAdapter(this, mastersList);
        listViewMasters.setAdapter(adapter);
    }
}