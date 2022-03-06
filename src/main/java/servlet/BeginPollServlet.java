package servlet;

import model.Answer;
import model.Question;
import service.serviceImpl.AnswerServiceImpl;
import service.serviceImpl.QuestionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/beginPoll")

public class BeginPollServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AnswerServiceImpl answerService=new AnswerServiceImpl();
        QuestionServiceImpl questionService=new QuestionServiceImpl();
        List<Answer> answers=answerService.findAll();
        List<Question> questions=questionService.findAll();
        req.setAttribute("answers",answers);
        req.setAttribute("question",questions);
        req.getRequestDispatcher("result.jsp").forward(req,resp);
    }
}
