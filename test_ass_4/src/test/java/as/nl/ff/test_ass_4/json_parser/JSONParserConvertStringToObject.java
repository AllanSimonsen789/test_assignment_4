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
    public void parseStudent_OneFieldeInJsonStringMissing_returnSuccessfulStudentObject(){
        //Arrange
        Student expected = new Student(1, "Nina", 2.5f, true, 'c', null);
        String jsonString = "{'id':1,'name':'Nina','avgGrade': 2.5,'activeStudent': true,'classCode': 'c' }";
        ParserJSON parserjson = new ParserJSON();

        //Act
        Student resultObject = parserjson.parseString(jsonString);


        //Assert
        assertEquals(expected,resultObject);
    }

    @Test
    public void parseStudent_MultipleFieldsInJsonStringMissing_returnSuccessfulStudentObject(){
        //Arrange
        Student expected = new Student(1, "Nina", 0.0f, true, 'c', null);
        String jsonString = "{'id':1,'name':'Nina','activeStudent': true,'classCode': 'c' }";
        ParserJSON parserjson = new ParserJSON();

        //Act
        Student resultObject = parserjson.parseString(jsonString);


        //Assert
        assertEquals(expected,resultObject);
    }

    @Test
    public void parseStudent_emptyJsonString_returnSuccessfulEmptyStudentObject(){
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
    public void parseStudent_allFieldsInJsonString_returnSuccessfulStudentObject(){

        //Arrange
        Student expected = new Student(1, "Nina", 2.5f, true, 'c', new int[]{2,4,12,7,10});
        String jsonString = "{'id':1,'name':'Nina','avgGrade': 2.5,'activeStudent': true,'classCode': 'c','grades':[2,4,12,7,10]}";
        ParserJSON parserjson = new ParserJSON();

        //Act
        Student resultObject = parserjson.parseString(jsonString);

        System.out.println(expected);
        //Assert
        assertEquals(expected,resultObject);
    }

    @Test
    public void parseStudent_RearrangedFieldsInJsonString_returnSuccessfulStudentObject(){

        //Arrange
        Student expected = new Student(1, "Nina", 2.5f, true, 'c', new int[]{2,4,12,0,7});
        String jsonString = "{'avgGrade': 2.5,'activeStudent': true,'grades':[2,4,12,0,7],'classCode': 'c','id':1,'name':'Nina'}";
        ParserJSON parserjson = new ParserJSON();

        //Act
        Student resultObject = parserjson.parseString(jsonString);

        System.out.println(expected);
        //Assert
        assertEquals(expected,resultObject);
    }

    @Test
    public void parseStudent_MalformedJsonString_returnException(){
        // Arrange
        String jsonString = "{'id':1,'name':'Nina','activeStudent': true,'classCode': 'c'";
        ParserJSON parserjson = new ParserJSON();

        // Act
        Assertions.assertThrows(JsonParserException.class, () -> {
            parserjson.parseString(jsonString);
        });
    }


}
