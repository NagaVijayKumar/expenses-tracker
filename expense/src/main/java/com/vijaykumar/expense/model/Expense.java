package com.vijaykumar.expense.model;

import com.vijaykumar.expense.enums.PaymentMode;
import org.springframework.data.annotation.Id;

public class Expense {

    @Id
    private String email;
    private long amount;
    private String reason;
    private PaymentMode paymentMode;

    private long createdTime;

    public Expense() {
    }

    public Expense(String email, long amount, String reason, PaymentMode paymentMode, long createdTime) {
        this.email = email;
        this.amount = amount;
        this.reason = reason;
        this.paymentMode = paymentMode;
        this.createdTime = createdTime;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    public long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(long createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "email='" + email + '\'' +
                ", amount=" + amount +
                ", reason='" + reason + '\'' +
                ", paymentMode=" + paymentMode +
                ", createdTime=" + createdTime +
                '}';
    }
}
