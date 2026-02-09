package practice;



class People {
    private String name;
    private  Integer age;
    private String id;


    public void setName(String name){ // setter
        this.name = name ;
    }



    public String getName(){ // getter
        return this.name;
    }
}


class Student extends People {

    public Student(){
        super();
    }
}


interface School { // abstract
    void Teacher();
}


abstract class Parents { // abstract
    abstract void name();
}

public class Task {
     private String name; // hidden data it's call encapsulation
     private Integer age;

    void study(){
        System.out.println(name + "is studying");
    }

    static void main() {
//        Task task  = new Task(); // create object
//
//        task.name = "Ratana";
//
//        task.study();


        Student student = new Student();
    }

}
