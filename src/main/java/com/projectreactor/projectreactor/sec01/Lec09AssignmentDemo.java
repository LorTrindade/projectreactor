package com.projectreactor.projectreactor.sec01;

import com.projectreactor.projectreactor.courseutil.Util;
import com.projectreactor.projectreactor.sec01.assignment.FileService;

public class Lec09AssignmentDemo {

    public static void main(String[] args) {
        FileService.read("file03")
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );

        FileService.delete("file03")
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );

//        FileService.write("file03", "This is file3")
//                .subscribe(
//                        Util.onNext(),
//                        Util.onError(),
//                        Util.onComplete()
//                );
    }
}
