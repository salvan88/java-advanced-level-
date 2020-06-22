package task1;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String[] words = {
                "Сова", "Кот", "Собака", "Волк", "Сова", "Кот", "Дельфин", "Кит", "Попугай", "Кит"
        };

        Map<String, Integer> maps = new HashMap<>();

        for (String str : words) {
            Integer count = maps.getOrDefault(str, 0);

            maps.put(str, count + 1);
        }
        
        System.out.println(maps.keySet() + "\n" + maps);
    }
}
