package michael.Exception;

public class NumberRangeException extends Exception {

    public String notInRange() {
        return "Oh no! the number you have given is not within range, please try again";
    }
}
