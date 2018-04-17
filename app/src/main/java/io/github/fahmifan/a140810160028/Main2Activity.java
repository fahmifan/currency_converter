package io.github.fahmifan.a140810160028;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.Locale;

public class Main2Activity extends AppCompatActivity {
    private Conversion conversion;
    private TextView rp, usd, yen, euro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        this.onBtnBack();

        final TextView currency = findViewById(R.id.currency);
        euro = findViewById(R.id.euro);
        rp = findViewById(R.id.rp);
        yen = findViewById(R.id.yen);
        usd = findViewById(R.id.usd);
        Button process = findViewById(R.id.process);
        final Bundle extras = getIntent().getExtras();

        if (extras != null) {
            final String currencyKind = extras.getString(Keys.CURRENCY);

            changeInputLabel(currencyKind, currency);
            process.setOnClickListener(view -> {
                    double inputCurrency = 0;
                    String inputtedText = ((EditText) findViewById(R.id.input_val)).getText().toString();

                    if(inputtedText.isEmpty()) {
                        Toast.makeText(
                                Main2Activity.this,
                                "Input tidak boleh kosong",
                                Toast.LENGTH_SHORT).show();
                    } else {
                        inputCurrency = Double.parseDouble(inputtedText);
                        convertCurrency(currencyKind, inputCurrency);
                        showConvertedCurrency();
                    }
            });
        }
    }

    // Change input label based on currency extras
    private void changeInputLabel(String kind, TextView currency) {
        String text = "Masukkan nilai mata uang";
        switch (kind) {
            case Keys.RUPIAH: currency.setText(String.format("%s(Rp)", text)); break;
            case Keys.YEN: currency.setText(String.format("%s(YEN)", text)); break;
            case Keys.EURO: currency.setText(String.format("%s(Euro)", text)); break;
            case Keys.USD: currency.setText(String.format("%s(USD)", text)); break;
        }
    }

    // convert the currency based on its kind
    private void convertCurrency(String kind, double inputCurrency) {
        switch (kind) {
            case Keys.RUPIAH: conversion = new Conversion(Keys.RUPIAH, inputCurrency); break;
            case Keys.USD: conversion = new Conversion(Keys.USD, inputCurrency); break;
            case Keys.YEN: conversion = new Conversion(Keys.YEN, inputCurrency); break;
            case Keys.EURO: conversion = new Conversion(Keys.EURO, inputCurrency); break;
            default:
                Toast.makeText(this, "NO EXTRAS", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void showConvertedCurrency() {
        rp.setText(String.format("Rupiah = %s", convertToLocaleCurrency(conversion.getRupiah())));
        usd.setText(String.format("USD = %s", convertToLocaleCurrency(conversion.getUsd())));
        euro.setText(String.format("Euro = %s", convertToLocaleCurrency(conversion.getEuro())));
        yen.setText(String.format("Yen = %s", convertToLocaleCurrency(conversion.getYen())));
    }

    private String convertToLocaleCurrency(double num) {
        return NumberFormat.getNumberInstance(Locale.GERMANY).format(num);
    }


    public void onBtnBack() {
        findViewById(R.id.btn_back).setOnClickListener(view -> finish());
    }
}
