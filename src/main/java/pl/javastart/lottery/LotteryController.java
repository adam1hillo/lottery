package pl.javastart.lottery;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

@WebServlet("/lottery")
public class LotteryController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (validateParameters(request)) {
            succesDispatch(request, response);
        } else {
            errorDispatch(request, response);
        }
    }

    private boolean validateParameters(HttpServletRequest request) {

        String[] numbers = request.getParameterValues("numbers");
        boolean isValid = true;
        try {
            Arrays.stream(numbers)
                    .forEach(Integer::valueOf);
        } catch (NumberFormatException nfe) {
            request.setAttribute("message", "Nie wprowadzono wszytkich liczb lub liczby są nieprawidłowe");
            isValid = false;
        }
        return isValid;
    }


    private void succesDispatch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Integer> userNumbers = getNumbers(request);
        LotteryResult lotteryResult = Lottery.getLotteryResult(userNumbers);
        request.setAttribute("result", lotteryResult);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/result.jsp");
        requestDispatcher.forward(request, response);
    }

    private  List<Integer> getNumbers(HttpServletRequest request) {
        return Arrays.stream(request.getParameterValues("numbers"))
                .map(Integer::valueOf)
                .toList();
    }

    private void errorDispatch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/error.jsp");
        requestDispatcher.forward(request, response);
    }
}
