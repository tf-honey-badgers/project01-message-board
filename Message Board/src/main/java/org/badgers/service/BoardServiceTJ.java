package org.badgers.service;

import java.util.List;

import javax.inject.Inject;

import org.badgers.domain.BoardVO;
import org.badgers.domain.Criteria;
import org.badgers.domain.CriteriaTJ;
import org.badgers.domain.PageMaker;
import org.badgers.persistence.BoardMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;
@Service
public class BoardServiceTJ implements BoardService {

	@Inject
	private BoardMapper mapper;
	
	@Inject
	private PageMaker pageMaker;
	
	// 게시글을 새로 추가한다.
	public int regist(BoardVO board) throws Exception{
		mapper.insert(board);
		return 0;
	}
	// 특정 게시글을 읽어온다.
	public BoardVO read(Integer bno) throws Exception{
		
		return mapper.read(bno);
	}
	// 특정 게시글을 수정한다.
	public int modify(BoardVO board) throws Exception{
		
		return mapper.update(board);
	}
	// 특정 게시글을 삭제한다.
	public int remove(Integer bno) throws Exception{
		return mapper.delete(bno);
	}
	// 게시글 모두를 읽어온다.
	public List<BoardVO> listAll() throws Exception{
		
		return mapper.getList();
	}
	// 게시글을 Criteria로 정하는 수만큼 읽어온다.
	public List<BoardVO> listCriteria(Criteria cri) throws Exception{
		cri = (CriteriaTJ)cri;
		pageMaker.setCri(cri);
		
		pageMaker.setTotalCount(listCount(cri));
		System.out.println("서비스 pageMaker : "+pageMaker);
		System.out.println("서비스 Cri : "+ cri);
		
		return mapper.getListWithPaging(cri);
	}
	// 게시글의 총 개수를 센다. (count)
	public int listCount(Criteria cri) throws Exception{
		List list=mapper.getList();
		return list.size();
	}
}
