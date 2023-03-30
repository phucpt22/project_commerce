package edu.poly.asm_java6.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import edu.poly.asm_java6.entities.SanPham;
import edu.poly.asm_java6.entities.Item;
import edu.poly.asm_java6.reponsitory.NguoiDungRepository;
import edu.poly.asm_java6.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope
@Service
public class CartServiceImpl implements CartService {

	@Autowired
	NguoiDungRepository dao;

	Map<Integer, Item> map = new HashMap<>();

	ArrayList<Item> list = new ArrayList<Item>();

	@Override
	public Item add(Integer id) {
		Item item = map.get(id);
		if (item == null) {
			item = new Item();
			SanPham p = new SanPham();
			List<SanPham> list = dao.findAll();
			p = list.stream().filter(it -> it.getId_SP() == id).collect(Collectors.toList()).get(0);
			item.setId(p.getId());
			item.setName(p.getName());
			item.setImg(p.getImg());
			item.setPrice(p.getPrice());
			item.setQty(1);
			map.put(id, item);
		} else {
			item.setQty(item.getQty() + 1);
		}
		return item;
	}

	@Override
	public void remove(Integer id) {
		map.remove(id);
	}

	@Override
	public Item update(Integer id, int qty) {
		Item item = map.get(id);
		item.setQty(qty);
		return item;
	}

	@Override
	public void clear() {
		map.clear();
	}

	@Override
	public Collection<Item> getItems() {
		return map.values();
	}

//	@Override
//	public List<Item> getItems() {
//		for (Integer i : map.keySet()) {
//			list.add(map.get(i));
//		}
//		return list;
//	}

	@Override
	public int getCount() {
		return map.values().stream().mapToInt(item -> item.getQty()).sum();
	}

	@Override
	public double getAmount() {
		return map.values().stream().mapToDouble(item -> item.getPrice() * item.getQty()).sum();
	}
}
