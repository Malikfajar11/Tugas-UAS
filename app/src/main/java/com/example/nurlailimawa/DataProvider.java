package com.example.nurlailimawa;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import com.example.nurlailimawa.model.Anggur;
import com.example.nurlailimawa.model.Buah;
import com.example.nurlailimawa.model.Durian;
import com.example.nurlailimawa.model.Mangga;

public class DataProvider {
    private static List<Buah> buahs = new ArrayList<>();

    private static List<Durian> initDataDurian(Context ctx) {
        List<Durian> durians = new ArrayList<>();
        durians.add(new Durian(ctx.getString(R.string.musangking_nama), ctx.getString(R.string.musangking_asal),
                ctx.getString(R.string.musangking_deskripsi), R.drawable.musangking));
        durians.add(new Durian(ctx.getString(R.string.bawor_nama), ctx.getString(R.string.bawor_asal),
                ctx.getString(R.string.bawor_deskripsi), R.drawable.durianbawor));
        durians.add(new Durian(ctx.getString(R.string.merah_nama), ctx.getString(R.string.merah_asal),
                ctx.getString(R.string.merah_deskripsi), R.drawable.durianmerah));
        return durians;
    }

    private static List<Mangga> initDataMangga(Context ctx) {
        List<Mangga> manggas = new ArrayList<>();
        manggas.add(new Mangga(ctx.getString(R.string.berazil_nama), ctx.getString(R.string.berazil_asal),
                ctx.getString(R.string.berazil_deskripsi), R.drawable.manggaberazil));
        manggas.add(new Mangga(ctx.getString(R.string.madu_nama), ctx.getString(R.string.madu_asal),
                ctx.getString(R.string.madu_deskripsi), R.drawable.manggamadu));
        manggas.add(new Mangga(ctx.getString(R.string.manalagi_nama), ctx.getString(R.string.manalagi_asal),
                ctx.getString(R.string.manalagi_deskripi), R.drawable.manggamanalagi));
        return manggas;
    }

    private static List<Anggur> initDataAnggur(Context ctx) {
        List<Anggur> anggurs = new ArrayList<>();
        anggurs.add(new Anggur(ctx.getString(R.string.hijau_nama), ctx.getString(R.string.hijau_asal),
                ctx.getString(R.string.hijau_deskripsi), R.drawable.hijau));
        anggurs.add(new Anggur(ctx.getString(R.string.anggur_nama), ctx.getString(R.string.anggur_asal),
                ctx.getString(R.string.anggur_deskripsi), R.drawable.anggurmerah));
        anggurs.add(new Anggur(ctx.getString(R.string.hitam_nama), ctx.getString(R.string.hitam_asal),
                ctx.getString(R.string.itam_deskripsi), R.drawable.anggurhitam));
        return anggurs;
    }

    private static void initAllBuahs(Context ctx) {
        buahs.addAll(initDataAnggur(ctx));
        buahs.addAll(initDataDurian(ctx));
        buahs.addAll(initDataMangga(ctx));
    }

    public static List<Buah> getAllBuah(Context ctx) {
        if (buahs.size() == 0) {
            initAllBuahs(ctx);
        }
        return  buahs;
    }

    public static List<Buah> getBuahsByTipe(Context ctx, String jenis) {
        List<Buah> buahsByType = new ArrayList<>();
        if (buahs.size() == 0) {
            initAllBuahs(ctx);
        }
        for (Buah h : buahs) {
            if (h.getJenis().equals(jenis)) {
                buahsByType.add(h);
            }
        }
        return buahsByType;
    }
}