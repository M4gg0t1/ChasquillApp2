package com.JSH.ChasquillApp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminModeActivity extends AppCompatActivity {

    private EditText editTextName, editTextRepairs, editTextBaseValue;
    private DataBase database; // Instancia de la base de datos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_mode);

        editTextName = findViewById(R.id.editTextName);
        editTextRepairs = findViewById(R.id.editTextRepairs);
        editTextBaseValue = findViewById(R.id.editTextBaseValue);

        Button buttonRegisterMaster = findViewById(R.id.buttonRegisterMaster);

        database = new DataBase(this); // Inicializa la base de datos

        buttonRegisterMaster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerMaster();
            }
        });
    }

    private void registerMaster() {
        String name = editTextName.getText().toString().trim();
        String repairs = editTextRepairs.getText().toString().trim();
        String baseValue = editTextBaseValue.getText().toString().trim();

        // Guardar los datos en la base de datos
        if (database.insertTarea(name + " - " + repairs + " - $" + baseValue)) {
            Toast.makeText(this, "Maestro registrado exitosamente", Toast.LENGTH_SHORT).show();
            // Limpiar campos después de registrar
            editTextName.setText("");
            editTextRepairs.setText("");
            editTextBaseValue.setText("");
        } else {
            Toast.makeText(this, "Error al registrar maestro", Toast.LENGTH_SHORT).show();
        }
    }
}