package com.example.testcommoncache;

import com.hazelcast.collection.ItemEvent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ItemListener implements com.hazelcast.collection.ItemListener<Person> {


    @Override
    public void itemAdded(final ItemEvent<Person> itemEvent) {
        log.info("Person added with Name: {}", itemEvent.getItem().getName());
    }

    @Override
    public void itemRemoved(final ItemEvent<Person> itemEvent) {
        log.info("Person Removed with Name: {}", itemEvent.getItem().getName());
    }
}
