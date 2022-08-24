package com.bookshop01.board.service;

import java.util.List;

import com.bookshop01.board.vo.BoardVO;

public interface BoardService {

	public List listBoard()throws Exception;
	
	public BoardVO detailBoard(int boardNO)throws Exception;
	
	public int removeBoard(int boardNO)throws Exception;
	
	public int addBoard(BoardVO boardVO)throws Exception;
	
	public int modifyBoard(BoardVO boardVO)throws Exception;
}
