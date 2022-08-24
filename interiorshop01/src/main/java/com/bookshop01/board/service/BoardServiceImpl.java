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

}
