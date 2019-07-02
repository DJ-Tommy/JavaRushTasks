package com.javarush.task.task21.task2105;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* 
Исправить ошибку. Сравнение объектов
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Solution))
            return false;
        Solution n = (Solution) o;
        return Objects.equals(first, n.first) &&
                Objects.equals(last, n.last);
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
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
    }
}
