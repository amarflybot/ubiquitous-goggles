package com.example.testcommoncache;

import java.util.Comparator;

public class PersonPriorityElementComparator implements Comparator<Person> {
    @Override
    public int compare(final Person o1, final Person o2) {
        return o1.getAge().compareTo(o2.getAge());
    }
}
