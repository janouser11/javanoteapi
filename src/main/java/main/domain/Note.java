package main.domain;


import java.io.Serializable;

public class Note implements Serializable {

    private int Id;
    private String Body;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getBody() {
        return Body;
    }

    public void setBody(String body) {
        Body = body;
    }
}
