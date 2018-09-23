package edu.traffic_light.model;

import java.util.Scanner;

public class TrafficLightTurnOff extends Thread {
    private TrafficLight trafficLight;

    public TrafficLightTurnOff(TrafficLight trafficLight) {
        this.trafficLight = trafficLight;
    }

    @Override
    public void run() {
        String message = "Для выключения светофора введите 'q'";
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (scanner.hasNext("q")) {
                // Выключить светофор
                trafficLight.interrupt();
                break;
            } else {
                System.out.println(message);
                scanner.nextLine();
            }
        }
    }
}
