package service;


import model.Result;

import java.util.List;

public interface ResultService extends Service<Result> {

    List<Result> findByPollId(long pollId);

    Result findByScore(long pollId, int score);
}
