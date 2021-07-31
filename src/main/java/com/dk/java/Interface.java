package com.dk.java;

public interface Interface {
    public static final int num = 1;

    public default void print() {
        System.out.println(this.hashCode());
    }

}
