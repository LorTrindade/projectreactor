package com.projectreactor.projectreactor.sec05;

import com.projectreactor.projectreactor.courseutil.Util;
import reactor.core.publisher.Flux;

import javax.swing.text.html.Option;
import java.time.Duration;
import java.util.Optional;
import java.util.stream.Stream;

public class Lec02HotPublisher {

    public static void main(String[] args) {

        Flux<String> movieStream = Flux.fromStream(Lec02HotPublisher::getMovie)
                .delayElements(Duration.ofSeconds(2))
                .share();

        movieStream
                .subscribe(Util.subscriber("Lor"));

        Util.sleepSeconds(5);

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
