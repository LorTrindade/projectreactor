package com.projectreactor.projectreactor.sec09;

import com.projectreactor.projectreactor.courseutil.Util;
import com.projectreactor.projectreactor.sec09.helper.BookOrder;
import com.projectreactor.projectreactor.sec09.helper.RevenueReport;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lec03Assignment {

    public static void main(String[] args) {

        Set<String> allowedCategories = Set.of(
                "Science Fiction",
                "Fantasy",
                "Suspense/Thriller"
        );

        bookStream()
                .filter(book -> allowedCategories.contains(book.getCategory()))
                .buffer(Duration.ofSeconds(5))
                .map(list -> revenueCalculator(list))
                .subscribe(Util.subscriber());

        Util.sleepSeconds(60);
    }

    private static RevenueReport revenueCalculator(List<BookOrder> books) {
        return new RevenueReport(books.stream()
                .collect(Collectors.groupingBy(
                        BookOrder::getCategory,
                        Collectors.summingDouble(BookOrder::getPrice)
                )));
    }

    private static Flux<BookOrder> bookStream() {
        return Flux.interval(Duration.ofMillis(200))
                .map(i -> new BookOrder());
    }
}
