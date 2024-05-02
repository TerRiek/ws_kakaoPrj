package com.example.kakaoPrj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.kakaoPrj.dto.NoticeDto;

@Mapper
public interface INoticeDao {
	public List<NoticeDto> listDao();
	public NoticeDto detailDao(String nno);
	public void writeDao(String title, String content, String writer, String regdate, String reciever);
	public void deleteDao(String nno);
}
