package com.projectreactor.projectreactor.sec11;

import com.projectreactor.projectreactor.courseutil.Util;
import com.projectreactor.projectreactor.sec11.assignment.SlackMember;
import com.projectreactor.projectreactor.sec11.assignment.SlackMessage;
import com.projectreactor.projectreactor.sec11.assignment.SlackRoom;

public class Lec07SlackDemo {

    public static void main(String[] args) {

        SlackRoom slackRoom = new SlackRoom("reactor");

        SlackMember sam = new SlackMember("Sam");
        SlackMember jake = new SlackMember("Jake");
        SlackMember lorhana = new SlackMember("Lorhana");

        slackRoom.joinRoom(sam);
        slackRoom.joinRoom(jake);

        sam.says("Hi all..");
        Util.sleepSeconds(4);

        jake.says("Hey mate");
        sam.says("I simply wanted to say hi...");

        slackRoom.joinRoom(lorhana);
        lorhana.says("Hey guys, glad to be here");

    }
}
