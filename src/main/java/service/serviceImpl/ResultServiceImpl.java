package service.serviceImpl;


import db.DBConnectionProvider;
import model.Answer;
import model.Result;
import service.ResultService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ResultServiceImpl implements ResultService {
    private Connection connection = DBConnectionProvider.getInstance().getConnection();

    @Override
    public List<Result> findAll() {
        Result result = new Result();
        String sql = "SELECT * from book_a_table";
        List<Result> resultList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                result.setId(resultSet.getInt(1));
                result.setExplanation(resultSet.getString(2));
                result.setMaxScore(resultSet.getInt(3));
                result.setMaxScore(resultSet.getInt(4));
                resultList.add(result);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultList;
    }

    @Override
    public Result findById(long id) {
        Result answer=new Result();
        String sql = "SELECT * FROM book_A_Table WHERE id=" + id;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                answer.setId(resultSet.getInt(1));
//                answer.setMaxScore(resultSet.getString(2));
//                answer.setExplanation(resultSet.getInt(3));
                answer.setMinScore(resultSet.getInt(3));
                return answer;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;

    }

    @Override
    public List<Result> findByPollId(long pollId) {
        return null;
    }

    @Override
    public Result findByScore(long pollId, int score) {
        return null;
    }
}
