package com.example.demo.enums;

public enum Rating {
    POOR("Poor"),
    FINE("Fine"),
    GOOD("Good"),
    VERYGOOD("Very Good"),
    EXCELLENT("Excellent");

    private final String value;

    public String getValue() {
        return value;
    }

    Rating(String value) {
        this.value = value;
    }
}
