package service;

import dao.AccountDAO;
import dao.AccountDAOImpl;
import dto.Account;

public class AccountServiceImpl implements AccountService {
	
	private AccountDAO accountDAO = new AccountDAOImpl();

	@Override
	public void makeAccount(Account acc) throws Exception {
		Account sacc = accountDAO.selectAccount(acc.getId());
		if(sacc!=null) throw new Exception("계좌번호가 중복됩니다.");
		accountDAO.insertAccount(acc);
	}

}
