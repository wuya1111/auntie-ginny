package com.olsendesign.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.olsendesign.store.dao.CardDAO;
import com.olsendesign.store.hibernate.entity.Card;
import com.olsendesign.store.service.CardService;

@Service
public class CardServiceImpl implements CardService {

	@Autowired
	private CardDAO cardDAO;
	
	@Override
	@Transactional
	public List<Card> getAllCards() {
		return cardDAO.getAllCards();
	}

	@Override
	@Transactional
	public Card getCard(int cardId) {
		return cardDAO.getCard(cardId);
	}

	@Override
	@Transactional
	public void saveCard(Card card) {
		cardDAO.saveCard(card);
	}

	@Override
	@Transactional
	public void deleteCard(int cardId) {
		cardDAO.deleteCard(cardId);
	}

}
