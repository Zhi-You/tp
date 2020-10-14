package seedu.eduke8.parser;

import seedu.eduke8.command.AnswerCommand;
import seedu.eduke8.command.Command;
import seedu.eduke8.command.HintCommand;
import seedu.eduke8.command.IncorrectCommand;
import seedu.eduke8.common.Displayable;
import seedu.eduke8.common.DisplayableList;
import seedu.eduke8.option.Option;
import seedu.eduke8.question.Question;

import static seedu.eduke8.exception.ExceptionMessages.ERROR_QUIZ_ANSWER_NOT_INDEX;
import static seedu.eduke8.exception.ExceptionMessages.ERROR_QUIZ_COMMAND_NOT_IMPLEMENTED;

import java.util.ArrayList;

public class QuizParser implements Parser {
    private Question question;

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public Command parseCommand(DisplayableList optionList, String userInput) {
        switch (userInput) {
        case "hint":
            return new HintCommand(question.getHint());
        case "back":
            // To be implemented in v2
            return new IncorrectCommand(ERROR_QUIZ_COMMAND_NOT_IMPLEMENTED);
        default:
            try {
                ArrayList<Displayable> options = optionList.getInnerList();
                int chosenIndex = Integer.parseInt(userInput) - 1;
                Option chosenOption = (Option) options.get(chosenIndex);

                return new AnswerCommand(chosenOption, question);
            } catch (NumberFormatException e) {
                return new IncorrectCommand(ERROR_QUIZ_ANSWER_NOT_INDEX);
            }
        }
    }
}
