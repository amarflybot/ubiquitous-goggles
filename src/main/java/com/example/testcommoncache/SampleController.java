package com.example.testcommoncache;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Queue;

@RestController
@RequestMapping("/person")
public class SampleController {

    private final HazelcastInstance hazelcastInstance;


    public SampleController(final HazelcastInstance hazelcastInstance) {
        this.hazelcastInstance = hazelcastInstance;
    }

    @PostMapping
    Person createPerson(@RequestBody Person person) {
        final Queue<Person> queue = this.hazelcastInstance.getQueue("default");
        queue.add(person);
        return person;
    }

    @GetMapping()
    Person getPerson(){
        final Queue<Person> queue = this.hazelcastInstance.getQueue("default");
        return queue.poll();
    }
}
