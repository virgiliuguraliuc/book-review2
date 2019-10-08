package org.fasttrackit.bookreview.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Book {

    @Id
    @GeneratedValue
    private long id;
    @NotNull
    private String title;
    @NotNull
    private String author;
    @NotNull
    private int yearOfRelease;
    @NotNull
    private String language;
    @NotNull
    private String type;
    @NotNull
    private String description;
    private int pages;
    private int rank;
    private int likes;
    private Double price;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    private String imagePath;

    @ManyToMany(mappedBy = "books")
    private Set<Cart> carts = new HashSet<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Set<Cart> getCarts() {
        return carts;
    }

    public void setCarts(Set<Cart> carts) {
        this.carts = carts;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", yearOfRelease=" + yearOfRelease +
                ", language='" + language + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", pages=" + pages +
                ", rank=" + rank +
                ", likes=" + likes +
                ", price=" + price +
                ", imagePath='" + imagePath + '\'' +
                ", carts=" + carts +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id &&
                yearOfRelease == book.yearOfRelease &&
                pages == book.pages &&
                rank == book.rank &&
                likes == book.likes &&
                Objects.equals(title, book.title) &&
                Objects.equals(author, book.author) &&
                Objects.equals(language, book.language) &&
                Objects.equals(type, book.type) &&
                Objects.equals(description, book.description) &&
                Objects.equals(price, book.price) &&
                Objects.equals(imagePath, book.imagePath) &&
                Objects.equals(carts, book.carts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, yearOfRelease, language, type, description, pages, rank, likes, price, imagePath, carts);
    }
}
