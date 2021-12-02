package as.nl.ff.test_ass_4.json_parser;

import org.springframework.boot.json.JsonParser;

import java.util.Arrays;


public class ParserJSON {
    public Student parseString(String jsonString) {
        if(jsonString.charAt(0) == '{' && jsonString.charAt(jsonString.length()-1) == '}'){
            String[] valuepairs = jsonString.substring(1, jsonString.length()-1).split(",'");
            Student returnStudent = new Student();
            for (String s : valuepairs) {
                if(s.contains("id")){
                    String[] splitString = s.split(":");
                    String idString = splitString[1];
                    int id = Integer.parseInt(idString);
                    returnStudent.setId(id);
                } else if (s.contains("name")) {
                    String[] splitString = s.split(":");
                    String nameString = splitString[1];
                    returnStudent.setName(nameString.substring(1, nameString.length()-1));
                }else if(s.contains("avgGrade")){
                    String[] splitString = s.split(":");
                    String avgGradeString = splitString[1];
                    Float avgGrade = Float.parseFloat(avgGradeString);
                    returnStudent.setAvgGrade(avgGrade);
                }else if(s.contains("activeStudent")){
                    String[] splitString = s.split(":");
                    String activeStudentString = splitString[1];
                    boolean activeStudent = Boolean.parseBoolean(activeStudentString.trim());
                    returnStudent.setActiveStudent(activeStudent);
                }else if(s.contains("classCode")){
                    String[] splitString = s.split(":");
                    String classCodeString = splitString[1];
                    returnStudent.setClassCode(classCodeString.trim().charAt(1));
                }else if(s.contains("grades")){
                    String[] splitString = s.split(":");
                    String[] integersStringformat = splitString[1].substring(1, splitString[1].length()-1).split(",");
                    int[] integers = new int[integersStringformat.length];
                    for (int i = 0; i < integersStringformat.length; i++) {
                        integers[i] = Integer.parseInt(integersStringformat[i].trim());
                    }
                    returnStudent.setGrades(integers);
                }
            }

            return returnStudent;
        }else{
            throw new JsonParserException("invalid Json format");
        }
    }

    public String parseStudent(Student student) {
        if(student == null) throw new JsonParserException("Object Cannot be null");
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if(student.getId() > 0){
            sb.append("'id':"+student.getId()+",");
        }
        if(!student.getName().isEmpty()){
            sb.append(("'name':'"+student.getName()+"',"));
        }
        if(student.getAvgGrade() > 0.0f){
            sb.append(("'avgGrade':"+student.getAvgGrade()+","));
        }
        if(student.isActiveStudent() || !student.isActiveStudent()){
            sb.append(("'activeStudent':"+student.isActiveStudent()+","));
        }
        if(Character.isLetter(student.getClassCode())){
            sb.append(("'classCode':'"+student.getClassCode()+"',"));
        }
        if(student.getGrades() != null && student.getGrades().length > 0){
            sb.append(("'grades':"+Arrays.toString(student.getGrades())+","));
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("}");
        return sb.toString();
    }
}
