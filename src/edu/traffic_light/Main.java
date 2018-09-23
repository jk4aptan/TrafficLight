package edu.traffic_light;

import edu.traffic_light.factory.TrafficLightFactory;
import edu.traffic_light.model.TrafficLight;
import edu.traffic_light.model.TrafficLightTurnOff;

public class Main {
    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLightFactory().createThreeSignalsTrafficLight();
        new TrafficLightTurnOff(trafficLight).start();
        trafficLight.start();
    }
}
