package com.reactiveJava.udemy.sec02;

import com.reactiveJava.udemy.common.Util;
import com.reactiveJava.udemy.sec02.assignment.FileServiceImpl;

public class Lec12Assignment {
    public static void main(String[] args) {
        var fileService = new FileServiceImpl();

        fileService.write("file.txt","this is a file test").
                subscribe(Util.subscriber());
        fileService.read("file.txt")
                .subscribe(Util.subscriber());

        fileService.delete("file.txt")
                .subscribe(Util.subscriber());
    }
}
