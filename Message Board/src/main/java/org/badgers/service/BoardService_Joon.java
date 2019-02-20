package org.badgers.service;

import java.util.List;

import org.badgers.domain.BoardVO;
import org.badgers.domain.Criteria;
import org.badgers.domain.Criteria_Joon;
import org.badgers.persistence.BoardMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;

@Service
public class BoardService_Joon {
	
	@Setter(onMethod_=@Autowired)
	private SqlSessionTemplate template;
	
	private BoardMapper mapper;

	
	public int delete(Integer bno) {
		
		return mapper.delete(bno);
	}

	public BoardVO read(Integer bno) {
		
		return mapper.read(bno);
	}
	
	public List<BoardVO> getListWithPaging(Criteria_Joon cri) {

		return mapper.getListWithPaging(cri);
	}
	
	public int getTotalCount(Criteria cri) {
		
		return mapper.getTotalCount(cri);
	}
	
	public int insert(BoardVO board) {

		return mapper.insert(board);
	}
}
