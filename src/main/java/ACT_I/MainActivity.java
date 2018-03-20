package ACT_I;
/*
import Characteristics.*;

public class MainActivity {
    static void ПравЛиТигр(Boolean b){
        ((Phrase) () -> System.out.println("Прим.: Тигр is "+b)).say();
    }
    public static void main(String[] args) {
        //initializtion
        String GlobalState = "Undefined";
        Time Now = new Time(Time.relday.FIRST_DAY, Time.daytime.DAY);
        Place HAF = new Place("Стоакровый лес");
        Place NorthPole = new Place("Северный Полюс");
        ToyCharacter Tigger = new ToyCharacter("tiger","Tigger");
        ToyCharacter Winnie = new ToyCharacter("bear","Winnie");
        Winnie.mod = ToyCharacter.Modifyer.I_DA;
        ToyCharacter Piglet = new ToyCharacter("pig","Piglet");
        ToyCharacter Kanga = new ToyCharacter("kangaroo","Kanga");
        ToyCharacter Roo = new ToyCharacter("kangaroo", "Roo", Kanga.getHome());
        ToyCharacter Rabbit = new ToyCharacter("rabbit","Rabbit");
        Expotition expotition = new Expotition(HAF, NorthPole, new Time("second_day", "morning"), true, Kanga, Roo, Winnie, Piglet, Rabbit);
        Rabbit.getHome().addNeighbours(Kanga.getHome(), Tigger.getHome(), Roo.getHome());
        //action
        Now.showTime();
        Tigger.Presumable_WTP_Modifyer = ToyCharacter.Modifyer.NORMAL;
        Tigger.express_Opinion_About_WTP_Modifyer();
        /*Tigger.addPlan(new Event(HAF, NorthPole, new Time("second_day", "morning"),true, Tigger) {

            @Override
            protected void doIt() {
            }
        });
        ПравЛиТигр(Tigger.Presumable_WTP_Modifyer == Winnie.mod);
        Now.next();
        Rabbit.moveTo(Tigger.getHome());
        Question q1 = new Question(Question.Type.Text,"Какие у тебя планы на завтра?", Rabbit, Tigger);
        Rabbit.say(q1);
        q1.makeAnswer();
        if (q1.getAnswer(Tigger).text.equals("Никаких")) {

            Question q2 = new Question(Question.Type.YorN, "Как насчет того чтобы отправиться на прогулку и захватить с собой "+Piglet.getName()+" и "+Winnie.getName(), Rabbit, Tigger);
            Rabbit.say(q2);
            q2.makeAnswer();
            if (Question.Contains(q2.getAnswer(Tigger).text, Question.Yes)) {
                try {

                    Tigger.addPlan(expotition);
                    GlobalState = "Alright";
                } catch (TooBuisyException e) {
                    Phrase a = new Phrase() {
                        public void say() {
                            System.out.println("Прим.: Тигр лжет.");
                        }
                    };
                    a.say();
                }
            }

        }
        System.out.println("Всё "+GlobalState);

        Now.next();
        expotition.doIt();
        Winnie.SetANameplate(NorthPole, "ОТКРЫТ ВИННИ-ПУХОМ, ПУХ ЕГО НАШЁЛ");

        Now.next();
        System.out.println("Все в походе");
        if(GlobalState.equals("Alright")) {
            Tigger.Presumable_WTP_Modifyer = ToyCharacter.Modifyer.I_DA;
            Tigger.express_Opinion_About_WTP_Modifyer();
            ПравЛиТигр(Tigger.Presumable_WTP_Modifyer == Winnie.mod);
        }
        else{
            System.out.println("Кроме Тигра");
        }
    }
}*/

/* Now.set(Time.relday.FIRST_DAY, Time.daytime.DAY);
            if (Now.getDay() == Time.relday.LATER) {
                System.out.println();
                System.out.println(Now.getDay()+":");
                Tigger.knowledge = "Винни-Пух - Ай-да-Медведь";
                Tigger.say(Tigger.knowledge);
                break;
            }

            Now.showTime();
            if((Now.getDay()==relday.FIRST_DAY)&&(Now.getTime()==daytime.EVENING)){
                Rabbit.moveTo(Tigger.home);
                Rabbit.ask(Tigger, "какие у тебя планы на завтра?");
                if (Objects.equals(Tigger.plans.get(1), null)){
                    Rabbit.ask(Tigger, "как на счет того чтобы отправиться на прогулку и захватить с собой "+Piglet.getName()+" и "+Winnie.getName()+"?");
                    if (Objects.equals(Tigger.answer, "Yes")){
                        Tigger.say(Tigger.answer);
                        GlobalState = "хорошо";
                        expotition.addParticipant(Tigger);
                    } else {GlobalState = "плохо";}
                } else {GlobalState = "плохо";}
                System.out.println("Все " + GlobalState);
            }
            if((Now.getDay()==relday.SECOND_DAY)&&(Now.getTime()==daytime.MORNING)){
                expotition.doIt();
            }
            if((Now.getDay()==relday.SECOND_DAY)&&(Now.getTime()==(daytime.EVENING)||Now.getTime()==(daytime.DAY))){
                System.out.println("Все в походе");
            }
        } while(Now.getDay() != relday.LATER);*/