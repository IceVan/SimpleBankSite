package com.ice.simplebanksite.mapper;



import com.ice.simplebanksite.model.Transactions;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Bartek on 2016-12-19.
 */
public class TransactionMapper implements RowMapper {

    @Override
    public Transactions mapRow(ResultSet rs, int rowNum) throws SQLException {

        Transactions transaction = new Transactions();
        transaction.setUser(rs.getString("Username"));
        transaction.setAccountAddress(rs.getString("Address"));
        transaction.setStatus(rs.getInt("Transaction_Status"));
        transaction.setAmount(rs.getFloat("Amount"));
        transaction.setDescription(rs.getString("Description"));
        transaction.setTransID(rs.getInt("Transaction_ID"));

        return transaction;
    }
}
