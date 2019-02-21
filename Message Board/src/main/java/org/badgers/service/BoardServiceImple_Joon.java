package org.badgers.service;

import java.util.List;

import org.badgers.domain.BoardVO;
import org.badgers.domain.Criteria;
import org.badgers.domain.Criteria_Joon;
import org.badgers.persistence.BoardMapper;
import org.badgers.persistence.BoardMapper_Joon;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;

@Service
public class BoardServiceImple_Joon implements BoardService{

	@Setter(onMethod_=@Autowired)
	private BoardMapper_Joon mapper;

	@Override
	public int regist(BoardVO board) throws Exception {
		return mapper.insert(board);
	}

	@Override
	public BoardVO read(Integer bno) throws Exception {
		return mapper.read(bno);
	}

	@Override
	public int modify(BoardVO board) throws Exception {
		return mapper.update(board);
	}

	@Override
	public int remove(Integer bno) throws Exception {
		return mapper.delete(bno);
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		return null;
	}

	@Override
	public List<BoardVO> listCriteria(Criteria cri) throws Exception {
		return mapper.getListWithPaging(cri);
	}

	@Override
	public int listCount(Criteria cri) throws Exception {
		return mapper.getTotalCount();
	}
	

}
