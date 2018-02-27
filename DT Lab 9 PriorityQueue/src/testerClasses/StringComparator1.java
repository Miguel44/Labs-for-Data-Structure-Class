package testerClasses;

import java.util.Comparator;

public class StringComparator1 implements Comparator<String> { 
    public int compare(String s1, String s2) { 
        return s2.compareTo(s1); 
    } 
}

