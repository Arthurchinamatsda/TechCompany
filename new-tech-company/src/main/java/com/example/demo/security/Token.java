package com.example.demo.security;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Token {
	private String token;

	public Token(String token , String string) {
		super();
		this.token = token;
	}

	public Token(String token) {
        this.token = token;
    }
}
