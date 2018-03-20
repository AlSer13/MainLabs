package Characteristics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Event {
    private List<WTPcharacter> Participants = new ArrayList<>();
    private Time time;
    private Place place;
    public String name;
    private boolean exact;

    public Event(Place place, Time time, boolean exact, WTPcharacter... participants){
        this.place = place;
        this.time = time;
        this.exact = exact;
        this.Participants.addAll(Arrays.asList(participants));
    }

    protected List<WTPcharacter> getParticipants() {
        return Participants;
    }

    public void addParticipant(WTPcharacter participant) throws TooBuisyException {
        this.Participants.add(participant);
        if (participant.getPlans(time)!=this) {
            participant.addPlan(this);
        }
    }

    public Time getTime() {
        return time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (exact != event.exact) return false;
        if (Participants != null ? !Participants.equals(event.Participants) : event.Participants != null) return false;
        if (time != null ? !time.equals(event.time) : event.time != null) return false;
        return place != null ? place.equals(event.place) : event.place == null;
    }

    @Override
    public int hashCode() {
        int result = Participants != null ? Participants.hashCode() : 0;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (place != null ? place.hashCode() : 0);
        result = 31 * result + (exact ? 1 : 0);
        return result;
    }
}
