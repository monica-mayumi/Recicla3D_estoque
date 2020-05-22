package br.com.fapen.estoque;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestEncode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println( encoder.encode("monica"));
		
		//encoder.m
		System.out.println(encoder.matches("1234","$2a$10$IuFfByej9mmjid26B8gvfuNmhqwdsokNwBOHRbONUTjYsDnASkTm2"));
		System.out.println(encoder.matches("1234","$2a$10$gmZkZRZx/RuNCNgLBWw3LO0qSOFukn/Q10ixXmHzuhoEm3gcZ7msi"));
	
	}

}
