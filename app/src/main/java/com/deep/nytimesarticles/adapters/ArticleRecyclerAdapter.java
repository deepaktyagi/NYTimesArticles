package com.deep.nytimesarticles.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.customtabs.CustomTabsIntent;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.deep.nytimesarticles.Models.Result;
import com.deep.nytimesarticles.R;

import java.util.List;

public class ArticleRecyclerAdapter extends RecyclerView.Adapter<ArticleRecyclerAdapter.ArticleViewHolder > {

    Context mContext;
    List<Result> articlesList;

    public ArticleRecyclerAdapter(Context mContext, List<Result> articlesList) {
        this.mContext = mContext;
        this.articlesList = articlesList;
    }

    @Override
    public ArticleRecyclerAdapter.ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.articles_items_rcv, viewGroup, false);
        return new ArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ArticleRecyclerAdapter.ArticleViewHolder articleViewHolder, int i) {
        final Result article = articlesList.get(i);
        articleViewHolder.txtArticleTitle.setText(article.getTitle());
        articleViewHolder.txtAuthor.setText(article.getByline());
        articleViewHolder.txtDate.setText(article.getPublishedDate());

        articleViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String url = article.getUrl().trim();
                if (!url.startsWith("http://") && !url.startsWith("https://")) {
                    url = "http://" + url;
                }

                BitmapFactory.Options options = new BitmapFactory.Options();
                options.outWidth = 24;
                options.outHeight = 24;
                options.inScaled = true;
                Bitmap backButton = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.ic_arrow_back_white_24dp, options);

                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                builder.setCloseButtonIcon(backButton);
                builder.setToolbarColor(ContextCompat.getColor(mContext, R.color.colorAccent));
                builder.addDefaultShareMenuItem();

                CustomTabsIntent customTabsIntent = builder.build();
                customTabsIntent.launchUrl(mContext, Uri.parse(url));
                Log.d("dt185028", url);
            }
        });
    }

    @Override
    public int getItemCount() {
        return articlesList.size();
    }

    class ArticleViewHolder extends RecyclerView.ViewHolder {

        TextView txtArticleTitle, txtArticleTitleSub, txtAuthor, txtDate;


        public ArticleViewHolder(View itemView) {
            super(itemView);

            txtArticleTitle = itemView.findViewById(R.id.txtTitle);
            txtAuthor = itemView.findViewById(R.id.txtAuther);
            txtDate = itemView.findViewById(R.id.txtPublishDate);
        }
    }
}
