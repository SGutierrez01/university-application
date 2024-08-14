package models;

public abstract class Person {
    private int personId;
    private String personFirstname;
    private String personLastname;
    private int personAge;

    public Person(int personId, String personFirstname, String personLastname, int personAge) {
        this.personId = personId;
        this.personFirstname = personFirstname;
        this.personLastname = personLastname;
        this.personAge = personAge;
    }

    public int getId() {
        return personId;
    }

    public String getFirstname() {
        return personFirstname;
    }

    public String getLastname() {
        return personLastname;
    }

    public int getAge() {
        return personAge;
    }
}

