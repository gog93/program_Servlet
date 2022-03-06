package model;


public class Result {

    private long id;

    private String explanation;

    private int minScore;

    private int maxScore;
    private Poll poll;

    public Result(long id, String explanation, int minScore, int maxScore, Poll poll) {
        this.id = id;
        this.explanation = explanation;
        this.minScore = minScore;
        this.maxScore = maxScore;
        this.poll = poll;
    }

    public Poll getPoll() {
        return poll;
    }

    public void setPoll(Poll poll) {
        this.poll = poll;
    }

    public Result(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public int getMinScore() {
        return minScore;
    }

    public void setMinScore(int minScore) {
        this.minScore = minScore;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }

    @Override
    public String toString() {
        return "Result{" +
                "id=" + id +
                ", explanation='" + explanation + '\'' +
                ", minScore=" + minScore +
                ", maxScore=" + maxScore +
                ", poll=" + poll +
                '}';
    }
}
