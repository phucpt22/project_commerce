package edu.poly.asm_java6.service;

import java.util.Collection;

import com.sun.mail.imap.protocol.Item;
import edu.poly.asm_java6.entities.*;

public interface CartService {

	Item add(Integer id);

	void remove(Integer id);

	Item update(Integer id, int qty);

	void clear();

	Collection<Item> getItems();

//	List<Item> getItems();

	int getCount();

	double getAmount();
}