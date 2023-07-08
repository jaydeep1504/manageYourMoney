package com.app.manageYourMoney.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.sql.Date;

@Entity
@Table(name = "EXPENSE_DETAILS")
public class ExpenseDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EXPENSE_ID")
    private int expenseId;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private UserDetails userDetails;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    private ItemDetails itemDetails;

    @Column(name = "EXPENSE_NAME")
    private String expenseName;

    @Column(name = "EXPENSE_DESCRIPTION")
    private String expenseDesc;
    @Column(name = "EXPENSE_TYPE")
    private String expenseType;

    @Column(name = "TRANSACTION_DATE")
    private Date transactioDate;

    public int getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(int expenseId) {
        this.expenseId = expenseId;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public String getExpenseDesc() {
        return expenseDesc;
    }

    public void setExpenseDesc(String expenseDesc) {
        this.expenseDesc = expenseDesc;
    }

    public String getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(String expenseType) {
        this.expenseType = expenseType;
    }

    public Date getTransactioDate() {
        return transactioDate;
    }

    public void setTransactioDate(Date transactioDate) {
        this.transactioDate = transactioDate;
    }

    @Override
    public String toString() {
        return "ExpenseDetails{" +
                "expenseId=" + expenseId +
                ", expenseName='" + expenseName + '\'' +
                ", expenseDesc='" + expenseDesc + '\'' +
                ", expenseType='" + expenseType + '\'' +
                ", transactioDate=" + transactioDate +
                '}';
    }
}
