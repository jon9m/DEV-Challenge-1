package com.mmk.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mmk.entity.Currency;

@Repository
public class CurrencyDAOImpl implements CurrencyDAO {

	// inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Currency> getCurrenyListByType(String type) {
		// get the current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// Order by time
		Query<Currency> theQuery = currentSession.createQuery("from Currency where currency=:currType order by time",
				Currency.class);
		theQuery.setParameter("currType", type);

		// execute query and get result list
		List<Currency> currencyList = theQuery.getResultList();

		System.out.println(currencyList);
		return currencyList;
	}

	@Override
	public void addCurrency(Currency currency) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(currency);
		System.out.println("Currency Added!");
	}

	@Override
	public List<String> getCurrencyNamesList() {
		//Distinct Symbols
		Session currentSession = sessionFactory.getCurrentSession();
		Query<String> theQuery = currentSession.createQuery("select distinct c.currency from Currency c");
		List<String> currencyList = theQuery.getResultList();

		System.out.println(currencyList);
		return currencyList;
	}
}
