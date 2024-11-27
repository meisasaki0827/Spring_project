package com.example.demo.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.calculator.service.CalculatorService;

@Controller
public class CalculatorController {
	private CalculatorService calculatorService;

	public CalculatorController(CalculatorService calculatorService) {
		this.calculatorService = calculatorService;
	}

	@GetMapping("calculation")
	public String minus(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2,
			@RequestParam String select, Model model) {
		
		// 初回アクセス時
		if (num1 == null || num2 == null) {
			model.addAttribute("result", null);
			
		} else {			
			int result;
			
			// 演算子で条件分岐 各処理のメソッドを実行
			if ("plus".equals(select)) {
				result = calculatorService.plus(num1, num2);
				model.addAttribute("result", result);
			} else if ("minus".equals(select)) {
				result = calculatorService.minus(num1, num2);
				model.addAttribute("result", result);
			} else if ("multi".equals(select)) {
				result = calculatorService.multi(num1, num2);
				model.addAttribute("result", result);
			} else if ("quo".equals(select)) {
				// ゼロ除算スロー
				if(num2 != 0) {
					result = calculatorService.quo(num1, num2);
					model.addAttribute("result", result);
				} else {
					model.addAttribute("result", "ゼロ除算はできません");
				}
				
			}
		}

		return "calculator.html";
	}
}