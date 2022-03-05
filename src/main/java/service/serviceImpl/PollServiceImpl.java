package service.serviceImpl;


import db.DBConnectionProvider;
import model.Answer;
import model.Poll;
import model.Question;
import service.QuestionService;
import service.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PollServiceImpl implements Service<Poll> {
    private Connection connection = DBConnectionProvider.getInstance().getConnection();


    @Override
    public List<Poll> findAll() {

        Poll poll=new Poll();
        QuestionServiceImpl question=new QuestionServiceImpl();
        String sql = "SELECT * from book_a_table";
        List<Poll> result = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                       poll.setId(resultSet.getInt(1));
                        poll.setName(resultSet.getString(2));
                        poll.setDescription(resultSet.getString(3));

                result.add(poll);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;    }

    @Override
    public Poll findById(long id) {
        Poll poll=new Poll();
        String sql = "SELECT * FROM book_A_Table WHERE id=" + id;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                poll.setId(resultSet.getInt(1));
//                poll.setQuestions(resultSet.getString(2));
//                poll.setResults(resultSet.getInt(3));
                poll.setName(resultSet.getString(4));
                return poll;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
