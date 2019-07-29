package servlets.training;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AtmServlet")
public class AtmServlet extends HttpServlet {
    private double money;
    private Object lock = new Object();


    public double getMoney() {
        return money;
    }

    private void setMoney(String operation, String amount) {

        amount = amount == null ? "0" : amount;
        operation = operation == null ? "WITHDRAW" : operation;

        double newAmount = Double.parseDouble(amount);

        switch (operation) {
            case "WITHDRAW":
                if (this.money < newAmount) {
                    System.out.println("You dont have enough money");
                } else {
                    synchronized (lock) {
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            System.out.println("Thread cant be waited");
                        }
                        this.money -= newAmount;
                    }
                }
                System.out.println("Money: $" + this.money);
                break;
            case "DEPOSIT":
                System.out.println("Okey we get your money now :)");
                this.money += newAmount;
                System.out.println("Money: $" + this.money);
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("atm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String operation = req.getParameter("operation");
        String amount = req.getParameter("amount");

        System.out.println("Your operation: " + operation);
        System.out.println("Your amount: " + amount);

        try {
            setMoney(operation, amount);
        } catch (Exception ex) {
            System.out.println("Cannot set money");
        } finally {
            resp.getWriter().write("You have: $" + this.money);
        }
    }
}
