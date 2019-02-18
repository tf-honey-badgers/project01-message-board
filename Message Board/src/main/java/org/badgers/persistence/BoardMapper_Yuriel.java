package org.badgers.persistence;

import java.util.List;

import org.badgers.domain.BoardVO;
import org.badgers.domain.Criteria;

public interface BoardMapper_Yuriel {

	// BoardService regist()와 연결된다.
	public int insert(BoardVO board) throws Exception;
	// BoardService read()와 연결된다.
	public BoardVO read(Integer bno) throws Exception;
	// BoardService modify()와 연결된다.
	public int update(BoardVO board) throws Exception;
	
	// BoardService listAll()와 연결된다.
	public List<BoardVO> getList() throws Exception;
	// BoardService listCriteria()와 연결된다.
	public List<BoardVO> getListWithPaging(Criteria cri) throws Exception;
    // BoardService delete()와 연결된다.
	public int delete(Integer bno) throws Exception;
	// BoardService listCount()와 연결된다.
	public int getTotalCount(Criteria cri) throws Exception;
}