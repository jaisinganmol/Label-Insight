package Problem1;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

/**
 * Finding missing letters out of a pangram
 */

public class MissingLetters {

    private static final List<Character> ALPHABET = Collections.synchronizedList(new ArrayList<>());
    private static final int LOWERCASE_START = 97;
    private static final int LOWERCASE_END = 122;
    private static final int UPPERCASE_START = 65;
    private static final int UPPERCASE_END = 90;

    /**
     *  Static code block to enforce LOWER CASE characters.
     */

    static {
        for (int i = 97; i <= 122; i++) {
            ALPHABET.add((char) i);
        }
    }


    /**
     * Method checks each character of input String for missing char
     *
     * @return Letters missing (in a concatenated format) that form a pangram.
     */

    public String getMissingLetters(String testString) {

        List<Character> unseenCharacters = new ArrayList<>(ALPHABET);

        if (!StringUtils.isBlank(testString)) {
            StringReader reader = new StringReader(testString);
            try {
                int input = reader.read();
                while (input != -1) {
                    Character testCharacter = Character.toLowerCase((char) input);
                    if (isAsciiAlpha(testCharacter)) {
                        unseenCharacters.remove(testCharacter);
                        if (unseenCharacters.isEmpty()) {
                            break;
                        }
                    }
                    input = reader.read();
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return listToString(unseenCharacters);
    }


    private boolean isAsciiAlpha(Character character) {
        int charValue = (int) character;
        if ((LOWERCASE_START <= charValue && charValue <= LOWERCASE_END) || (UPPERCASE_START <= charValue && charValue <= UPPERCASE_END)) {
            return true;
        }
        return false;
    }

    private String listToString(List<?> list) {

        return list.stream()
                .map(n -> n.toString())
                .collect(Collectors.joining(""));
    }

}