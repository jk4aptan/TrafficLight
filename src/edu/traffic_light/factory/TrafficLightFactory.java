package edu.traffic_light.factory;

import edu.traffic_light.model.LightColor;
import edu.traffic_light.model.LightSignal;
import edu.traffic_light.model.TrafficLight;

import java.util.*;

public class TrafficLightFactory {
    private static final Integer MIN_VALUE_DURATION = 1;
    private static final Integer MAX_VALUE_DURATION = 5;

    /**
     * Создание светофора с тремя сигналами
     *
     * @return светофор с тремя сигналами
     */
    public TrafficLight createThreeSignalsTrafficLight() {

        // Создать сигналы светофора; КРАСНЫЙ, ЖЕЛТЫЙ, ЗЕЛЕНЫЙ
        LightSignal redSignal = new LightSignal();
        redSignal.setColor(LightColor.RED);

        LightSignal yellowSignal = new LightSignal();
        yellowSignal.setColor(LightColor.YELLOW);

        LightSignal greenSignal = new LightSignal();
        greenSignal.setColor(LightColor.GREEN);

        List<LightSignal> signals = new ArrayList<>();
        signals.add(redSignal);
        signals.add(yellowSignal);
        signals.add(greenSignal);

        // Определить порядок цикла сигналов светофора - Map< Очередность сигнала, Индекс сигнала в списке сигналов >
        Map<Integer, Integer> order = new HashMap<>();
        order.put(0, signals.indexOf(redSignal));
        order.put(1, signals.indexOf(yellowSignal));
        order.put(2, signals.indexOf(greenSignal));
        order.put(3, signals.indexOf(yellowSignal));

        // Определить длительности сигналов светофора - Map< Индекс сигнала в списке сигналов, Длительность сигнала > 
        Map<Integer, Integer> durations = new HashMap<>();
        durations.put(signals.indexOf(redSignal), getDuration(redSignal.getColor().getValue()));
        durations.put(signals.indexOf(yellowSignal), getDuration(yellowSignal.getColor().getValue()));
        durations.put(signals.indexOf(greenSignal), getDuration(greenSignal.getColor().getValue()));

        return new TrafficLight(signals, durations, order);
    }

    /**
     * Определение длительности сигнала светофора 
     *
     * @param signal сигнал светофора
     * @return длительность сигнала светофора
     */
    private Integer getDuration(String signal) {
        Integer duration = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Введите длительность сигнала %s в минутах (от %d до %d ): ", signal, MIN_VALUE_DURATION, MAX_VALUE_DURATION);
        while (true) {
            if (scanner.hasNextInt() && isDurationValid(duration = scanner.nextInt())) {
                duration = transformToMilliSecondsFromMinutes(duration);
                break;
            } else {
                System.out.println("Не верный формат данных. Повторите ввод.");
            }
        }
        return duration;
    }

    /**
     * Определение валидности значения длительности сигнала светофора
     *
     * @param duration длительность сигнала светофора
     * @return true если значение валидно в противном случае false
     */
    private boolean isDurationValid(Integer duration) {
        return duration >= MIN_VALUE_DURATION && duration <= MAX_VALUE_DURATION;
    }

    private Integer transformToMilliSecondsFromMinutes(Integer time) {
        final int secondsPerMinute = 60;
        final int millisecondsRerSecond = 1000;
        return time * secondsPerMinute * millisecondsRerSecond;
    }
}
