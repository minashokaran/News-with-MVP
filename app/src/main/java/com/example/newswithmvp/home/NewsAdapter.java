package com.example.newswithmvp.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newswithmvp.R;
import com.example.newswithmvp.data.News;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {
    private List<News> news = new ArrayList<>();

    public NewsAdapter(List<News> news) {
        this.news = news;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NewsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        holder.bindNews(news.get(position));
    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    private ImageView newsImage;
    private ImageView newsVideoIndicator;
    private TextView titleNews;
    private TextView dateNews;

    public class NewsViewHolder extends RecyclerView.ViewHolder {
        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            newsImage = itemView.findViewById(R.id.frame_image_news);
            newsVideoIndicator = itemView.findViewById(R.id.iv_video_container);
            titleNews = itemView.findViewById(R.id.tv_news_title);
            dateNews = itemView.findViewById(R.id.tv_news_date);
        }

        public void bindNews(News news) {
            Picasso.get().load(news.getImage()).into(newsImage);
            titleNews.setText(news.getTitle());
            dateNews.setText(news.getDate());
            newsVideoIndicator.setVisibility(news.isVideo() ? View.VISIBLE : View.GONE);

        }
    }
}