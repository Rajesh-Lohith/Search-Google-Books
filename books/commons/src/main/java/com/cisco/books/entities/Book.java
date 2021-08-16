package com.cisco.books.entities;

import com.cisco.books.entities.BookInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    public String id;
    public String kind;
    public String selfLink;

    @OneToOne(cascade = CascadeType.ALL)
    public BookInfo volumeInfo;
}
