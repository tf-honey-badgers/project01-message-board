package org.badgers.service;

import java.util.ArrayList;
import java.util.List;

import org.badgers.domain.BoardVO;
import org.badgers.domain.Criteria;
import org.badgers.persistence.BoardMapperYuriel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;

@Service
public class BoardServiceImplYuriel implements BoardService {

	@Setter(onMethod_ = @Autowired)
	private BoardMapperYuriel mapper;
	
	// 게시글을 새로 추가한다.
	public void regist(BoardVO board) throws Exception {
		mapper.insert(board);
	}
	
	// 특정 게시글을 읽어온다.
	public BoardVO read(Integer bno) throws Exception {
		return new BoardVO();
	}
	
	// 특정 게시글을 수정한다.
	public void modify(BoardVO board) throws Exception {}
	
	// 특정 게시글을 삭제한다.
	public void remove(Integer bno) throws Exception {}
	
	// 게시글 모두를 읽어온다.
	public List<BoardVO> listAll() throws Exception {
		return new ArrayList<BoardVO>();
	}
	
	// 게시글을 Criteria로 정하는 수만큼 읽어온다.
	public List<BoardVO> listCriteria(Criteria cri) throws Exception {
		return new ArrayList<BoardVO>();
	}
	
	// 게시글의 총 개수를 센다. (count)
	public int listCount(Criteria cri) throws Exception {
		return 1;
	}
}
