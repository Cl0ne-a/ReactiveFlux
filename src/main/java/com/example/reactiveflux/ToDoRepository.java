package com.example.reactiveflux;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
@Component
public class ToDoRepository {

    private final Flux<ToDo> toDoFlux =
            Flux.fromIterable(Arrays.asList(
                    new ToDo("Do homework"),
                    new ToDo("Workout in the morning"),
                    new ToDo("Make dinner"),
                    new ToDo("Clean the room", true)
            ));

    public Mono<ToDo> findById(String id) {
        return Mono.from(toDoFlux).filter(t -> t.getId().equals(id));
    }

    public Flux<ToDo> findAll() {
        return toDoFlux;
    }
 }
