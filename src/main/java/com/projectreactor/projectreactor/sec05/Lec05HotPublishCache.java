package com.projectreactor.projectreactor.sec05;

import com.projectreactor.projectreactor.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class Lec05HotPublishCache {

    public static void main(String[] args) {

        //cache = publish.replay()
        Flux<String> movieStream = Flux.fromStream(() -> getMovie())
                .delayElements(Duration.ofSeconds(1))
                .cache();

        Util.sleepSeconds(2);

        movieStream
                .subscribe(Util.subscriber("Lor"));

        Util.sleepSeconds(10);

        System.out.println("Junior is about to join");

        movieStream
                .subscribe(Util.subscriber("Junior"));

        Util.sleepSeconds(60);
    }

    //movie-theatre
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
