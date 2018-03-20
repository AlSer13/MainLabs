package Characteristics;

import java.util.Arrays;

public class WTPcharacter implements Moveable {
    private String name;
    private Place location;
    private Home home;

    WTPcharacter(String name) { //создаем персонажа и его собственный дом
        this.name = name;
        Home home = new Home(this.name + "'s home", this);
        this.home = home;
        this.location = home; //местоположение по умолчанию - дом
    }

    WTPcharacter(String name, Home home) { //создаем персонажа и селим его в существующий дом
        this.name = name;
        this.setHome(home);
        this.location = home;
    }

    public void moveTo(Place location) {
        this.location = location;
        System.out.println(this.getName() + " перемещается в " + location.getName());
    }

    public void SetANameplate(Place location, String inscription){
        location.nameplate = location.new Nameplate(location, inscription, this);
    }

    public String getName() {
        return name;
    }

    public Home getHome() {
        return home;
    }

    private void setHome(Home home) {
        if ((this.home == null) || (!this.home.equals(home))) { //если персонаж не живет в этом доме
            this.home = home; //поселить его туда
            home.addOwner(this); //и добавить его в список владельцев дома
        }
    }

    public void say(Phrase p) {
        p.say();
    }

    public void say(String text) {
        say(() -> System.out.println(this.name + ": " + text));
    }
    /*public void ask(WTPcharacter who, String s){
            this.say(who.name + s);
            System.out.println("Что же ответит " + who.getName() + "?");
            do {
                Scanner in = new Scanner(System.in);
                who.answer = in.next();
            } while(!ANSWERS.contains(who.answer));
    }*/

    //plans
    private Event[][] plannedaction = new Event[3][3];

    Event getPlans(Time t) {
        return plannedaction[t.getDay().ordinal()][t.getTime().ordinal()];
    }
    public void addPlan(Event e) throws TooBuisyException {
        Time t = e.getTime();
        if (this.IsFree(t) && !e.getParticipants().contains(this)){
            plannedaction[t.getDay().ordinal()][t.getTime().ordinal()] = e;
            e.addParticipant(this);
        } else  throw new TooBuisyException();
    }
    private boolean IsFree(Time t) {
        boolean b = plannedaction[t.getDay().ordinal()][t.getTime().ordinal()] == null;
        return (b);
    }
    // equals and hashcode


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WTPcharacter that = (WTPcharacter) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (location != null ? !location.equals(that.location) : that.location != null) return false;
        if (home != null ? !home.equals(that.home) : that.home != null) return false;
        return Arrays.deepEquals(plannedaction, that.plannedaction);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (home != null ? home.hashCode() : 0);
        result = 31 * result + Arrays.deepHashCode(plannedaction);
        return result;
    }
}