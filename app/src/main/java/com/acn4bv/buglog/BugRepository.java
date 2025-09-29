package com.acn4bv.buglog;

import java.util.ArrayList;
import java.util.List;

public class BugRepository {
    private static final List<com.acn4bv.buglog.Bug> BUGS = new ArrayList<>();
    public static void add(com.acn4bv.buglog.Bug b) { BUGS.add(b); }
    public static List<com.acn4bv.buglog.Bug> all() { return BUGS; }
    public static boolean isEmpty() { return BUGS.isEmpty(); }
}
