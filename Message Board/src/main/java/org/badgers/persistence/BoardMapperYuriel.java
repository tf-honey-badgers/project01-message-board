package org.badgers.persistence;

import java.util.List;

import org.badgers.domain.BoardVO;
import org.badgers.domain.Criteria;

public interface BoardMapperYuriel {

	// BoardService regist()와 연결된다.
	public void insert(BoardVO board);
	
	// BoardService listAll()와 연결된다.
	public List<BoardVO> getList();
	// BoardService listCriteria()와 연결된다.
	public List<BoardVO> getListWithPaging(Criteria cri);
	// BoardService read()와 연결된다.
	public BoardVO read(Integer bno);
	// BoardService modify()와 연결된다.
	public int update(BoardVO board);
    // BoardService delete()와 연결된다.
	public int delete(Integer bno);
	// BoardService listCount()와 연결된다.
	public int getTotalCount(Criteria cri);
}