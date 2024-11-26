package com.example.demo.fizzBuzz.service;

import org.springframework.stereotype.Service;

@Service
public class FizzBuzzService {
	public String fizzBuzz(int number) {
		String result = "";

		if (number % 3 == 0 && number % 5 == 0) {
			result = "FizzBuzz";
		} else if (number % 3 == 0) {
			result = "Fizz";
		} else if (number % 5 == 0) {
			result = "Buzz";
		} else {
			// Fizz Buzzでもない場合数値のみを代入
			// int型のためString型に変更
			result = String.valueOf(number);
		}
		return result;
	}
}