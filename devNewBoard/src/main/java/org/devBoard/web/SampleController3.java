package org.devBoard.web;

import org.devBoard.domain.ProductVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController3 {

	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);

	@RequestMapping("doD")
	public String doD(Model model) {

		// make sample data
		ProductVO product = new ProductVO("sample", 10000);

		logger.info("dod");

		model.addAttribute(product);

		return "productDetail";
	}
}
