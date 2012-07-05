package com.example;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.example.model.Message;

public class MessageUtil {

	public static List<Message> getMessages() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hsqldb");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		TypedQuery<Message> q = em.createQuery("SELECT m FROM Message m", Message.class);
		
		List<Message> messages = q.getResultList();
		tx.commit();
		em.close();
		
		return messages;
	}
}
