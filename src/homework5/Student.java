package homework5;

public class Student {
    private String name;
    private final int age;
    private University university;

    public Student(String name, int age, University university){
        this.name = name;
        this.age = age;
        this.university = new University(university.getName(), university.getRank());
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public University getUniversity(){
        return new University(university.getName(), university.getRank());
    }

    public Student setName(String name){
        return new Student(name,age,university);
    }

    public Student setAge(int age){
        return new Student(name,age,university);
    }

    public Student setUniversity(University university){
        return new Student(name, age, university);
    }

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }

        if(o == null || o.getClass() != getClass()){
            return false;
        }

        Student student = (Student) o;

        return name.equals(student.name) && age == student.age;
    }

    @Override
    public int hashCode(){
        int num = 31;
        return 31 * age + (name == null ? 0 : name.hashCode());
    }
}
