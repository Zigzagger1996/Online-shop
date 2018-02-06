package dbController;

import java.util.regex.Pattern;

public interface Regex {
	final Pattern DIGIT_REGEX = Pattern.compile("[0-9]+");
    final Pattern NAME_REGEX = Pattern.compile("[A-Za-z']+");
 // mail@mail.com
    final Pattern REGEX_MAIL = Pattern.compile("([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}");
}
