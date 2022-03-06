package model;

public class Question {

    private long id;

    private String text;
    private Poll poll;


    public Poll getPoll() {
        return poll;
    }

    public void setPoll(Poll poll) {
        this.poll = poll;
    }



    public Question() {
    }

    public Question(long id, String text, Poll poll) {
        this.id = id;
        this.text = text;
        this.poll = poll;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", poll=" + poll +
                '}';
    }
}
