package as.nl.ff.test_ass_4;

import as.nl.ff.test_ass_4.controller.ThingThatCanDoStuff;
import as.nl.ff.test_ass_4.controller.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)

public class testingSpyFunctionsTest {

    @Spy
    ThingThatCanDoStuff thingThatCanDoStuff;

    @Mock
    ThingThatCanDoStuff alsoAThingThatCanDoStuff;


    //1. This test shows how we can verify that our "thingThatCanDoStuff" method "methodThatCanDoStuff"
    // was called and with the expected argument
    //using Spy
    @Test
    void testHowToVerifySpyWasCalled (){
        int result = thingThatCanDoStuff.methodThatCanDoStuff(1);

        //Verify that the spy was called
        Mockito.verify(thingThatCanDoStuff).methodThatCanDoStuff(1);

        assertEquals(result, 2);
    }
    //using mock
    @Test
    void testHowToVerifyMockWasCalled (){
        alsoAThingThatCanDoStuff.methodThatCanDoStuff(1);

        //Verify that the spy was called
        Mockito.verify(alsoAThingThatCanDoStuff).methodThatCanDoStuff(1);

    }

    //2. This test shows how we can verify that our "thingThatCanDoStuff" method "methodThatCanDoStuff"
    // was not called with argument 2 however it was called with argument of 1
    // We Do this by adding the mockito.never() verification.
    //spy
    @Test
    void testHowToVerifySpyWasNotCalled (){
        int result = thingThatCanDoStuff.methodThatCanDoStuff(1);

        //Verify that the spy was called with argument 1
        Mockito.verify(thingThatCanDoStuff).methodThatCanDoStuff(1);
        //Verify that the spy was not called with argument 2
        Mockito.verify(thingThatCanDoStuff, Mockito.never()).methodThatCanDoStuff(2);

        assertEquals(result, 2);
    }
    //mock
    @Test
    void testHowToVerifyMockWasNotCalled (){
        alsoAThingThatCanDoStuff.methodThatCanDoStuff(1);

        //Verify that the mock was called with argument 1
        Mockito.verify(alsoAThingThatCanDoStuff).methodThatCanDoStuff(1);
        //Verify that the spy was not called with argument 2
        Mockito.verify(alsoAThingThatCanDoStuff, Mockito.never()).methodThatCanDoStuff(2);

    }

    //3. This test shows how we can verify that our "thingThatCanDoStuff" method "methodThatCanDoStuff"
    // was called x amount of times and with the expected argument
    //Spy
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
    //Mock
    void testHowToVerifyMockWasCalledXAmountOfTimes (){
        alsoAThingThatCanDoStuff.methodThatCanDoStuff(1);
        alsoAThingThatCanDoStuff.methodThatCanDoStuff(1);
        alsoAThingThatCanDoStuff.methodThatCanDoStuff(1);
        alsoAThingThatCanDoStuff.methodThatCanDoStuff(2);

        //Verify that the spy was called x amount of times.
        Mockito.verify(alsoAThingThatCanDoStuff, Mockito.atLeast(3)).methodThatCanDoStuff(1);

    }

    //4. This test shows how we can verify that our "thingThatCanDoStuff" method "methodThatCanDoStuff"
    // was called with specific argument 1
    //Spy
    @Test
    void testHowToVerifySpyWasCalledWithSpecificArgument (){
        int result1 = thingThatCanDoStuff.methodThatCanDoStuff(1);
        int result2 = thingThatCanDoStuff.methodThatCanDoStuff(2);
        int result3 = thingThatCanDoStuff.methodThatCanDoStuff(3);
        int result4 = thingThatCanDoStuff.methodThatCanDoStuff(4);

        //Verify that the spy was called with specific argument.
        Mockito.verify(thingThatCanDoStuff).methodThatCanDoStuff(1);

        assertEquals(result1, 2);
        assertEquals(result2, 4);
        assertEquals(result3, 6);
        assertEquals(result4, 8);
    }
    //mock
    @Test
    void testHowToVerifyMockWasCalledWithSpecificArgument (){
        int result1 = alsoAThingThatCanDoStuff.methodThatCanDoStuff(1);
        int result2 = alsoAThingThatCanDoStuff.methodThatCanDoStuff(2);
        int result3 = alsoAThingThatCanDoStuff.methodThatCanDoStuff(3);
        int result4 = alsoAThingThatCanDoStuff.methodThatCanDoStuff(4);

        //Verify that the spy was called with specific argument.
        Mockito.verify(alsoAThingThatCanDoStuff).methodThatCanDoStuff(1);

    }


    //5. This test shows how we can verify properties of arguments passed in a method call
    @Test
    void testVerifyPropertiesOfArgumentWhenMockIsCalled (){
        ThingThatCanDoStuff anotherThingThatCanDoStuff = Mockito.mock(ThingThatCanDoStuff.class);
        Person anotherTestPerson = Mockito.mock(Person.class);
        Mockito.when(anotherTestPerson.getFirstName()).thenReturn("Allan");

        anotherThingThatCanDoStuff.methodThatCanAlsoDoStuff(anotherTestPerson);

        Mockito.verify(anotherThingThatCanDoStuff).methodThatCanAlsoDoStuff(Mockito.argThat((Person aBar) -> aBar.getFirstName().equals("Allan")));

    }






}

