package com.javarush.task.task21.task2104;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/*
Equals and HashCode
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Solution)) return false;
        Solution solution = (Solution) o;
        return Objects.equals(first, solution.first) &&
                Objects.equals(last, solution.last);
    }

    public int hashCode() {
        int hash = 0;
        if (first == null) {
            hash++;
        } else {
            hash += first.hashCode() / 10000;
        }
        if (last == null) {
            hash++;
        } else hash += last.hashCode() / 10000;
        return hash;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        for (Solution sss : s) {
            System.out.println("First hashCode is " + sss.hashCode());
        }
        System.out.println(s.contains(new Solution("Donald", "Duck")));

        ArrayList<Solution> ss = new ArrayList<>();
        ss.add(new Solution("Donald", null));
        ss.add(new Solution("Donald", null));
        System.out.println("Equals is " + ss.get(0).equals(ss.get(1)));
        System.out.println("HashCodes are " + ss.get(0).hashCode() + "  " + ss.get(1).hashCode());
    }
}
