package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    private EditText editPeso, editAltura;
    private Button btnCalcular;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPeso = findViewById(R.id.editPeso);
        editAltura = findViewById(R.id.editAltura);
        btnCalcular = findViewById(R.id.btnCalcular);
        textResultado = findViewById(R.id.textResultado);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularIMC();
            }
        });
    }

    private void calcularIMC() {
        String pesoStr = editPeso.getText().toString();
        String alturaStr = editAltura.getText().toString();

        if (pesoStr.isEmpty() || alturaStr.isEmpty()) {
            Toast.makeText(this, "Por favor, preencha os campos!", Toast.LENGTH_SHORT).show();
            return;
        }

        double peso = Double.parseDouble(pesoStr);
        double altura = Double.parseDouble(alturaStr);

        double imc = peso / (altura * altura);
        String classificacao;

        if (imc < 18.5) {
            classificacao = "Abaixo do peso";
        } else if (imc < 24.9) {
            classificacao = "Peso normal";
        } else if (imc < 29.9) {
            classificacao = "Sobrepeso";
        } else if (imc < 34.9) {
            classificacao = "Obesidade grau I";
        } else if (imc < 39.9) {
            classificacao = "Obesidade grau II";
        } else {
            classificacao = "Obesidade grau III";
        }

        String resultado = String.format("IMC: %.2f\nClassificação: %s", imc, classificacao);
        textResultado.setText(resultado);
    }
}
