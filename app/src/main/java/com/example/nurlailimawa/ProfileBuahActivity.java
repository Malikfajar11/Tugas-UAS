package com.example.nurlailimawa;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nurlailimawa.model.Buah;

public class ProfileBuahActivity extends AppCompatActivity {

    Buah buah;
    TextView txJudul,txJenis,txAsal,txDeskripsi;
    ImageView ivFotoBuah;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_buah);
        Intent intent = getIntent();
        buah = (Buah) intent.getSerializableExtra(DaftarBuahActivity.BUAH_TERPILIH);
        inisialisasiView();
        tampilkanProfil(buah);
    }

    private void inisialisasiView() {
        txJudul = findViewById(R.id.txJudul);
        txJenis = findViewById(R.id.txJenis);
        txAsal = findViewById(R.id.txAsal);
        txDeskripsi = findViewById(R.id.txDeskripsi);
        ivFotoBuah = findViewById(R.id.gambarBuah);
    }


    private void tampilkanProfil(Buah buah) {
        Log.d("Profil","Menampilkan "+buah.getJenis());
        txJudul.setText(buah.getJenis());
        txJenis.setText(buah.getNama());
        txAsal.setText(buah.getAsal());
        txDeskripsi.setText(buah.getDeskripsi());
        ivFotoBuah.setImageDrawable(this.getDrawable(buah.getDrawableRes()));
    }




}
