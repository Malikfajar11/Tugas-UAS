package com.example.nurlailimawa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton btnDurian,btnMangga,btnAnggur;
    public static final String JENIS_GALERI_KEY = "JENIS_GALERI";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inisialisasiView();

    }

    private void inisialisasiView() {
        btnDurian= findViewById(R.id.btn_buka_durian);
        btnMangga = findViewById(R.id.btn_buka_mangga);
        btnAnggur = findViewById(R.id.btn_buka_anggur);
        btnDurian.setOnClickListener(view -> bukaGaleri(getString(R.string.durian)));
        btnMangga.setOnClickListener(view -> bukaGaleri(getString(R.string.mangga)));
        btnAnggur.setOnClickListener(view -> bukaGaleri(getString(R.string.anggur)));
    }

    private void bukaGaleri(String jenisBuah) {
        Log.d("MAIN","Buka activity durian");
        Intent intent = new Intent(this, DaftarBuahActivity.class);
        intent.putExtra(JENIS_GALERI_KEY, jenisBuah);
        startActivity(intent);
    }

    public void bukaBiodata(View view) {
        Intent intent = new Intent(MainActivity.this, ProfilActivity.class);
        startActivity(intent);
    }

}