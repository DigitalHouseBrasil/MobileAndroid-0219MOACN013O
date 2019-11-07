package com.example.tmdbaudio.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tmdbaudio.R;
import com.example.tmdbaudio.model.Album;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerViewAdapater extends RecyclerView.Adapter<RecyclerViewAdapater.ViewHolder> {

    private List<Album> albums;

    public RecyclerViewAdapater(List<Album> albums) {
        this.albums = albums;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Album album = this.albums.get(position);
        holder.bind(album);
    }

    @Override
    public int getItemCount() {
        return albums.size();
    }

    public void setUpdate(List<Album> albums) {
        if (this.albums.isEmpty()){
            this.albums = albums;
        }else {
            this.albums.addAll(albums);
        }
        notifyDataSetChanged();
    }

    public void clear(){
        this.albums.clear();
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView titulo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.imgFilme);
            titulo = itemView.findViewById(R.id.txtTitulo);
        }

        public void bind(Album album) {
            titulo.setText(album.getStrAlbum());

            Picasso.get().load(album.getStrAlbumThumb()).into(img);

        }
    }
}
