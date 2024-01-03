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
        final IMap<String, Person> map = this.hazelcastInstance.getMap("person");
        map.putIfAbsent(person.getName(), person);
        return person;
    }

    @GetMapping("/{name}")
    Person getPerson(@PathVariable String name){
        final IMap<String, Person> map = this.hazelcastInstance.getMap("person");
        return map.get(name);
    }
}
