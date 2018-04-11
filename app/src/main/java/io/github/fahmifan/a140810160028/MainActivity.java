package io.github.fahmifan.a140810160028;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Keys keys;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onRupiah(View view) {
        Intent i = new Intent(this, Main2Activity.class);
        i.putExtra(keys.RUPIAH, keys.RUPIAH);
        startActivity(i);
    }

    public void onUsd(View view) {
        Intent i = new Intent(this, Main2Activity.class);
        i.putExtra(keys.USD, keys.USD);
        startActivity(i);
    }

    public void onYen(View view) {
        Intent i = new Intent(this, Main2Activity.class);
        i.putExtra(keys.YEN, keys.YEN);
        startActivity(i);
    }

    public void onEuro(View view) {
        Intent i = new Intent(this, Main2Activity.class);
        i.putExtra(keys.EURO, keys.EURO);
        startActivity(i);
    }
}
