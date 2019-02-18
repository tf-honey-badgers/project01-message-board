package org.badgers.service;

import java.util.List;

import javax.inject.Inject;

import org.badgers.domain.BoardVO;
import org.badgers.domain.Criteria;
import org.badgers.persistence.BoardMapper_yuni;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl_yuni  implements BoardService{
	
	@Inject
	private BoardMapper_yuni mapper;

	@Override
	public void regist(BoardVO board) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BoardVO read(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modify(BoardVO board) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardVO> listCriteria(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int listCount(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
