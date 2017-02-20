package com.olsendesign.store.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.olsendesign.store.dao.CardDAO;
import com.olsendesign.store.hibernate.entity.Card;
import com.olsendesign.store.hibernate.entity.Product;

@Repository
public class CardDaoImpl implements CardDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Card> getAllCards() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Card> query = currentSession.createQuery("from Card", Card.class);
	    List<Card> cards = query.getResultList();
		return cards;
	}

	@Override
	public Card getCard(int cardId) {
		Session currentSession = sessionFactory.getCurrentSession();	
		Card card = currentSession.get(Card.class, cardId);
		return card;
	}

	@Override
	public void saveCard(Card card) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(card);

	}

	@Override
	public void deleteCard(int cardId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("delete from Card where id=:cardId");
        query.setParameter("cardId", cardId);
        query.executeUpdate();
	}

}
