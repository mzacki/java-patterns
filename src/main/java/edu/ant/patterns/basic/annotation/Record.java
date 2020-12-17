package edu.ant.patterns.basic.annotation;

public class Record {

    @Member
    private long id;
    @Member
    private String input;

    public Record(@Param("id") long id, @Param("txt") String input) {
        this.id = id;
        this.input = input;
    }


    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", input='" + input + '\'' +
                '}';
    }
}
