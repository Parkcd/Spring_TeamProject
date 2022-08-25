package com.bookshop01.qna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookshop01.qna.dao.QnaDAO;
import com.bookshop01.qna.vo.QnaVO;

@Service("qnaService")
public class QnaServiceImpl implements QnaService{

	@Autowired
	QnaDAO qnaDAO;
	
	@Override
	public List listQna() throws Exception {
		List qnaList = qnaDAO.qnaList();
		return qnaList;
	}

	@Override
	public QnaVO detailQna(int qnaNO) throws Exception {
		QnaVO qnaVO = qnaDAO.qna(qnaNO);
		return qnaVO;
	}

	@Override
	public int removeQna(int qnaNO) throws Exception {
		int removeqna = qnaDAO.deleteQna(qnaNO);
		return removeqna;
	}

	@Override
	public int addQna(QnaVO qnaVO) throws Exception {
		int addQna = qnaDAO.insertQna(qnaVO);
		return addQna;
	}

	@Override
	public int modifyQna(QnaVO qnaVO) throws Exception {
		int modifyQna = qnaDAO.updateQna(qnaVO);
		return modifyQna;
	}

	
}
