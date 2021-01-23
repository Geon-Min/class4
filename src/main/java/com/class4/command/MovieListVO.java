package com.class4.command;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//영화 리스트 VO
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieListVO {
	

	private String movieCd; //영화코드
	private String title;
	private String ftitle;
	private String grade; //심의정보
	private Timestamp openDt;  //개봉일
	private String subhead;
	private String content;
	private String poster;
	
	
}
