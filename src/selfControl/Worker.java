package selfControl;

public class Worker{
    private String name;
    private int age;
    private int degree;

    public Worker(){
        name = "";
        age = 0;
        degree = 0;
    }

    public Worker(String name, int age, int degree){
        this.name = name;
        this.age = age;
        this.degree = degree;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public int getDegree(){
        return degree;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setDegree(int degree){
        this.degree = degree;
    }

    @Override
    public String toString(){
        return "Worker " + name + ", age is " + age + ", has a degree " + degree;
    }

    @Override
    public int hashCode(){
        int num = 31;
        return (31 * age + degree) * 31 + (name == null ? 0 : name.hashCode());
    }

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o == null || o.getClass() != getClass()){
            return false;
        }
        Worker worker = (Worker) o;
        return name.equals(worker.name) && age == worker.age && degree == worker.degree;
    }
}
