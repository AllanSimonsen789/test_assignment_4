package as.nl.ff.test_ass_4.json_parser;

// To parse json string
public class Parser {

    // json string with user data
    // Custom data been passed as in arguments
    private final static String jsonString = "{'name':'user','id':1234,'marks':[{'english':85,'physics':80,'chemistry':75}]}";

    // Main driver method
    public static void main(String[] args)
    {

        // Parse json object for user data
        JSONObject user = new JSONObject(jsonString);

        // Get json array for user's marks
        JSONArray marks = user.getJSONArray("marks");

        // Get json object for subject's marks
        JSONObject subjects = marks.getJSONObject(0);

        // Print and display commands
        System.out.println(
                String.format("English marks - %s",
                        subjects.getValue("english")));
        System.out.println(
                String.format("Physics marks - %s",
                        subjects.getValue("physics")));
        System.out.println(
                String.format("Chemistry marks - %s",
                        subjects.getValue("chemistry")));
    }
}

