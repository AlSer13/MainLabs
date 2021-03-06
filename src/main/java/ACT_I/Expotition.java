package ACT_I;

import Characteristics.Event;
import Characteristics.Place;
import Characteristics.WTPcharacter;

import java.util.GregorianCalendar;

public class Expotition extends Event {
    private Place whereTo;
    Expotition(Place fromWhere, Place whereTo, GregorianCalendar date, WTPcharacter... participants){
        super("expotition",fromWhere, date, participants);
        this.whereTo = whereTo;
    }
    protected void doIt(){
        for (WTPcharacter part : this.getParticipants()){
            part.say("Мы идем в поход!");
            part.moveTo(this.whereTo);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Expotition that = (Expotition) o;

        return whereTo != null ? whereTo.equals(that.whereTo) : that.whereTo == null;
    }

    @Override
    public int hashCode() {
        return whereTo != null ? whereTo.hashCode() : 0;
    }
}