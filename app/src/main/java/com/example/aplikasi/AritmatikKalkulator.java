package com.example.aplikasi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView;
import android.view.View;
import android.widget.Toast;

public class AritmatikKalkulator extends AppCompatActivity {

    private EditText editTextNumber1;
    private EditText editTextNumber2;
    private Spinner spinnerOperation;
    private Button buttonCalculate;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aritmatik_kalkulator);

        editTextNumber1 = findViewById(R.id.angkaPertama);
        editTextNumber2 = findViewById(R.id.angkaKedua);
        spinnerOperation = findViewById(R.id.spinner);
        buttonCalculate = findViewById(R.id.btnCalculate);
        textViewResult = findViewById(R.id.textHasil);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });
    }

    private void calculate() {
        String num1Str = editTextNumber1.getText().toString();
        String num2Str = editTextNumber2.getText().toString();
        String operation = spinnerOperation.getSelectedItem().toString();

        if (!num1Str.isEmpty() && !num2Str.isEmpty()) {
            double num1 = Double.parseDouble(num1Str);
            double num2 = Double.parseDouble(num2Str);
            double result = 0;

            switch (operation) {
                case "Penjumlahan":
                    result = num1 + num2;
                    break;
                case "Pengurangan":
                    result = num1 - num2;
                    break;
                case "Perkalian":
                    result = num1 * num2;
                    break;
                case "Pembagian":
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        Toast.makeText(AritmatikKalkulator.this, "Pembagi tidak boleh 0", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    break;
            }

            // Jika operasi adalah pembagian, hasil akan ditampilkan sebagai double, selain itu, akan diubah menjadi int.
            if (operation.equals("Pembagian")) {
                textViewResult.setText("Hasil : " + result);
            } else {
                textViewResult.setText("Hasil : " + (int) result);
            }
        } else {
            Toast.makeText(AritmatikKalkulator.this, "Kolom tidak boleh kosong", Toast.LENGTH_SHORT).show();
        }
    }

}