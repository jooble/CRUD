package ru.jooble.dao;


import ru.jooble.domain.Currency;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class CurrencyDaoJdbcImpl implements CurrencyDao {
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String INSERT_CRURRENCY = "INSERT INTO currency (name) VALUES (?)";
    public static final String SELECT_FROM_ALL_CURRENCY = "SELECT * FROM currency";
    private ConnectionFactory connectionFactory;

    public CurrencyDaoJdbcImpl(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }


    @Override
    public List<Currency> getAll() {
        List<Currency> currency = new ArrayList<>();
        try (Connection connection = connectionFactory.getConnection();
             Statement statement = connection.createStatement();) {
            try (ResultSet resultSet = statement.executeQuery(SELECT_FROM_ALL_CURRENCY);) {
                while (resultSet.next()) {
                    currency.add(new Currency(resultSet.getLong(COLUMN_ID),
                            resultSet.getString(COLUMN_NAME)));
                }
            }
        } catch (Exception e) {
            throw new DaoException(String.format("Method getAll Currency; has throw an exception."), e);
        }
        return currency;
    }

    @Override
    public void insert(Currency currency) {
        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_CRURRENCY);) {
            statement.setString(1, currency.getName());
            int i = statement.executeUpdate();
            if (i == 0) {
                throw new DaoException("Table 'Purses' was not updated", null);
            }
        } catch (Exception e) {
            throw new DaoException(String.format("Method insert(currency: '%d') has throw an exception.", currency), e);
        }
    }
}