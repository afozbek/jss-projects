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
    private boolean isThreadActive;

    public double getMoney() {
        return money;
    }

    private void setMoney(String operation, String amount) {

        amount = amount == null ? "0" : amount;
        operation = operation == null ? "WITHDRAW" : operation;

        double amount_ = Double.parseDouble(amount);

        switch (operation) {
            case "WITHDRAW":
                if (this.money < amount_) {
                    System.out.println("You dont have enough money");
                } else {
                    this.money -= amount_;
                }
                System.out.println("Money: $" + this.money);
                break;
            case "DEPOSIT":
                System.out.println("Okey we get your money now :)");
                this.money += amount_;
                System.out.println("Money: $" + this.money);
                break;
            default:
                return;
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Some exception when waiting thread");
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!this.isThreadActive) {
            System.out.println("Current thread is active");
            this.isThreadActive = true;
        } else {
            resp.getWriter().write("<h1>Current thread is using</h1>");
            return;
        }

        String operation = req.getParameter("operation");
        String amount = req.getParameter("amount");

        try {
            setMoney(operation, amount);
        } catch (Exception ex) {
            System.out.println("Cannot set money");
        } finally {
            this.isThreadActive = false;
        }
    }
}
