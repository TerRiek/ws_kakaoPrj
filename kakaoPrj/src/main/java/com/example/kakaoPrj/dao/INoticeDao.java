package com.example.kakaoPrj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.kakaoPrj.dto.NoticeDto;

@Mapper
public interface INoticeDao {
	public List<NoticeDto> listDao(@Param("writer") String writer, @Param("receiver") String receiver);
	public NoticeDto detailDao(@Param("nno") String nno);
	public int writeDao(@Param("dto") NoticeDto dto );
	public int deleteDao(@Param("nno") String nno);
}
