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
	public int regist(BoardVO board) throws Exception {
		return mapper.regist(board);
		
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
		
		return mapper.getList();
	}

	@Override
	public List<BoardVO> listCriteria(Criteria cri) throws Exception {
		
		return mapper.getListWithPaging(cri);
	}

	@Override
	public int listCount(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
