package com.bookshop01.qna.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.bookshop01.qna.vo.QnaVO;

public interface QnaDAO {

	
	public List qnaList()throws DataAccessException;
	
	public QnaVO qna(int qnaNO)throws DataAccessException;
	
	public int deleteQna(int qnaNO)throws DataAccessException;
	
	public int insertQna(QnaVO qnaVO)throws DataAccessException;
	
	public int updateQna(QnaVO qnaVO)throws DataAccessException;
}
