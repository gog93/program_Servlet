package service;


import model.Answer;
import model.Question;

import java.util.List;

public interface AnswerService extends Service<Answer> {

    List<Answer> findByQuestionId(long questionId);
}
