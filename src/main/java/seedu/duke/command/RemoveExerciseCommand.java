package seedu.duke.command;

import seedu.duke.exception.GetJackDException;
import seedu.duke.lists.WorkoutList;
import seedu.duke.tasks.Exercise;
import seedu.duke.ui.Ui;

public class RemoveExerciseCommand extends Command {
    public static final String COMMAND_WORD = "remove";
    public static final String MESSAGE_USAGE = "remove: Removes the exercise from the workout.\n"
            + "\tParameters: w/WORKOUT_INDEX e/EXERCISE_INDEX\n"
            + "\tExample: remove w/1 e/3\n";
    public static final String MESSAGE_SUCCESS = "Removed exercise %1$s";
    private final int workoutIndex;
    private final int exerciseIndex;

    public RemoveExerciseCommand(int workoutIndex, int exerciseIndex) {
        this.workoutIndex = workoutIndex;
        this.exerciseIndex = exerciseIndex;
    }

    @Override
    public void executeUserCommand(WorkoutList workouts, Ui ui) throws GetJackDException {
        try {
            Exercise toRemove = workouts.getWorkout(workoutIndex).removeExercise(exerciseIndex);
            ui.showToUser(String.format(MESSAGE_SUCCESS, toRemove.toString()));
        } catch (IndexOutOfBoundsException e) {
            ui.showToUser(MESSAGE_EXERCISE_NOT_FOUND);
        }
    }
}
