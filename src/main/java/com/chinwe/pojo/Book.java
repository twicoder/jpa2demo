package com.chinwe.pojo;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {
    @Id
    private Long id;
    private String title;
    private String description;
    private Float unitCost;
    private String isbn;

    public Book() {
    }

    public Book(Long id) {
        this.id = id;
    }

    public Book(Long id, String title, String description, Float unitCost, String isbn) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.unitCost = unitCost;
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", unitCost=" + unitCost +
                ", isbn='" + isbn + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(Float unitCost) {
        this.unitCost = unitCost;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    //==============================================
    // =    hashcode, equals & toString            =
    //==============================================

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;

        Book book = (Book) obj;
        if(description != null ? !description.equals(book.description) : book.description != null) return false;
        if(id != null ? !id.equals(book.id) : book.id != null) return false;
        if(isbn != null ? !isbn.equals(book.isbn) : book.isbn != null) return false;
        if(title != null ? !title.equals(book.title) : book.title != null) return false;
        if(unitCost != null ? !unitCost.equals(book.unitCost) : book.unitCost != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (unitCost != null ? unitCost.hashCode() : 0);
        result = 31 * result + (isbn != null ? isbn.hashCode() : 0);
        return result;
    }
}
