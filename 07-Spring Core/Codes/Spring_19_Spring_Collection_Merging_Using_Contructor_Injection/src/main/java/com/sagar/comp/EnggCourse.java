package com.sagar.comp;

import java.util.Set;

public class EnggCourse {
    private Set<String> subjects;

    public EnggCourse(Set<String> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "EnggCourse{" +
                "subjects=" + subjects +
                '}';
    }
}
