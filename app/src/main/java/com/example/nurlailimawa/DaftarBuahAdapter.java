package com.example.nurlailimawa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

import com.example.nurlailimawa.model.Buah;

public class DaftarBuahAdapter extends ArrayAdapter<Buah> {

    Context context;

    public DaftarBuahAdapter(Context context, List<Buah> buahs) {
        super(context, R.layout.row_daftar_buah, buahs);
        this.context = context;
    }

    private static class ViewHolder  {
        TextView textJenis;
        TextView textAsal;
        ImageView gambar;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Buah buah = getItem(position);
        ViewHolder viewHolder;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_daftar_buah, parent, false);
            viewHolder.textJenis =  convertView.findViewById(R.id.row_text_jenis);
            viewHolder.textAsal = (TextView) convertView.findViewById(R.id.row_text_asal);
            viewHolder.gambar = convertView.findViewById(R.id.row_image_buah);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.textJenis.setText(buah.getNama());
        viewHolder.textAsal.setText(buah.getAsal());
        viewHolder.gambar.setImageDrawable(context.getDrawable(buah.getDrawableRes()));
        return convertView;
    }

}