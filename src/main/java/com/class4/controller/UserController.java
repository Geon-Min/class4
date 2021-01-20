package com.class4.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import com.class4.command.UserVO;
import com.class4.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	@Qualifier("UserService")
	private UserService userService;
	
	@RequestMapping("/join")
	public String join() {
		return "user/join";
	}
	
		
	@RequestMapping("/mypage")
	public String mypage() {
		return "user/mypage";
	}
	@ResponseBody
	@RequestMapping(value="idCheck", method=RequestMethod.POST)
	public int idCheck(@RequestBody UserVO vo) {
		System.out.println(vo.getUserId());
		int result = userService.idCheck(vo.getUserId());
		
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="login", method=RequestMethod.POST)
	public ModelAndView login(@RequestBody UserVO vo, Model model, HttpSession session) {
		
		UserVO result = userService.Login(vo);
		
		
		ModelAndView mv = new ModelAndView();//���model������ ���ÿ� ����
		mv.setViewName("user/userLogin");
		
		if(result != null) {//�α���			
			mv.addObject("login", result);
			
		}else {//�α��� ����
			mv.addObject("msg","���̵� ��й�ȣ�� Ȯ���ϼ���");
		}
		
		return mv;
	}
	@RequestMapping(value="JoinReq", method=RequestMethod.POST)
	@ResponseBody
	public int JoinReq(UserVO vo , 
			@RequestParam (value="genreList[]") List<String> genreList,
			@RequestParam (value="actorList[]") List<String> actorList,
			@RequestParam (value="directorList[]") List<String> directorList) {
		
		System.out.println(vo.toString());
		System.out.println("�Ѿ��");
		for(String genre : genreList) {
		System.out.println(genre);}
		
		int result = userService.JoinReq(vo);
		
		return result;		
	}
}
