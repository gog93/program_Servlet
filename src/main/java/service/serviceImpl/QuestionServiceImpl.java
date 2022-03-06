package service.serviceImpl;


import db.DBConnectionProvider;
import model.Question;
import service.QuestionService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class QuestionServiceImpl implements QuestionService {
    private Connection connection = DBConnectionProvider.getInstance().getConnection();
    private PollServiceImpl pollService = new PollServiceImpl();
    private Question question = new Question();


    @Override
    public List<Question> findAll() {
        String sql = "SELECT * from question";
        List<Question> result = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                question.setId(resultSet.getInt(1));
                question.setText(resultSet.getString(2));
                question.setPoll(pollService.findById(resultSet.getInt(3)));

                result.add(question);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    @Override
    public Question findById(long id) {
        String sql = "SELECT * FROM question WHERE id=" + id;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                question.setId(resultSet.getInt(1));
                question.setText(resultSet.getString(2));
                question.setPoll(pollService.findById(resultSet.getInt(3)));

                return question;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Question> findByPollId(long pollId) {

        String sql = "SELECT * FROM question WHERE poll_id=" + pollId;
        List<Question> result = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                question.setId(resultSet.getInt(1));
                question.setText(resultSet.getString(2));
                question.setPoll(pollService.findById(resultSet.getInt(3)));
                result.add(question);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
}

