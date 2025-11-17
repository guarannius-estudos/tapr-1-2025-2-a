package com.example.inventory.support;

import java.util.UUID;

public class RandomIdGenerator {
    public static String generate() {
        return UUID.randomUUID().toString();
    }
}
