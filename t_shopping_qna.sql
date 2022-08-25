    create table t_shopping_qna(
        qnaNO number(10) primary key,
        qnaTitle varchar2(500) not null,
        qnaContent varchar2(4000),
        qnaWritedate date default sysdate,
        answerDate date default sysdate,
        answer varchar2(4000)
);

insert into t_shopping_qna(qnaNO, qnaTitle, qnaContent, qnaWritedate, answerDate, answer)
    values(1, '결제 오류 문의 드립니다', '계좌이체 과정에서 돈을 만원 더 입금했는데 환불 가능 할까요?', sysdate, sysdate, '가능합니다 1~2일 안에 입급 됩니다.');
    
insert into t_shopping_qna(qnaNO, qnaTitle, qnaContent, qnaWritedate, answerDate, answer)
    values(2, '재고 문의 드립니다', '아 편하다~ 쇼파 품절 되었는데 언제 재고 풀릴까요?', sysdate, sysdate, ' 이번달 28일날 추가 재고 들어옵니다.');
    
insert into t_shopping_qna(qnaNO, qnaTitle, qnaContent, qnaWritedate, answerDate, answer)
    values(3, '재고 문의', '정말 정말 편한 테이블의자 재고 언제 풀리나요', sysdate, sysdate, '죄송합니다 고객님 그 제품은 더이상 입고 되지 않습니다.');
    
insert into t_shopping_qna(qnaNO, qnaTitle, qnaContent, qnaWritedate, answerDate, answer)
    values(4, '환불 문의', '구매하고 한번사용한 조명인데 불이 잘 안들어와서 환불 요청 드립니다', sysdate, sysdate, '불량 상품 전달드린점 죄송합니다 환불 처리 해드리겠습니다.');
    
insert into t_shopping_qna(qnaNO, qnaTitle, qnaContent, qnaWritedate, answerDate, answer)
    values(5, '회원 탈퇴 문의 ', '회원 탈퇴가 하고싶습니다', sysdate, sysdate, '고객 센터로 전화 주시면 신속히 처리 해드리겠습니다.');
    
    alter table t_shopping_qna add answer varchar2(4000);
    
    SELECT
        *
    FROM t_shopping_qna;
    
    commit;