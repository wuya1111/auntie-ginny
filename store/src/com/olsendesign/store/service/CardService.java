package com.olsendesign.store.service;

import java.util.List;

import com.olsendesign.store.hibernate.entity.Card;

public interface CardService {
	public List<Card> getAllCards();
	public Card getCard(int cardId);
	public void saveCard(Card card);
	public void deleteCard(int cardId);
	
}
