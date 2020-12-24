package edu.ant.patterns.basic.annotation;

public class Record {

    @Member
    private long id;
    @Member
    private String input;

    public Record() {}

    public Record(long id) {
        this.id = id;
        this.input = "empty input";
    }

    public Record(@Param("id") long id, @Param("txt") String input) {
        this.id = id;
        this.input = input;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
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
