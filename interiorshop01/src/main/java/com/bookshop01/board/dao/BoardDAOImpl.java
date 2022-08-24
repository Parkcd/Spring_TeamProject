package com.bookshop01.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.bookshop01.board.vo.BoardVO;

@Repository("boardDAO")
public class BoardDAOImpl implements BoardDAO{
	@Autowired
	private SqlSession sqlSession;
	

	@Override
	public List boardList() throws DataAccessException {
		List boardList = sqlSession.selectList("mapper.board.boardList");
		return boardList;
	}

	
	
}
