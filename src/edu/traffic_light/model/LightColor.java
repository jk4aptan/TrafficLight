package edu.traffic_light.model;

public enum LightColor {
    RED("КРАСНЫЙ"), YELLOW("ЖЕЛТЫЙ"), GREEN("ЗЕЛЕНЫЙ");

    private String value;

    LightColor(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
