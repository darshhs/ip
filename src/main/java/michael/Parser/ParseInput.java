package michael.Parser;

import michael.Exception.InvalidCommand;
import michael.Exception.NumberRangeException;
import michael.Exception.UnknownInstructionException;
import michael.TaskList.*;
import michael.command.*;

import static michael.Michael.dataFile;
import static michael.Michael.numberTasks;

public class ParseInput {
    private final String givenInstruction;
    private String[] instructionListCreated;
    private int currentTaskIndex;


    public ParseInput(String instruction) {
        this.givenInstruction = instruction;
        parseInstruction();
        parseIndex();
    }

    public void parseInstruction() {
        this.instructionListCreated = givenInstruction.split(" ", 2);
    }

    public void parseIndex() {
        int index = 0;
        if (instructionListCreated[0].equals("mark") || instructionListCreated[0].equals("unmark") || instructionListCreated[0].equals("delete")) { //if mark/unmark/delete instruction, decrement integer by one
            try {
                index = Integer.parseInt(instructionListCreated[1]) - 1;
                this.currentTaskIndex = index;
            } catch (NumberFormatException e) {
                System.out.println("Not a valid number, please try again");
            }
        }
    }

    public String[] parseDeadline() {
        return instructionListCreated[1].split(" /by ", 2);
    }

    public String[] parseEvent() {
        String[] mainEvent = instructionListCreated[1].split(" /from ", 2);
        String[] eventDuration = mainEvent[1].split(" /to ", 2);
        return new String[]{mainEvent[0], eventDuration[0], eventDuration[1]};
    }


    public Command parse() {
        Task task;
        try {
            switch (instructionListCreated[0]) {
            case "bye":
                return new ExitCommand();
            case "list":
                return new ShowListCommand();
            case "mark":
                if (currentTaskIndex >= 0 && currentTaskIndex < numberTasks) {
                    return new MarkTaskCommand(currentTaskIndex);
                } else {
                    throw new NumberRangeException();
                }
            case "unmark":
                if (currentTaskIndex >= 0 && currentTaskIndex < numberTasks) {
                    return new UnmarkTaskCommand(currentTaskIndex);
                } else {
                    throw new NumberRangeException();
                }
            case "todo":
                task = new Todo(instructionListCreated[1], dataFile, numberTasks + 1, false, true);
                return new AddCommand(task, true);
            case "deadline":
                String[] deadlineInstruction = parseDeadline();
                task = new Deadline(deadlineInstruction[0], deadlineInstruction[1], dataFile, numberTasks + 1, false, true);
                return new AddCommand(task, true);
            case "event":
                String[] eventInstruction = parseEvent();
                task = new Event(eventInstruction[0], eventInstruction[1], eventInstruction[2], dataFile, numberTasks + 1, false, true);
                return new AddCommand(task, true);
            case "delete":
                return new DeleteCommand(currentTaskIndex);

            default:
                throw new UnknownInstructionException();
            }

        } catch (UnknownInstructionException e) {
            return new InvalidCommand("Unknown instruction: " + e.unknownInstruction());
        } catch (NumberRangeException e) {
            return new InvalidCommand("Number not within range: " + e.notInRange());
        }
    }
}


