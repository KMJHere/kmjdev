package org.devBoard.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController2 {
	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);

	@RequestMapping("doc")
	public String doc(@ModelAttribute("msg") String msg) {

		logger.info("return msg.....");

		return "result";
	}
}
