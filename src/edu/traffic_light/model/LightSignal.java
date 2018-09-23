package edu.traffic_light.model;

public class LightSignal {
    private LightColor color;

    public LightSignal() {
    }

    public LightColor getColor() {
        return color;
    }

    public void setColor(LightColor color) {
        this.color = color;
    }

    /**
     * Включить сигнал
     */
    public void turnOn() {
        System.out.println(color.getValue());
    }

    /**
     * Выключить сигнал
     */
    public void turnOff() {
        System.out.println("Switch the light signal");
    }
}
