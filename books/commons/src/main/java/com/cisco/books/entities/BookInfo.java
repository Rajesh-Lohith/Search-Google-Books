package com.cisco.books.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String title;

    @ElementCollection()
    @CollectionTable(name = "authors", joinColumns = @JoinColumn(name = "id"))
    public List<String> authors;
    public String publisher;
    public String publishedDate;
    public String description;
    public int pageCount;
    public String printType;
    public String mainCategory;

    @ElementCollection
    @CollectionTable(name = "categories", joinColumns = @JoinColumn(name = "id"))
    public List<String> categories;
    public double averageRating;
    public int ratingsCount;
    public String contentVersion;
    public String language;
    public String infoLink;
    public String canonicalVolumeLink;
}
