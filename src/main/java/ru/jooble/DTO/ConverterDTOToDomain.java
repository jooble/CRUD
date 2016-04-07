package ru.jooble.DTO;

import org.springframework.stereotype.Component;
import ru.jooble.domain.Currency;
import ru.jooble.domain.Exchange;
import ru.jooble.domain.Purse;
import ru.jooble.domain.User;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class ConverterDTOToDomain {

    public Currency convertCurrencyDTOToTheCurrency(CurrencyDTO currencyDTO) {
        Currency currency = new Currency();
        if (currencyDTO.getId() == null) {
            currency.setName(currencyDTO.getName());
        } else {
            currency.setId(Long.parseLong(currencyDTO.getId()));
            currency.setName(currencyDTO.getName());
        }

        return currency;
    }

    public Exchange convertExchangeDTOToTheExchange(ExchangeDTO exchangeDTO) {
        Exchange exchange = new Exchange();
        Currency sourceCurrency = convertCurrencyDTOToTheCurrency(exchangeDTO.getSourceCurrency());
        Currency targetCurrency = convertCurrencyDTOToTheCurrency(exchangeDTO.getTargetCurrency());
        if (exchangeDTO.getId() == null) {
            exchange.setSourceCurrency(sourceCurrency);
            exchange.setTargetCurrency(targetCurrency);
            exchange.setExchangeRate(Double.parseDouble(exchangeDTO.getExchangeRate()));
        } else {
            exchange.setId(Long.parseLong(exchangeDTO.getId()));
            exchange.setSourceCurrency(sourceCurrency);
            exchange.setTargetCurrency(targetCurrency);
            exchange.setExchangeRate(Double.parseDouble(exchangeDTO.getExchangeRate()));
        }
        return exchange;
    }

    public User convertUserDTOToTheUser(UserDTO userDTO) {
        return getUser(userDTO);
    }

    //TODO - как назвать этот метод?
    //TODO ниже будут еще такие
    private User getUser(UserDTO userDTO) {
        User user = new User();
        Purse purse = new Purse();
        List<PurseDTO> purseDTOs = userDTO.getPurseDTOs();
        List<Purse> purses = new ArrayList<>();
        if (userDTO.getPurseDTOs() != null) {
            for (PurseDTO purseDTO : purseDTOs) {
                if (purseDTO.getId() == null) {
                    setPurse(purseDTO, purse);
                } else {
                    setPurse(purseDTO, purse);
                    purse.setId(Long.parseLong(purseDTO.getId()));
                }
                purses.add(convertPurseDTOToThePurse(purseDTO));
            }
        }
        if (userDTO.getId() == null) {
            setUser(userDTO, user, purses);
        } else {

            setUser(userDTO, user, purses);
            user.setId(Long.parseLong(userDTO.getId()));
        }
        return user;
    }

    //// TODO: вот
    private void setUser(UserDTO userDTO, User user, List<Purse> purses) {
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setPurses(purses);
    }

    public Purse convertPurseDTOToThePurse(PurseDTO purseDTO) {
        Purse purse = new Purse();
        if (purseDTO.getId() == null) {
            setPurse(purseDTO, purse);
        } else {
            setPurse(purseDTO, purse);
            purse.setId(Long.parseLong(purseDTO.getId()));
        }
        return purse;
    }

    //// TODO: Еще
    private void setPurse(PurseDTO purseDTO, Purse purse) {
        purse.setName(purseDTO.getName());
        purse.setCurrency(convertCurrencyDTOToTheCurrency(purseDTO.getCurrencyDTO()));
        purse.setOwner(getUser(purseDTO.getOwnerDTO()));
        purse.setAmount(new BigDecimal(purseDTO.getAmount()));
    }
}
