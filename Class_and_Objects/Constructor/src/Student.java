public class Student{
    String name;
    int age;
    char gender;
    boolean isScienceDept;
    Student(String na)
    {
        if(na == "")
            System.out.println("Construct" +
                    "is Blank");
        name = na;
    }
}

