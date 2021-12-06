package com.projectreactor.projectreactor.sec08;

import com.projectreactor.projectreactor.courseutil.Util;
import com.projectreactor.projectreactor.sec08.helper.NameGenerator;

public class Lec01StartWith {

    public static void main(String[] args) {

        NameGenerator generator = new NameGenerator();
        generator.generateNames()
                .take(2)
                .subscribe(Util.subscriber("Sam"));

        generator.generateNames()
                .take(2)
                .subscribe(Util.subscriber("Mike"));

        generator.generateNames()
                .take(2)
                .subscribe(Util.subscriber("Jake"));

        generator.generateNames()
                .filter(n -> n.startsWith("A"))
                .take(2)
                .subscribe(Util.subscriber("Marshal"));
    }
}
