package com.example.kakaoPrj.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.kakaoPrj.dto.MemberDto;

@SpringBootTest
class IMemberDaoTest {

	@Autowired
	private IMemberDao dao;
	
	@Test
	void testMemberDao() {
		int result = dao.updateDto(new MemberDto("2", "fff", "fff", "fff"));
		System.out.println(result);
	}

}
