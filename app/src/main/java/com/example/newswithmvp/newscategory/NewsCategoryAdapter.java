package com.example.newswithmvp.newscategory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newswithmvp.R;

public class NewsCategoryAdapter extends RecyclerView.Adapter<NewsCategoryAdapter.NewsCategoryViewHolder> {
    private Context context;

    NewsCategory[] newsCategories = new NewsCategory[6];

    public NewsCategoryAdapter(Context context) {
        this.context = context;
        NewsCategory topStories = new NewsCategory();
        newsCategories[0] = topStories;
        topStories.setId(0);
        topStories.setTitle(context.getString(R.string.category_topStories));
        topStories.setIcon(R.drawable.ic_topstories_black_24dp);


        NewsCategory world = new NewsCategory();
        newsCategories[1] = world;
        world.setId(1);
        world.setTitle(context.getString(R.string.category_World));
        world.setIcon(R.drawable.ic_world_black_24dp);


        NewsCategory business = new NewsCategory();
        newsCategories[2] = business;
        business.setId(2);
        business.setTitle(context.getString(R.string.category_business));
        business.setIcon(R.drawable.ic_business_black_24dp);

        NewsCategory iran = new NewsCategory();
        newsCategories[3] = iran;
        iran.setId(3);
        iran.setTitle(context.getString(R.string.category_iran));
        iran.setIcon(R.drawable.ic_iran_black_24dp);

        NewsCategory health = new NewsCategory();
        newsCategories[4] = health;
        health.setId(4);
        health.setTitle(context.getString(R.string.category_health));
        health.setIcon(R.drawable.ic_health_black_24dp);


        NewsCategory technology = new NewsCategory();
        newsCategories[5] = technology;
        technology.setId(5);
        technology.setTitle(context.getString(R.string.category_technology));
        technology.setIcon(R.drawable.ic_technology_black_24dp);


    }

    @NonNull
    @Override
    public NewsCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NewsCategoryViewHolder(LayoutInflater.from(context).inflate(R.layout.item_category, parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull NewsCategoryViewHolder holder, int position) {
        holder.bindNewsCategory(newsCategories[position]);
    }

    @Override
    public int getItemCount() {
        return newsCategories.length;
    }

    public class NewsCategoryViewHolder extends RecyclerView.ViewHolder {
        private ImageView iconImageView;
        private TextView titleTextView;

        public NewsCategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            iconImageView = itemView.findViewById(R.id.iv_cat_icon);
            titleTextView = itemView.findViewById(R.id.tv_cat_title);
        }

        public void bindNewsCategory(NewsCategory newsCategory) {
            iconImageView.setImageResource(newsCategory.getIcon());
            titleTextView.setText(newsCategory.getTitle());
        }
    }
}
