package com.bookshop01.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookshop01.board.dao.BoardDAO;
import com.bookshop01.board.vo.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService{

	@Autowired
	BoardDAO boardDAO;
	
	@Override
	public List listBoard() throws Exception {
		List boardList = boardDAO.boardList();
		return boardList;
	}

	@Override
	public BoardVO detailBoard(int boardNO) throws Exception {
		BoardVO boardVO = boardDAO.board(boardNO);
		return boardVO;
	}

	@Override
	public int removeBoard(int boardNO) throws Exception {
		int removeboard = boardDAO.deleteBoard(boardNO);
		return removeboard;
	}

	@Override
	public int addBoard(BoardVO boardVO) throws Exception {
		int addBoard = boardDAO.insertBoard(boardVO);
		return addBoard;
	}

	@Override
	public int modifyBoard(BoardVO boardVO) throws Exception {
		int modifyBoard = boardDAO.updateBoard(boardVO);
		return modifyBoard;
	}

	
}
