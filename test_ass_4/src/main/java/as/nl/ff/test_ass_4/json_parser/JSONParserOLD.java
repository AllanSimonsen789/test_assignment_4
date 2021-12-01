package as.nl.ff.test_ass_4.json_parser;

import netscape.javascript.JSObject;

public class JSONParserOLD {
    public String parser(String toParse) {
        /*
        {
  "student": [

     {
        "id":"01",
        "name": "Tom",
        "lastname": "Price"
     },

     {
        "id":"02",
        "name": "Nick",
        "lastname": "Thameson"
     }
  ]
}
         */


        String finalString = "{ \"Parsed\": [ { \"stringValue1\": \"" + toParse + "\" } ] }";
        return finalString;
    }
}
