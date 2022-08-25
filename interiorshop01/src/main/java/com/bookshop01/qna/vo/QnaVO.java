package com.bookshop01.qna.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("qnaVO")
public class QnaVO {
	
	private int qnaNO;
	private String qnaTitle;
	private String qnaContent;
	private Date  qnaWriteDate;
	private Date answerDate;
	private String answer;
	
	public int getQnaNO() {
		return qnaNO;
	}
	public void setQnaNO(int qnaNO) {
		this.qnaNO = qnaNO;
	}
	public String getQnaTitle() {
		return qnaTitle;
	}
	public void setQnaTitle(String qnaTitle) {
		this.qnaTitle = qnaTitle;
	}
	public String getQnaContent() {
		return qnaContent;
	}
	public void setQnaContent(String qnaContent) {
		this.qnaContent = qnaContent;
	}
	public Date getQnaWriteDate() {
		return qnaWriteDate;
	}
	public void setQnaWriteDate(Date qnaWriteDate) {
		this.qnaWriteDate = qnaWriteDate;
	}
	public Date getAnswerDate() {
		return answerDate;
	}
	public void setAnswerDate(Date answerDate) {
		this.answerDate = answerDate;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	
	
	
	
	
}
