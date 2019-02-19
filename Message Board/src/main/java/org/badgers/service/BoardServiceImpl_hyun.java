package org.badgers.service;

import java.util.List;

import javax.inject.Inject;

import org.badgers.domain.BoardVO;
import org.badgers.domain.Criteria;
import org.badgers.persistence.BoardMapper_hyun;
import org.springframework.stereotype.Service;

import lombok.Setter;

@Service
public class BoardServiceImpl_hyun implements BoardService {

	@Inject
	private BoardMapper_hyun mapper;

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

		return null;
	}

	@Override
	public int listCount(Criteria cri) throws Exception {
		return 0;
	}
}
