package model;

public class Trainer {
    String age;
    String weight;
    String height;

    public Trainer(String age, String weight, String height) {
        this.age = age;
        this.weight = weight;
        this.height = height;
    }

    public String getAge() {
        return age;
    }

    public String getWeight() {
        return weight;
    }

    public String getHeight() {
        return height;
    }
}
