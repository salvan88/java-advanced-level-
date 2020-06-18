package task2;

public class DayOfWeekMain {
    public static void main(String[] args) {
        System.out.println(getWorkingHours(DayOfWeek.MONDAY));
        System.out.println(getWorkingHours(DayOfWeek.WEDNESDAY));
        System.out.println(getWorkingHours(DayOfWeek.SATURDAY));
    }

    private static String getWorkingHours(DayOfWeek day) {
        if(day.ordinal() == 5 || day.ordinal() == 6)
            return "Сегодня выходной.";
        else
            return "До конца рабочей недели осталось " + (5 - day.ordinal()) * 8 + " часов.";
    }
}
