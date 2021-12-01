package as.nl.ff.test_ass_4.json_parser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JSONParserConvertObjectToString {

    @Test
    public void convertObjectToJsonStringWithAllFields(){
        //Arrange
        Student student = new Student(1, "Nina", 2.5f, true, 'c');
        String expected = "{'id':1,'name':'Nina','avgGrade':2.5,'activeStudent':true,'classCode':'c'}";
        ParserJSON parserjson = new ParserJSON();

        //Act
        String resultJsonString = parserjson.parseStudent(student);


        //Assert
        assertEquals(expected,resultJsonString);
    }

    @Test
    public void convertObjectToJsonStringWithMissingField(){
        //Arrange
        Student student = new Student(1, "", 2.5f, true, 'c');
        String expected = "{'id':1,'avgGrade':2.5,'activeStudent':true,'classCode':'c'}";
        ParserJSON parserjson = new ParserJSON();

        //Act
        String resultJsonString = parserjson.parseStudent(student);


        //Assert
        assertEquals(expected,resultJsonString);
    }

    @Test
    public void convertStudentObjectToJsonStringReturnException(){
        // Arrange
        String jsonString = "{'id':1,'name':'Nina','activeStudent': true,'classCode': 'c'";
        ParserJSON parserjson = new ParserJSON();

        // Act
        Assertions.assertThrows(JsonParserException.class, () -> {
            parserjson.parseString(jsonString);
        });
    }

}
