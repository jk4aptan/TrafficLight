package edu.traffic_light.model;

import java.util.List;
import java.util.Map;

public class TrafficLight extends Thread {
    /**
     * Сигналы светофора
     */
    private List<LightSignal> signals;

    /**
     * Длительности включения сигналов светофора
     * Map< Длительность сигнала, Индекс сигнала в списке сигналов >
     */
    private Map<Integer, Integer> durations;

    /**
     * Очередность включения сигналов светофора
     * Map< Очередность сигнала, Индекс сигнала в списке сигналов >
     */
    private Map<Integer, Integer> order;

    public TrafficLight(List<LightSignal> signals, Map<Integer, Integer> duration, Map<Integer, Integer> order) {
        this.signals = signals;
        this.durations = duration;
        this.order = order;
    }

    @Override
    public void run() {
        turnOn();
    }

    /**
     * Включить светофор
     */
    private void turnOn() {
        System.out.println("Светофор включен ...");
        try {
            // Цикл сигналов
            while (true) {
                // Для каждого сигнала в очереди
                for (Integer index : order.values()) {
                    // Определить сигнал
                    LightSignal signal = signals.get(index);
                    // Включить сигнал
                    signal.turnOn();
                    // Подождать время включения сигнала
                    Thread.sleep(durations.get(index));
                    // Выключить сигнал
                    signal.turnOff();
                }
            }
        } catch (InterruptedException e) {
            // Выключить светофор
            turnOff();
        }
    }

    /**
     * Выключить светофор
     */
    private void turnOff() {
        System.out.println("Светофор выключен");
    }
}
