package service;


import model.Question;

import java.util.List;

public interface QuestionService extends Service<Question> {

    List<Question> findByPollId(long pollId);
}
