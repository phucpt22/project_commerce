package edu.poly.asm_java6.controller;

import edu.poly.asm_java6.entities.Product;
import edu.poly.asm_java6.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {
	@Autowired
	ProductService productService;

	@RequestMapping("/product/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id) {
		Product item = productService.findById(id);
		model.addAttribute("item", item);
		return "product/detail";
	}
	
	@RequestMapping("/product/list")
	public String list(Model model, @RequestParam("cid")Optional<String> cid) {
		List<Product> list;


		if (cid.isPresent()) {
			list= productService.findByCategoryId(cid.get());
		}else {
			list = productService.findAll();
		}
			model.addAttribute("items", list);
		return "product/list";
	}
	@RequestMapping("/product/find")
	public String search(Model model, @RequestParam("search")Optional<String> s) {
		List<Product> list;
		list = productService.findAll();
		List<Product> searchsp = productService.findByName(s.get());
		model.addAttribute("items", list);
		model.addAttribute("items", searchsp);

		return "product/list";
	}
	@RequestMapping("/product/filter")
	public String filter(Model model, @RequestParam("price") Double price) {
		List<Product> list;
		list = productService.findAll();
		try {
			List<Product> sr_price = null;
			if (price == 0) {
				model.addAttribute("price", price);
				sr_price = productService.findByPrice(0, 600000000);
			}else if(price == 1) {
				model.addAttribute("price", price);
				sr_price = productService.findByPrice(0,30);
			}
			else if (price == 2) {
				model.addAttribute("price", price);
				sr_price = productService.findByPrice(30, 49);
			} else if (price == 3) {
				model.addAttribute("price", price);
				sr_price = productService.findByPrice(50, 69);
			} else if (price == 4) {
				model.addAttribute("price", price);
				sr_price = productService.findByPrice(70, 89);
			} else if (price == 5) {
				model.addAttribute("price", price);
				sr_price = productService.findByPrice(90, 10000);
			}
			model.addAttribute("items", list);
			model.addAttribute("items", sr_price);
		}catch (Exception e) {
			e.printStackTrace();
		}

		return "product/list";
	}
}
