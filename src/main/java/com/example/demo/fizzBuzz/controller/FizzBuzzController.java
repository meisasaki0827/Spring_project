package com.example.demo.fizzBuzz.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.fizzBuzz.service.FizzBuzzService;

@Controller
public class FizzBuzzController {
	private final FizzBuzzService fizzBuzzService;

	public FizzBuzzController(FizzBuzzService fizzBuzzService) {
		this.fizzBuzzService = fizzBuzzService;
	}

	@GetMapping("fizzBuzz")
	public String fizzBuzz(Model model) {
		// リストを作成
		List<String> list = new ArrayList<String>();

		for (int i = 0; i <= 100; i++) {
			// Serviceの処理結果をリストに格納
			list.add(fizzBuzzService.fizzBuzz(i));			
		}
		// 画面へ表示
		model.addAttribute("numbers", list);
		return "fizzBuzz.html";
	}
}