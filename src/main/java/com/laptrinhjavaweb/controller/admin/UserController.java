package com.laptrinhjavaweb.controller.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.service.IUserService;
import com.laptrinhjavaweb.util.MessageUtil;

@Controller(value="userControllerOfAdmin")
public class UserController{
	@Autowired
	private IUserService userService;
	@Autowired
	private MessageUtil messageUtil;
	
	@RequestMapping(value="/quan-tri/nguoi-dung/danh-sach",method = RequestMethod.GET)
	public ModelAndView showList(@RequestParam("page") int page,
								@RequestParam("limit") int limit, HttpServletRequest request) {
		System.out.println(request.getUserPrincipal());
		ModelAndView mav= new ModelAndView("admin/user/list");
		Pageable pageable=new PageRequest(page - 1,limit);
		UserDTO user=new UserDTO();
		user.setPage(page);
		user.setLimit(limit);
		user.setListResult(userService.findAll(pageable));
		user.setTotalItem(userService.getTotalItem());
		user.setTotalPage((int) Math.ceil((double) user.getTotalItem() / user.getLimit()));

		
		mav.addObject("model",user);
		return mav;
	}
	@RequestMapping(value="/quan-tri/nguoi-dung/chinh-sua",method=RequestMethod.GET)
	public ModelAndView editUser(@RequestParam(value="id",required=false) Long id,HttpServletRequest rq,@RequestParam(value="file",required = false) CommonsMultipartFile file) {
		ModelAndView mav= new ModelAndView("admin/user/edit");
		UserDTO model=new UserDTO();
		if(id !=null) {
			model= userService.findById(id);
		
		}

		if (rq.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(rq.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("model",model);
		
		return mav;
		
	}
	

}
