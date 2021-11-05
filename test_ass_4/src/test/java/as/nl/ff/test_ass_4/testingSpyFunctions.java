package as.nl.ff.test_ass_4;

import as.nl.ff.test_ass_4.controller.Person;
import as.nl.ff.test_ass_4.controller.ThingThatCanDoStuff;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)

public class testingSpyFunctions {

    @Spy
    ThingThatCanDoStuff thingThatCanDoStuff;


    //1. This test shows how we can verify that our "thingThatCanDoStuff" method "methodThatCanDoStuff"
    // was called and with the expected argument
    @Test
    void testHowToVerifySpyWasCalled (){
        int result = thingThatCanDoStuff.methodThatCanDoStuff(1);

        //Verify that the spy was called
        Mockito.verify(thingThatCanDoStuff).methodThatCanDoStuff(1);

        assertEquals(result, 2);
    }

    //2. This test shows how we can verify that our "thingThatCanDoStuff" method "methodThatCanDoStuff"
    // was not called with argument 2 however it was called with argument of 1
    // We Do this by adding the mockito.never() verification.
    @Test
    void testHowToVerifySpyWasNotCalled (){
        int result = thingThatCanDoStuff.methodThatCanDoStuff(1);

        //Verify that the spy was called with argument 1
        Mockito.verify(thingThatCanDoStuff).methodThatCanDoStuff(1);
        //Verify that the spy was not called with argument 2
        Mockito.verify(thingThatCanDoStuff, Mockito.never()).methodThatCanDoStuff(2);

        assertEquals(result, 2);
    }

    //3. This test shows how we can verify that our "thingThatCanDoStuff" method "methodThatCanDoStuff"
    // was called x amount of times and with the expected argument
    @Test
    void testHowToVerifySpyWasCalledXAmountOfTimes (){
        int result1 = thingThatCanDoStuff.methodThatCanDoStuff(1);
        int result2 = thingThatCanDoStuff.methodThatCanDoStuff(1);
        int result3 = thingThatCanDoStuff.methodThatCanDoStuff(1);
        int result4 = thingThatCanDoStuff.methodThatCanDoStuff(2);

        //Verify that the spy was called x amount of times.
        Mockito.verify(thingThatCanDoStuff, Mockito.atLeast(3)).methodThatCanDoStuff(1);

        assertEquals(result1, 2);
        assertEquals(result2, 2);
        assertEquals(result3, 2);
        assertEquals(result4, 4);
    }

    //4. This test shows how we can verify that our "thingThatCanDoStuff" method "methodThatCanDoStuff"
    // was called with specific argument 1
    @Test
    void testHowToVerifySpyWasCalledWithSpecificArgument (){
        int result1 = thingThatCanDoStuff.methodThatCanDoStuff(1);
        int result2 = thingThatCanDoStuff.methodThatCanDoStuff(2);
        int result3 = thingThatCanDoStuff.methodThatCanDoStuff(3);
        int result4 = thingThatCanDoStuff.methodThatCanDoStuff(4);

        //Verify that the spy was called with specific argument.
        Mockito.verify(thingThatCanDoStuff).methodThatCanDoStuff(1);

        assertEquals(result1, 2);
        assertEquals(result2, 2);
        assertEquals(result3, 2);
        assertEquals(result4, 4);


    }

    //5. This test shows how we can verify properties of arguments passed in a method call
    @Test
    void testVerifyPropertiesOfArgumentWhenMockIsCalled (){

        Person testPerson = new Person("Allan");

        Mockito.doReturn("Allan")
                .when(thingThatCanDoStuff)
                .methodThatCanAlsoDoStuff(Mockito.argThat(person -> person.getFirstName() == testPerson.getFirstName()));

    }



}

