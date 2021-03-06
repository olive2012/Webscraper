package it.akademija.webscrapper.helpers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexHelper {

    /**
     * method helps extract chaannel title from appropriate attribute
     * @param text
     * @return String channelName
     */
    public static String parsingTextWithRegex(String text) {
        final String REGEX = "tvprogname\\=\\\"(.+)\\\"\\s";
        final Pattern pattern = Pattern.compile(REGEX, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(text);
        String channelName = "";
        if (matcher.find()) {
            channelName = matcher.group(1);
        }
        return channelName;
    }
}
