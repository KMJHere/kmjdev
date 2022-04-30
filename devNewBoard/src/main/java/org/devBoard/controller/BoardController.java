package org.devBoard.controller;

import javax.inject.Inject;

import org.devBoard.domain.BoardVO;
import org.devBoard.domain.Criteria;
import org.devBoard.domain.PageMaker;
import org.devBoard.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Inject
	private BoardService boardservice;
	
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public void registerGET(BoardVO board, Model model) throws Exception {
		logger.info("register get...");
	}
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String registPOST(BoardVO board, RedirectAttributes rttr) throws Exception {
		logger.info("register post...");
		logger.info(board.toString());
		
		boardservice.regist(board);
		
		rttr.addFlashAttribute("msg", "success");
		
		return "redirect:/board/listAll";
	}
	
	@RequestMapping(value="/listAll", method = RequestMethod.GET)
	public void listAll(Model model) throws Exception {
		logger.info("show all list");
		
		model.addAttribute("list", boardservice.listAll());
	}
	
	@RequestMapping(value="/listCri", method = RequestMethod.GET)
	public void listCri(Criteria cri, Model model) throws Exception {
		logger.info("show list Page With..");
		
		model.addAttribute("list", boardservice.listCriteria(cri));
	}
	
	@RequestMapping(value="/read", method = RequestMethod.GET)
	public void read(@RequestParam("bno") int bno, Model model) throws Exception {
		model.addAttribute(boardservice.read(bno));
	}
	
	@RequestMapping(value="/readPage", method = RequestMethod.GET)
	public void read(@RequestParam("bno") int bno, @ModelAttribute("cri") Criteria cri, Model model) throws Exception {
		model.addAttribute(boardservice.read(bno));
	}
	
	@RequestMapping(value="/modify", method = RequestMethod.GET)
	public void modifyGET(int bno, Model model) throws Exception {
		model.addAttribute(boardservice.read(bno)); 
	}
	
	@RequestMapping(value="/modifyPage", method = RequestMethod.GET)
	public void modifyPagingGET(@RequestParam("bno") int bno, @ModelAttribute("cri") Criteria cri, Model model) throws Exception {
		model.addAttribute(boardservice.read(bno)); 
	}
	
	@RequestMapping(value="/modify", method = RequestMethod.POST)
	public String modifyPOST(BoardVO board, Criteria cri, RedirectAttributes rttr) throws Exception {
		logger.info("modify 수정중..");
		
		boardservice.modify(board);
		
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addFlashAttribute("msg", "success");
		
		return "redirect:/board/listPage";
	}
	
	@RequestMapping(value="/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("bno") int bno, RedirectAttributes rttr) throws Exception {
		boardservice.remove(bno);
			
		rttr.addFlashAttribute("msg", "success");
			
		return "redirect:/board/listAll"; 
	}
	
	@RequestMapping(value="/removePage", method = RequestMethod.POST)
	public String remove(@RequestParam("bno") int bno, Criteria cri, RedirectAttributes rttr) throws Exception {
		boardservice.remove(bno);
			
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addFlashAttribute("msg", "success");
			
		return "redirect:/board/listPage"; 
	}
	
	@RequestMapping(value="/listPage", method= RequestMethod.GET)
	public void listPage(Criteria cri, Model model)throws Exception{
		logger.info(cri.toString());
		
		model.addAttribute("list", boardservice.listCriteria(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		
		// pageMaker.setTotalCount(131);
		// 전체 게시물 수
		pageMaker.setTotalCount(boardservice.listCountCriteria(cri));
		
		model.addAttribute("pageMaker", pageMaker);
	}
}
