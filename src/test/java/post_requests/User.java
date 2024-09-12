package post_requests;

public class User {
    private String name;
    private String job;
    private int age;

    public User(String name, String job, int age){
        this.name = name;
        this.job = job;
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getJob() {
        return job;
    }
}
