package models;

public class Person {
    private int personId;
    private String firstname;
    private String lastname;
    private int age;

    public Person(int personId, String firstname, String lastname, int age) {
        this.personId = personId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }

    public int getId() {
        return personId;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getAge() {
        return age;
    }
}

