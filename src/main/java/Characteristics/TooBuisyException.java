package Characteristics;
public class TooBuisyException extends RuntimeException{
    @Override
    public String getMessage() {
        return "Не удалось договориться с персонажем, он занят.";
    }
}
