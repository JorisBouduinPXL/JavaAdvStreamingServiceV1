package be.pxl.ja.streamingservice.repository;

import be.pxl.ja.streamingservice.account.Account;
import be.pxl.ja.streamingservice.exception.DuplicateEmailException;

import java.util.ArrayList;
import java.util.List;

public class AccountRepository {
    private List<Account> accounts = new ArrayList<>();

    public void addAccount(Account account) throws DuplicateEmailException {
        if (accounts.contains(account.getEmail())) {
            throw new DuplicateEmailException(account.getEmail());
        } else {
            accounts.add(account);
        }
    }

    public Account findAccount(String email) {
        for (Account account : accounts) {
            if (account.getEmail().equals(email)) {
                return account;
            }
        }
        return null;
    }
}
