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
	// 初回アクセス時はnum1,num2が未指定のため、required属性で引数nullを設定
	// nullを許容するため引数はIntegerを使用
	public String minus(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2, Model model) {
		
		// 初回アクセス時
		if(num1 == null || num2 == null) {
			model.addAttribute("result", null);
		} else {
			// 入力値を引数にServiceの処理を実行
						int result = minusService.minus(num1, num2);
						// 処理結果を画面へ渡す
						model.addAttribute("result", result);
		}			
		
		return "minus.html";
	}
}