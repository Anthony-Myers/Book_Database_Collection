package com.example.bookdatabasecollection.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookdatabasecollection.ui.data.entities.BookEntity;

import java.util.List;

import com.example.bookdatabasecollection.R;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.BooksViewHolder> {
    List<BookEntity> mBooksList;
    private static ClickListener clickListener;

    public BooksAdapter(List<BookEntity> books) {mBooksList = books;}

    @NonNull
    @Override
    public BooksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.book_item, parent, false);
        return new BooksViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BooksAdapter.BooksViewHolder holder, int position) {
        BookEntity book = getItem(position);

        holder.title.setText("Title: "+book.getTitle());
        holder.datePublished.setText("Published: "+book.getPublishedDate());
        holder.authorName.setText("Author: "+book.getAuthorEntity().getName());
        holder.authorBirthday.setText("Author Birthday: "+book.getAuthorEntity().getBirthday());
        holder.url.setText("URL: "+book.getUrl());
    }

    @Override
    public int getItemCount() {
        return mBooksList.size();
    }

    public BookEntity getItem(int position){return mBooksList.get(position);}

    public static class BooksViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView title;
        private TextView datePublished;
        private TextView authorName;
        private TextView authorBirthday;
        private TextView url;

        public BooksViewHolder(@NonNull View itemView){
            super(itemView);
            itemView.setOnClickListener(this);
            title = itemView.findViewById(R.id.book_title_tv);
            datePublished = itemView.findViewById(R.id.published_date_tv);
            authorName = itemView.findViewById(R.id.author_name_tv);
            authorBirthday = itemView.findViewById(R.id.author_birthday_tv);
            url = itemView.findViewById(R.id.url_tv);
        }

        @Override
        public void onClick(View view){
            clickListener.onItemClick(getAdapterPosition());
        }

    }
    public void setOnItemClickListener(ClickListener clickListener){
        this.clickListener = clickListener;
    }

    public interface ClickListener{
        void onItemClick(int position);
    }
}
