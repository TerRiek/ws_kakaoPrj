package com.example.kakaoPrj.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.kakaoPrj.dto.MemberDto;

@Mapper
public interface IMemberDao {
	public MemberDto detailDao(String mno);
	public void regDao(String id, String pw, String name);
	public void deleteDao(String mno);
}
