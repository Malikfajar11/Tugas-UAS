package com.example.nurlailimawa;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import com.example.nurlailimawa.model.Buah;

public class DaftarBuahActivity extends AppCompatActivity {
    public final static String BUAH_TERPILIH ="buah_obj_key";
    List<Buah> buahs;
    ListView listView;
    String jenisBuah;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_buah);
        Intent intent = getIntent();
        jenisBuah = intent.getStringExtra(MainActivity.JENIS_GALERI_KEY);
        TextView txJudul = findViewById(R.id.text_title_daftar);
        txJudul.setText(getString(R.string.daftar)+" "+jenisBuah.toUpperCase());
        buahs = DataProvider.getBuahsByTipe(this,jenisBuah);
        setupListView();
    }

    private void setupListView() {
        listView = findViewById(R.id.listview_daftar_buah);
        DaftarBuahAdapter adapter = new DaftarBuahAdapter(this,buahs);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(onListClik);
    }

    private AdapterView.OnItemClickListener onListClik = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
            Buah terpilih = buahs.get(position);
            bukaProfileBuah(terpilih);
        }
    };

    private void bukaProfileBuah(Buah buahTerpilih) {
        Log.d("MAIN","Buka activity galeri");
        Intent intent = new Intent(this, ProfileBuahActivity.class);
        intent.putExtra(BUAH_TERPILIH, buahTerpilih);
        startActivity(intent);
    }


}