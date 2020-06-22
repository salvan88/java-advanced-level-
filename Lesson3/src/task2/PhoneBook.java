package task2;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {

    private final Map<String, List<String>> records;

    public PhoneBook() {
        records = new HashMap<>();
    }

    public void add(String surname, String number) {
        if (!records.containsKey(surname)) {
            records.put(surname, new ArrayList<>());
        }
        records.get(surname).add(number);
    }

    public void get(String surname) {
        for(String value : records.get(surname)){
            System.out.println(surname + " :" + value);
        }
    }
}
