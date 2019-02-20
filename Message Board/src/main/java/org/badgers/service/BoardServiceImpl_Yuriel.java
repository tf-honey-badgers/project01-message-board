package org.badgers.service;

import java.util.List;

import org.badgers.domain.BoardVO;
import org.badgers.domain.Criteria;
import org.badgers.persistence.BoardMapper_Yuriel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;

@Service
public class BoardServiceImpl_Yuriel implements BoardService {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper_Yuriel mapper;
	
	// 게시글을 새로 추가한다.
	public int regist(BoardVO board) throws Exception {
		return mapper.insert(board);
	}
	
	// 특정 게시글을 읽어온다.
	public BoardVO read(Integer bno) throws Exception {
		return mapper.read(bno);
	}
	
	// 특정 게시글을 수정한다.
	public int modify(BoardVO board) throws Exception {
		return mapper.update(board);
	}
	
	// 특정 게시글을 삭제한다.
	public int remove(Integer bno) throws Exception {
		return mapper.delete(bno);
	}
	
	// 게시글 모두를 읽어온다.
	public List<BoardVO> listAll() throws Exception {
		return mapper.getList();
	}
	
	// 게시글을 Criteria로 정하는 수만큼 읽어온다.
	public List<BoardVO> listCriteria(Criteria cri) throws Exception {
		return mapper.getListWithPaging(cri);
	}
	
	// 게시글의 총 개수를 센다. (count)
	public int listCount(Criteria cri) throws Exception {
		return mapper.getTotalCount(cri);
	}
}
