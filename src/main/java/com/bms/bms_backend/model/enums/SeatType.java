package com.bms.bms_backend.model.enums;

import com.bms.bms_backend.model.Seat;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum SeatType {
    SILVER,
    GOLD,
    PREMIUM;

    @JsonCreator
    public static SeatType fromValue(String value) {
        for(SeatType type : SeatType.values()) {
            if(type.name().equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid seat type : " + value);
    }

    @JsonValue
    public String toValue() {
        return name().toUpperCase();
    }
}
