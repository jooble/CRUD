package ru.jooble.dao;


import ru.jooble.domain.Purse;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class PurseDaoJdbcImpl implements PurseDao {

    public static final String SELECT_BY_ID_QUERY = "SELECT * FROM purse WHERE id = ?";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_CURRENCY = "currency";
    public static final String COLUMN_AMOUNT = "amount";
    public static final String INSERT_PURSE = "INSERT INTO purse (name, currency, amount) VALUES (?, ?, ?)";
    public static final String SELECT_FROM_ALL_PURSE = "SELECT * FROM purse";
    public static final String UPDATES_PURSE = "UPDATE purse SET name = ?, currency = ?, amount = ? WHERE id = ?";
    public static final String DELETE_PURSE = "DELETE FROM purse WHERE id = ?";
    public static final String DELETE_ALL_PURSE = "DELETE FROM purse";
    private ConnectionFactory connectionFactory;

    public PurseDaoJdbcImpl(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }



    @Override
    public Purse getById(long id) {
        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID_QUERY);) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery();) {
                while (resultSet.next()) {
                    return new Purse(resultSet.getLong(COLUMN_ID),
                            resultSet.getString(COLUMN_NAME),
                            resultSet.getString(COLUMN_CURRENCY),
                            resultSet.getInt(COLUMN_AMOUNT));
                }
            }
        } catch (Exception e) {
            throw new DaoException(String.format("Method getById(id: '%d') has thrown an exception.", id), e);
        }
        return null;
    }

    @Override
    public void insert(Purse purse) {
        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_PURSE);) {
            statement.setString(1, purse.getName());
            statement.setString(2, purse.getCurrency());
            statement.setInt(3, purse.getAmount());
            int i = statement.executeUpdate();
            if (i == 0) {
                throw new DaoException("Table 'Purses' was not updated", null);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Purse> getAll() {
        List<Purse> purse = new ArrayList<>();
        try (Connection connection = connectionFactory.getConnection();
             Statement statement = connection.createStatement();) {
            try (ResultSet resultSet = statement.executeQuery(SELECT_FROM_ALL_PURSE);) {
                while (resultSet.next()) {
                    purse.add(new Purse(resultSet.getLong(COLUMN_ID),
                            resultSet.getString(COLUMN_NAME),
                            resultSet.getString(COLUMN_CURRENCY),
                            resultSet.getInt(COLUMN_AMOUNT)));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return purse;
    }


    @Override
    public void update(Purse purse) {
        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATES_PURSE);) {
            statement.setString(1, purse.getName());
            statement.setString(2, purse.getCurrency());
            statement.setInt(3, purse.getAmount());
            statement.setLong(4, purse.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(long id) {
        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_PURSE);) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAll() {
        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_ALL_PURSE);) {
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

