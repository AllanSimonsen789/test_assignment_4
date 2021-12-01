package as.nl.ff.test_ass_4.json_parser;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JSONParserOLDTest {

    JSONParserOLD jsonParserOLD = new JSONParserOLD();

    @Test
    void jsonParser_parseString_returnsCorrect() {
        //Arrange
        String text = "Testing";
        //Act
        String parsedString = jsonParserOLD.parser(text);
        //Assert
        assertEquals("{ \"Parsed\": [ { \"stringValue1\": \"Testing\" } ] }", parsedString);
    }

    @Test
    void jsonParser_parseArray_returnsCorrect() {
        //Arrange
        String toParse = "[Ford, BMW, Audi, Fiat]";
        //Act
        String parsedString = jsonParserOLD.parser(toParse);
        //Assert
        assertEquals("{ \"Parsed\": [ { \"stringValue1\": \"Ford\" },{ \"stringValue2\": \"BMW\" },{ \"stringValue3\": \"Something Testing\" },{ \"stringValue1\": \"Something Testing\" } ] }", parsedString);
    }


}
