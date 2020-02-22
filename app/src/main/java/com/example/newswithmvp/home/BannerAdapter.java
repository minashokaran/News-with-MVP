package com.example.newswithmvp.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newswithmvp.R;
import com.example.newswithmvp.data.Banner;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.BannerViewHolder> {

    private List<Banner> banners = new ArrayList<>();

    private BannerAdapter(List<Banner> banners) {
        this.banners = banners;
    }

    @NonNull
    @Override
    public BannerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BannerViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_banner, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BannerViewHolder holder, int position) {
        holder.bindBanner(banners.get(position));

    }

    @Override
    public int getItemCount() {
        return banners.size();
    }

    public class BannerViewHolder extends RecyclerView.ViewHolder {
        private ImageView bannerImageView;
        private TextView titleBanner;
        private TextView textBanner;

        public BannerViewHolder(@NonNull View itemView) {
            super(itemView);
            bannerImageView = itemView.findViewById(R.id.iv_banner_image);
            titleBanner = itemView.findViewById(R.id.text_banner_title);
            textBanner = itemView.findViewById(R.id.text_banner_main);
        }

        public void bindBanner(Banner banner) {
            Picasso.get().load(banner.getImage()).into(bannerImageView);
            titleBanner.setText(banner.getTitle());
            textBanner.setText(banner.getSource());

        }
    }

}
