package com.example.kakaoPrj.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.kakaoPrj.dto.NoticeDto;

@SpringBootTest
class IMemberDaoTest {

	@Autowired
	private IMemberDao dao;
	
	@Autowired
	private INoticeDao nDao;
	
	@Test
	void testMemberDao() {
		List<NoticeDto> list = nDao.getMySelf("fff");
		System.out.println(list);
	}

}
