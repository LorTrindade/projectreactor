package com.projectreactor.projectreactor.sec09.helper;

import com.github.javafaker.Book;
import com.projectreactor.projectreactor.courseutil.Util;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BookOrder {

    private String title;
    private String author;
    private String category;
    private double price;

    public BookOrder() {
        Book book = Util.faker().book();
        this.title = book.title();
        this.author = book.author();
        this.category = book.genre();
        this.price = Double.parseDouble(Util.faker().commerce().price());
    }
}
