package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.UnassignCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new UnassignCommand object
 */
public class UnassignCommandParser implements Parser<UnassignCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the UnassignCommand
     * and returns an UnassignCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public UnassignCommand parse(String args) throws ParseException {
        requireNonNull(args);
        String trimmedArgs = args.trim();
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(trimmedArgs, PREFIX_NAME);

        Index index;
        try {
            index = ParserUtil.parseIndex(argMultimap.getPreamble());
        } catch (ParseException pe) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, UnassignCommand.MESSAGE_USAGE), pe);
        }

        return new UnassignCommand(index, ParserUtil.parseClassName(argMultimap.getValue(PREFIX_NAME).get()));

    }
}