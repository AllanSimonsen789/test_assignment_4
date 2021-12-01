package as.nl.ff.test_ass_4.json_parser;

import java.util.ArrayList;
import java.util.Collections;

// To parse json array
public class JSONArray {

    private final static char specialChar;
    private final static char commaChar;

    static {
        specialChar = String.valueOf(CONSTANTS.SPECIAL)
                .toCharArray()[0];
        commaChar = String.valueOf(CONSTANTS.COMMA)
                .toCharArray()[0];
    }

    private ArrayList<String> objects;

    public JSONArray(String arg) {
        getJSONObjects(arg);
    }

    // Storing JSON objects in array list
    public void getJSONObjects(String arg) {

        objects = new ArrayList<String>();

        if (arg.startsWith(String.valueOf(
                CONSTANTS.SQUARE_OPEN_BRACKETS))
                && arg.endsWith(String.valueOf(
                CONSTANTS.SQUARE_CLOSE_BRACKETS))) {

            StringBuilder builder = new StringBuilder(arg);

            builder.deleteCharAt(0);
            builder.deleteCharAt(builder.length() - 1);

            builder = replaceCOMMA(builder);

            Collections.addAll(
                    objects,
                    builder.toString().split(
                            String.valueOf(CONSTANTS.COMMA)));
        }
    }

    public StringBuilder replaceCOMMA(StringBuilder arg) {
        boolean isArray = false;

        for (int i = 0; i < arg.length(); i++) {
            char a = arg.charAt(i);
            if (isArray) {

                if (String.valueOf(a).compareTo(
                        String.valueOf(CONSTANTS.COMMA))
                        == 0) {
                    arg.setCharAt(i, specialChar);
                }
            }

            if (String.valueOf(a).compareTo(String.valueOf(
                    CONSTANTS.CURLY_OPEN_BRACKETS))
                    == 0)
                isArray = true;

            if (String.valueOf(a).compareTo(String.valueOf(
                    CONSTANTS.CURLY_CLOSE_BRACKETS))
                    == 0)
                isArray = false;
        }

        return arg;
    }

    // Getting json object by index from array list
    public String getObject(int index) {
        if (objects != null) {
            return objects.get(index).replace(specialChar,
                    commaChar);
        }

        return null;
    }

    // Getting json object from array list
    public JSONObject getJSONObject(int index) {

        if (objects != null) {
            return new JSONObject(
                    objects.get(index).replace('|', ','));
        }

        return null;
    }
}