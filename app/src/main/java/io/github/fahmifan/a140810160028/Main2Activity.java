package io.github.fahmifan.a140810160028;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    Keys keys;
    private Conversi conversi;
    private TextView rp, usd, yen, euro;
    private Button process;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final TextView currency = (TextView) findViewById(R.id.currency);
        euro = (TextView) findViewById(R.id.euro);
        rp = findViewById(R.id.rp);
        yen = findViewById(R.id.yen);
        usd = findViewById(R.id.usd);
        process = (Button) findViewById(R.id.process);

        final Bundle extras = getIntent().getExtras();
//        final String inputtedText = ((EditText) findViewById(R.id.input_val)).getText().toString();
//        final double inputCurrency = {0.0};

        if (extras != null) {
            changeInputLabel(extras, currency);
            process.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    double inputCurrency = 0;
                    String inputtedText = ((EditText) findViewById(R.id.input_val)).getText().toString();

                    if(inputtedText.isEmpty()) {
                        Toast.makeText(
                                Main2Activity.this,
                                "Input gaboleh kosong : " + inputtedText,
                                Toast.LENGTH_SHORT).show();
                    } else {
                        inputCurrency = Double.parseDouble(inputtedText);
                        convertCurrency(extras, inputCurrency);
                        showConvertedCurrency();
                    }
                }
            });
        }
    }

    // Change input label based on passed extras
    private void changeInputLabel(Bundle extras, TextView currency) {
        if (extras.get(keys.RUPIAH) != null) {
            currency.setText("Masukkan nilai mata uang(Rp)");
        } else if (extras.get(keys.YEN) != null) {
            currency.setText("Masukkan nilai mata uang(Yen)");
        } else if (extras.get(keys.USD) != null) {
            currency.setText("Masukkan nilai mata uang(USD)");
        } else if (extras.get(keys.EURO) != null) {
            currency.setText("Masukkan nilai mata uang(Euro)");
        }
    }

    // convert the currency based on passed extras
    private void convertCurrency(Bundle extras, double inputCurrency) {
        if (extras.get(keys.RUPIAH) != null) {
            this.conversi = new Conversi(keys.RUPIAH, inputCurrency);
        } else if (extras.get(keys.USD) != null) {
            this.conversi = new Conversi(keys.USD, inputCurrency);
        } else if (extras.get(keys.YEN) != null) {
            this.conversi = new Conversi(keys.YEN, inputCurrency);
        } else if (extras.get(keys.EURO) != null) {
            this.conversi = new Conversi(keys.EURO, inputCurrency);
        } else {
            Toast.makeText(Main2Activity.this, "NO EXTRAS", Toast.LENGTH_SHORT).show();
        }
    }

    private void showConvertedCurrency() {
        this.rp.setText("Rupiah = " + this.conversi.getRupiah());
        this.usd.setText("USD = " + this.conversi.getUsd());
        this.euro.setText("Euro = " + this.conversi.getEuro());
        this.yen.setText("Yen = " + this.conversi.getYen());
    }

    public void onBtnBack(View view) {
        finish();
    }
}
