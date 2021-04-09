package com.example.bookdatabasecollection.ui.data.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity(tableName = "books")
public class BookEntity {

    @ColumnInfo
    @PrimaryKey
    @NonNull
    private String title;

    @ColumnInfo
    private String publishedDate;

    @Embedded
    private AuthorEntity authorEntity;

    @ColumnInfo
    private String url;

    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

    public String getPublishedDate() {return publishedDate;}

    public void setPublishedDate(String publishedDate){this.publishedDate = publishedDate;}

    public AuthorEntity getAuthorEntity(){return authorEntity;}

    public void setAuthorEntity(AuthorEntity authorEntity){this.authorEntity = authorEntity;}

    public String getUrl(){return url;}

    public void setUrl(String url){this.url = url;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookEntity that = (BookEntity) o;
        return title.equals(that.title) &&
                publishedDate.equals(that.publishedDate) &&
                authorEntity.equals(that.authorEntity) &&
                url.equals(that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, publishedDate, authorEntity, url);
    }

    @Override
    public String toString() {
        return "BookEntity{" +
                "title='" + title + '\'' +
                ", publishedDate='" + publishedDate + '\'' +
                ", author=" + authorEntity +
                ", url='" + url + '\'' +
                '}';
    }
}
