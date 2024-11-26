package com.example.demo.minus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.minus.service.MinusService;

@Controller
public class MinusController {	
	private MinusService minusService;

	public MinusController(MinusService minusService) {
		this.minusService = minusService;
	}
	
	@GetMapping("minus")
	public String minus(@RequestParam int num1, @RequestParam int num2, Model model) {
		String result = "";
		// 入力値を引数にServiceの処理を実行
		result = String.valueOf(minusService.minus(num1,num2));
		// 処理結果を画面に表示
		model.addAttribute("result", result);
		// 画面遷移
		return "minus.html";
	}
}