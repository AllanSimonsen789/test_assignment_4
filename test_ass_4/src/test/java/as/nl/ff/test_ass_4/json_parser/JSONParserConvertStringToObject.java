package as.nl.ff.test_ass_4.json_parser;

import net.minidev.json.parser.JSONParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static java.util.Objects.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("UnitTest")
public class JSONParserConvertStringToObject {

    @Test
    public void convertJSONStringToStudentObjectWithAllFields(){
        //Arrange
        Student expected = new Student(1, "Nina", 2.5f, true, 'c');
        String jsonString = "{'id':1,'name':'Nina', 'avgGrade': 2.5,'activeStudent': true,'classCode': 'c' }";
        ParserJSON parserjson = new ParserJSON();

        //Act
        Student resultObject = parserjson.parseString(jsonString);


        //Assert
        assertEquals(expected,resultObject);
    }

    @Test
    public void convertJSONStringToStudentObjectWithOneMissingField(){
        //Arrange
        Student expected = new Student(1, "Nina", 0.0f, true, 'c');
        String jsonString = "{'id':1,'name':'Nina','activeStudent': true,'classCode': 'c' }";
        ParserJSON parserjson = new ParserJSON();

        //Act
        Student resultObject = parserjson.parseString(jsonString);


        //Assert
        assertEquals(expected,resultObject);
    }

    @Test
    public void convertJSONStringToStudentObjectWithAllFieldsMissing(){
        //Arrange
        Student expected = new Student();
        String jsonString = "{}";
        ParserJSON parserjson = new ParserJSON();

        //Act
        Student resultObject = parserjson.parseString(jsonString);

        //Assert
        assertTrue(Objects.equals(expected, resultObject));
    }

    @Test
    public void convertJSONStringToStudentReturnException(){
        // Arrange
        Student student = null;
        ParserJSON parserjson = new ParserJSON();

        // Act
        Assertions.assertThrows(JsonParserException.class, () -> {
            parserjson.parseStudent(student);
        });
    }


}
