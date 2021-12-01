package as.nl.ff.test_ass_4.mockingFunctions;

public class ThingThatCanDoStuff {

    public int methodThatCanDoStuff(int inputThing){
        return inputThing + inputThing;
    }

    public String methodThatCanAlsoDoStuff(Person testPerson){
        return testPerson.getFirstName();
    }


    public void methodThatTriggerCyclomaticComplexityWarning(){
        if(true){
            if(true){
                if(true){
                    if(true){
                        if(true){
                            if(true){
                                if(true){
                                    if(true){
                                        if(true){
                                            if(true){
                                                if(true){

                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
