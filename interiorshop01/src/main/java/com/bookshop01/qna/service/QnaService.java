package com.bookshop01.qna.service;

import java.util.List;

import com.bookshop01.board.vo.BoardVO;
import com.bookshop01.qna.vo.QnaVO;

public interface QnaService {

	public List listQna()throws Exception;
	
	public QnaVO detailQna(int qnaNO)throws Exception;
	
	public int removeQna(int qnaNO)throws Exception;
	
	public int addQna(QnaVO qnaVO)throws Exception;
	
	public int modifyQna(QnaVO qnaVO)throws Exception;
}
