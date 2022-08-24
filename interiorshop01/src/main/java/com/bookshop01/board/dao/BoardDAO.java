package com.bookshop01.board.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.bookshop01.board.vo.BoardVO;

public interface BoardDAO {

	
	public List boardList()throws DataAccessException;
	
	
}
