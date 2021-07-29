package homework5;

public class University {
    private String name;
    private int rank;

    public University(String name, int rank){
        this.name = name;
        this.rank = rank;
    }

    public String getName(){
        return name;
    }

    public void setRank(int rank){
        this.rank = rank;
    }

    public int getRank(){
        return rank;
    }
}
