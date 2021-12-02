package as.nl.ff.test_ass_4.json_parser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
@Tag("UnitTest")
@DisplayName("Parse Student Object To Json String")
public class JSONParserConvertObjectToString {

    @Test
    public void parseStudent_AllFieldsExpectArray_returnSuccessfulJsonString(){
        //Arrange
        Student student = new Student(1, "Nina", 2.5f, true, 'c', null);
        String expected = "{'id':1,'name':'Nina','avgGrade':2.5,'activeStudent':true,'classCode':'c'}";
        ParserJSON parserjson = new ParserJSON();

        //Act
        String resultJsonString = parserjson.parseStudent(student);


        //Assert
        assertEquals(expected,resultJsonString);
    }

    @Test
    public void parseStudent_AllFields_returnSuccessfulJsonString(){
        //Arrange
        Student student = new Student(1, "Nina", 2.5f, true, 'c', new int[]{2,4,12,0,7});
        String expected = "{'id':1,'name':'Nina','avgGrade':2.5,'activeStudent':true,'classCode':'c','grades':[2, 4, 12, 0, 7]}";
        ParserJSON parserjson = new ParserJSON();

        //Act
        String resultJsonString = parserjson.parseStudent(student);


        //Assert
        assertEquals(expected,resultJsonString);
    }

    @Test
    public void parseStudent_SomeFieldsAreEmpty_returnSuccessfulJsonString(){
        //Arrange
        Student student = new Student(1, "", 2.5f, true, 'c', null);
        String expected = "{'id':1,'avgGrade':2.5,'activeStudent':true,'classCode':'c'}";
        ParserJSON parserjson = new ParserJSON();

        //Act
        String resultJsonString = parserjson.parseStudent(student);


        //Assert
        assertEquals(expected,resultJsonString);
    }


    @Test
    public void parseStudent_NullStudentObjectParsed_returnException(){
        // Arrange
        Student student = null;
        ParserJSON parserjson = new ParserJSON();

        // Act
        Assertions.assertThrows(JsonParserException.class, () -> {
            parserjson.parseStudent(student);
        });
    }

}
