package com.example.kakaoPrj.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.kakaoPrj.dto.MemberDto;

@Mapper
public interface IMemberDao {
	public MemberDto detailDto(@Param("mno") String mno);
	public MemberDto getDto(@Param("id") String id);
	
	public int regDto(@Param("dto") MemberDto dto);
	public int deleteDto(@Param("mno") String mno);
	public int loginCheck(@Param("id") String id, @Param("pw") String pw);
	public int updateDto(@Param("dto") MemberDto dto);
}
