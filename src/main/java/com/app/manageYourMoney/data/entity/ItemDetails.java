package com.app.manageYourMoney.data.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ITEM_DETAILS")
public class ItemDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ITEM_ID")
    private int itemId;
    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;
    @Column(name = "ITEM_NAME")
    private String itemName;

    @Column(name = "ITEM_DESCRIPTION")
    private String itemDesc;

    @OneToMany(mappedBy = "itemDetails")
    private Set<ExpenseDetails> expenseDetails=new HashSet<>();

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    @Override
    public String toString() {
        return "ItemDetails{" +
                "itemId=" + itemId +
                ", category=" + category +
                ", itemName='" + itemName + '\'' +
                ", itemDesc='" + itemDesc + '\'' +
                '}';
    }
}
