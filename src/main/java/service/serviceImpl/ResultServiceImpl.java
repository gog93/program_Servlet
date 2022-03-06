package service.serviceImpl;


import db.DBConnectionProvider;
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
    private PollServiceImpl pollService = new PollServiceImpl();
    private Result res = new Result();

    @Override
    public List<Result> findAll() {
        String sql = "SELECT * from res";
        List<Result> resultList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                res.setId(resultSet.getInt(1));
                res.setExplanation(resultSet.getString(2));
                res.setMaxScore(resultSet.getInt(3));
                res.setMaxScore(resultSet.getInt(4));
                resultList.add(res);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultList;
    }

    @Override
    public Result findById(long id) {
        Result result = new Result();
        String sql = "SELECT * FROM res WHERE id=" + id;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                result.setId(resultSet.getInt(1));
                result.setExplanation(resultSet.getString(2));
                result.setMinScore(resultSet.getInt(3));
                result.setMaxScore(resultSet.getInt(4));
                result.setPoll(pollService.findById(resultSet.getInt(3)));

                return result;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;

    }

    @Override
    public List<Result> findByPollId(long pollId) {

        String sql = "SELECT * FROM res WHERE poll_id=" + pollId;
        List<Result> result = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                res.setId(resultSet.getInt(1));
                res.setExplanation(resultSet.getString(2));
                res.setMinScore(resultSet.getInt(3));
                res.setMaxScore(resultSet.getInt(4));
                res.setPoll(pollService.findById(resultSet.getInt(5)));
                result.add(res);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    @Override
    public Result findByScore(int maxScore, int minScore) {
        String sql = "SELECT * FROM res WHERE min_Score='" + minScore + "' and max_Score = '" + maxScore + "'";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                res.setId(resultSet.getInt(1));
                res.setExplanation(resultSet.getString(2));
                res.setMinScore(resultSet.getInt(3));
                res.setMaxScore(resultSet.getInt(4));
                res.setPoll(pollService.findById(resultSet.getInt(5)));
                return res;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;

    }
}