package com.olsendesign.store.dao;

import java.util.List;

import com.olsendesign.store.hibernate.entity.Card;

public interface CardDAO {
	List<Card> getAllCards();
	Card getCard(int cardId);
	void saveCard(Card card);
	void deleteCard(int cardId);
}
