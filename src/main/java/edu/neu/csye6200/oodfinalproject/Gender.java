package edu.neu.csye6200.oodfinalproject;

public enum Gender {
    MALE("Male"),
    FEMALE("Female"),
    OTHER("Other");

    private String value;

    private Gender(String value){
        this.value=value;
    }
    public String getValue() {
        return value;
    }
    @Override
    public String toString(){
        return value;
    }
}
