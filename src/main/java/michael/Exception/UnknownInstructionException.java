package michael.Exception;

public class UnknownInstructionException extends Exception {

    public String unknownInstruction() {
        return "I don't understand your instruction :{ Plese try again";
    }
}
