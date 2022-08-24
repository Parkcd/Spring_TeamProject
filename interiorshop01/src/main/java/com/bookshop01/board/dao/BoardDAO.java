package com.bookshop01.board.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.bookshop01.board.vo.BoardVO;

public interface BoardDAO {

	
	public List boardList()throws DataAccessException;
	
	public BoardVO board(int boardNO)throws DataAccessException;
	
	public int deleteBoard(int boardNO)throws DataAccessException;
	
	public int insertBoard(BoardVO boardVO)throws DataAccessException;
	
	public int updateBoard(BoardVO boardVO)throws DataAccessException;
}
