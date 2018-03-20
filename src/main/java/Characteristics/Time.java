package Characteristics;

public class Time { //класс для времени; время формата: день - время дня
    private relday day; //задает день из перечисления
    private daytime time; //задает время в этом дне из перечисления
    private static relday[] days = relday.values();
    private static daytime[] times = daytime.values();

    public Time(relday day, daytime time) {
        this.day = day;
        this.time = time;
    }

    public Time(String day, String time) {
        day = day.toUpperCase().replaceAll(" ", "_");
        time = time.toUpperCase();
        this.day = relday.valueOf(day);
        this.time = daytime.valueOf(time);
    }

    public void next(){
        int t = this.getTime().ordinal()+1;
        int d = this.getDay().ordinal()+1;
        if (t == 3){
            this.day = days[d];
            t = 0;
        }
        if (d == 3){
            System.out.println("The time is over");
            throw new TimeIsOverException();
        }
        this.time = times[t];
        System.out.print("\nНаступает ");
        this.showTime();
    }

    public void showTime(){
        System.out.println(this.getDay()+" "+this.getTime());
    }

    relday getDay() {
        return day;
    }

    daytime getTime() {
        return time;
    }

    public void set(relday day, daytime time) {
        this.day = day;
        this.time = time;
    }

    public void set(String day, String time) {
        day = day.toUpperCase();
        time = time.toUpperCase();
        this.day = relday.valueOf(day);
        this.time = daytime.valueOf(time);
    }

    public enum relday {
        FIRST_DAY,
        SECOND_DAY,
        LATER
    }

    public enum daytime {
        MORNING,
        DAY,
        EVENING
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Time time1 = (Time) o;

        if (day != time1.day) return false;
        return time == time1.time;
    }

    @Override
    public int hashCode() {
        int result = day != null ? day.hashCode() : 0;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }

    private class TimeIsOverException extends RuntimeException{
        @Override
        public String getMessage() {
            return("The time is over.");
        }
    }
}
