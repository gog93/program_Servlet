package service.serviceImpl;

import db.DBConnectionProvider;
import model.Answer;
import service.AnswerService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class AnswerServiceImpl implements AnswerService {
    private Connection connection = DBConnectionProvider.getInstance().getConnection();


    @Override
    public List<Answer> findAll() {
        Answer answer=new Answer();
        String sql = "SELECT * from book_a_table";
        List<Answer> result = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                        answer.setId(resultSet.getInt(1));
                        answer.setText(resultSet.getString(2));
                        answer.setWeight(resultSet.getInt(3));

                result.add(answer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    @Override
    public Answer findById(long id) {
        Answer answer=new Answer();
        String sql = "SELECT * FROM book_A_Table WHERE id=" + id;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
              answer.setId(resultSet.getInt(1));
              answer.setText(resultSet.getString(2));
              answer.setWeight(resultSet.getInt(3));
              return answer;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;

    }

    @Override
    public List<Answer> findByQuestionId(long questionId) {
        return null;
    }
}
