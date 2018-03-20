package Characteristics;

class StrangeThing {
    public void be(StrangeThing a){
        if(a != null){
            a = null;
        }
    }
}

public class StrangeThingsHappen{
    public static void main(String[] args) {
        StrangeThing honey = new StrangeThing();
        honey.be(honey);
        System.out.println();
    }
}
