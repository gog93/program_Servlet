package model;


public class Answer {

    private long id;

    private String text;

    private int weight;
    private Question questionId;

    public Question getQuestionId(Question byId) {
        return questionId;
    }

    public void setQuestionId(Question questionId) {
        this.questionId = questionId;
    }


    public Answer() {
    }


    public Answer(long id, String text, int weight, Question questionId) {
        this.id = id;
        this.text = text;
        this.weight = weight;
        this.questionId = questionId;
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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", weight=" + weight +
                ", questionId=" + questionId +
                '}';
    }
}
