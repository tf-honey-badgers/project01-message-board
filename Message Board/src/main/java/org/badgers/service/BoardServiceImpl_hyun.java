package org.badgers.service;

import java.util.List;

import org.badgers.domain.BoardVO;
import org.badgers.domain.Criteria;
import org.badgers.persistence.BoardMapper_hyun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;

@Service
public class BoardServiceImpl_hyun implements BoardService {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper_hyun mapper;

	// 등록
	public int regist(BoardVO board) throws Exception {
		return mapper.regist(board);

	}
	// 컨텐츠 내용 읽기
	public BoardVO read(Integer bno) throws Exception {
		return mapper.read(bno);
	}
	
	// 수정 (업뎃)
	public int modify(BoardVO board) throws Exception {
		return mapper.update(board);

	}
	
	// 게시글 삭제
	public int remove(Integer bno) throws Exception {
		return mapper.delete(bno);
	}
	
	// 전체 내용~
	public List<BoardVO> listAll() throws Exception {
		return mapper.getList();
	}
	
	// 페이징 해야되는ㄱ구나 ~
	// 크리테리아 활용 페이징 처리 하기 
	public List<BoardVO> listCriteria(Criteria cri) throws Exception {
		return mapper.getListWithPaging(cri);
	}
	
	// 불러불라블라
	/// 게스글 총글 수 count
	public int listCount(Criteria cri) throws Exception {
		return mapper.getTotalCount(cri);
	}
}
