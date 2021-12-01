package as.nl.ff.test_ass_4.json_parser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JSONParserTest {




    @Test
    void jsonParser_getValues_returnsCorrect() {
        //Arrange
        String jsonString = "{'name':'user','id':1234,'marks':[{'english':85,'physics':80,'chemistry':75}]}";
        JSONObject user = new JSONObject(jsonString);

        //Act
        JSONArray marks = user.getJSONArray("marks");
        JSONObject subjects = marks.getJSONObject(0);

        //Assert
        assertEquals("{ \"Parsed\": [ { \"stringValue1\": \"Testing\" } ] }", user.toString());
    }

}
