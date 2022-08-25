package com.bookshop01.qna.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.bookshop01.qna.vo.QnaVO;

@Repository("qnaDAO")
public class QnaDAOImpl implements QnaDAO{
	@Autowired
	private SqlSession sqlSession;
	

	@Override
	public List qnaList() throws DataAccessException {
		List qnaList = sqlSession.selectList("mapper.qna.qnaList");
		return qnaList;
	}


	@Override
	public QnaVO qna(int qnaNO) throws DataAccessException {
		 
		return sqlSession.selectOne("mapper.qna.qnaOne", qnaNO);
	}


	@Override
	public int deleteQna(int qnaNO) throws DataAccessException {
		
		
		return sqlSession.delete("mapper.qna.deleteQna", qnaNO);
	}


	@Override
	public int insertQna(QnaVO qnaVO) throws DataAccessException {
		int result = sqlSession.insert("mapper.qna.insertQna", qnaVO);
		return result;
	}


	@Override
	public int updateQna(QnaVO qnaVO) throws DataAccessException {
		int result = sqlSession.update("mapper.qna.updateQna", qnaVO);
		return result;
	}

	
	
}
