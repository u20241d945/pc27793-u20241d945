package com.medisupply.platform.pc27793u20241d945.shared.domain.model.valueobjects;


public record UrgencyLevel(int level) {

    public UrgencyLevel {
        if (level < 1|| level > 5) {
            throw new IllegalArgumentException("Level must be between 1 and 5");
        }
    }
}
