package seedu.duke.command;

import seedu.duke.lists.WorkoutList;
import seedu.duke.storage.Storage;

import java.util.logging.Logger;

import static seedu.duke.logger.LoggerUtil.setupLogger;

/**
 * Used to exit the program.
 */
public class ExitCommand extends Command {
    public static final String COMMAND_WORD = "bye";
    public static final String MESSAGE_USAGE = "bye: Closes the program" + "\tExample: bye";
    public static final String MESSAGE_GOODBYE = "bye bye";
    private static final Logger LOGGER = Logger.getLogger(ExitCommand.class.getName());

    /**
     * Determines if command is ExitCommand.
     *
     * @param command command that the user wants to execute
     * @return true if command is ExitCommand, false otherwise
     */
    public static boolean isExit(Command command) {
        setupLogger(LOGGER);
        LOGGER.info("End program");
        return command instanceof ExitCommand;
    }

    /**
     * Makes no changes in the task list or storage.
     *
     * @param workouts is the list of Workouts
     * @param storage  is a storage object
     */
    @Override
    public CommandResult executeUserCommand(WorkoutList workouts, Storage storage) {
        return new CommandResult(MESSAGE_GOODBYE);
    }
}
