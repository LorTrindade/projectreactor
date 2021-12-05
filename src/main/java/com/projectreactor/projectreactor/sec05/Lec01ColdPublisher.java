package com.projectreactor.projectreactor.sec05;

import com.projectreactor.projectreactor.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class Lec01ColdPublisher {

    public static void main(String[] args) {

        Flux<String> movieStream = Flux.fromStream(Lec01ColdPublisher::getMovie)
                .delayElements(Duration.ofSeconds(2));

        movieStream
                .subscribe(Util.subscriber("Lor"));

        Util.sleepSeconds(5);

        movieStream
                .subscribe(Util.subscriber("Junior"));

        Util.sleepSeconds(60);
    }

    //netflix
    private static Stream<String> getMovie() {
        System.out.println("Got the movie streaming req");

        return Stream.of(
                "Scene 1",
                "Scene 2",
                "Scene 3",
                "Scene 4",
                "Scene 5",
                "Scene 6",
                "Scene 7"
        );
    }
}
