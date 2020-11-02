package com.mycompany.rxjava.part1;

import io.reactivex.Observable;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;

/**
 * Cold Observable example
 * Walking all your files
 */
public class Sample4App
{
    public static void main( String[] args )
    {
        final String folder = "/home/chinv/";
        Observable<String> source = Observable.create(emitter -> {
            Files.walkFileTree(Paths.get(folder), new FileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    emitter.onNext(file.toString());
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    if(exc.getMessage().toLowerCase().contains("denied")) {
                        emitter.onNext("ACCESS DENIED to file: " + file.toString());
                    }

                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    return FileVisitResult.CONTINUE;
                }
            });
            emitter.onComplete();
        });

        long startTime = LocalDateTime.now().toEpochSecond(ZoneOffset.of("Z"));
        System.out.println(startTime);

        source.subscribe(
                file -> System.out.println(file),
                error -> { System.out.println(error);},
                () -> { System.out.println("Elapsed time: " + (LocalDateTime.now().toEpochSecond(ZoneOffset.of("Z")) - startTime)); });
    }
}
