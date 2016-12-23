package com.ice.simplebanksite.dao;

import com.ice.simplebanksite.model.Balance;
import com.ice.simplebanksite.model.Transactions;
import com.ice.simplebanksite.model.UserInfo;
import org.springframework.beans.factory.InitializingBean;

import java.util.List;

/**
 * Created by Bartek on 2016-12-19.
 */
public interface TransactionDAO {
    boolean createTransaction(Transactions transaction);

    Transactions getTransaction(int id);

    Balance getBalance(String userName);

    boolean changeTransactionStatus(String status);

    List<Transactions> getTransactionsList(String username);

    List<Transactions> getAllUsersTransactionsList();
}
