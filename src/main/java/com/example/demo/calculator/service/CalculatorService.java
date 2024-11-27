package com.example.demo.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

	// plusメソッド
	public int plus(int num1, int num2) {
		int result = num1 + num2;
		return result;
	}

	// minusメソッド
	public int minus(int num1, int num2) {
		int result = num1 - num2;
		return result;
	}

	// multiメソッド
	public int multi(int num1, int num2) {
		int result = num1 * num2;
		return result;
	}

	// quoメソッド
	public int quo(int num1, int num2) {
		int result = num1 / num2;
		return result;
	}
}