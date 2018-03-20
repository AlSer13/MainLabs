/*package Characteristics;

import java.util.*;

public class Question implements Phrase {
    private final WTPcharacter speaker; //кто задает вопрос
    private ArrayList<WTPcharacter> listeners = new ArrayList<>(); //от кого ожидается ответ
    private Type type;
    private String text;

    public Question(Type type, String text, WTPcharacter speaker, WTPcharacter... listeners) {
        this.text = text;
        this.speaker = speaker;
        this.listeners.addAll(Arrays.asList(listeners));
        this.type = type;
    }

    public void say() {
        StringBuilder appeal = new StringBuilder();
        for (WTPcharacter c : listeners) {
            appeal.append(", ").append(c.getName());
        }
        appeal.append("?");
        text = text.replaceAll("[?]", "");
        System.out.println(speaker.getName() + ": " + text + appeal);

    }

    public ArrayList<String> answers = new ArrayList<>();

    public String getAnswer(int i) {
        return answers.get(i);
    }

    public void makeAnswer() {
        class Answer implements Phrase {
            private WTPcharacter answerer;
            private String text;

            public String toString() {
                return this.text;
            }

            private Answer(WTPcharacter answerer) {
                this.answerer = answerer;
            }

            private void waitForAnsw(WTPcharacter l) {
                try {
                    System.out.println("Что же ответит " + l.getName() + "?");
                    Scanner in = new Scanner(System.in);
                    text = in.next();
                    if (!AnswIsValid(text)) {
                        throw new InvalidPhraseException();
                    }
                } catch (InvalidPhraseException e) {
                    e.tryAgain();
                    waitForAnsw(l);
                }
            }

            @Override
            public void say() {
                System.out.println(answerer.getName() + ": " + text);
            }
        }
        for (WTPcharacter l : listeners) {
            Answer a = new Answer(l);
            a.waitForAnsw(l);
            a.say();
            answers.add(a.toString());
        }
    }

    private boolean AnswIsValid(String text) throws InvalidPhraseException {
        switch (type) {
            case Text:
                return true;
            case YorN:
                //case Choice:
                return type.ANSWERS.contains(text.toUpperCase());
            default:
                return true;
        }
    }

    @Override
    public String toString() {
        return this.text;
    }

    public static class InvalidPhraseException extends Exception {
        static int k = 0;

        void tryAgain() {
            System.err.println("Наверняка персонаж не станет такого говорить.");
            k++;
            if (k >= 6) {
                System.err.println("Я так не играю :-b");
                System.exit(0);
            }
        }
    }

    public enum Type {
        YorN(Collections.unmodifiableSet(new HashSet<>(Arrays.asList("YES", "NO", "Y", "N", "ДА", "НЕТ", "Д", "Н")))),
        //Choice(),
        Text();
        private Set<String> ANSWERS;

        Type(Set<String> ANSWERS) {
            this.ANSWERS = ANSWERS;
        }

        Type() {
        }
    }
}*/