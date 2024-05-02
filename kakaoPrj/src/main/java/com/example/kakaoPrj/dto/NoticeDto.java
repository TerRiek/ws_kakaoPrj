package com.example.kakaoPrj.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoticeDto {

	private int nno;
	private String title;
	private String content;
	private String writer;
	private String receiver;
	private LocalDate regdate;
}
