create table t_shopping_board(
        boardNO number(10) primary key,
        title varchar2(500) not null,
        content varchar2(4000),
        writedate date default sysdate not null
);

insert into t_shopping_board(boardNO, title, content, writedate)
    values(1, '오픈 이벤트', '오픈 기념 선착순 100분에게 40%할인 진행중입니다', sysdate);
    
insert into t_shopping_board(boardNO, title, content, writedate)
    values(2, '관리자 모집', '컴퓨터 조작에 유능하고 인테리어에 관심이많은 분을 찾습니다', sysdate);
    
insert into t_shopping_board(boardNO, title, content, writedate)
    values(3, '기부 완료', ' 회원님들 덕분에 A보육원에 100만원 상당의 가구 후원 하였습니다. 감사합니다', sysdate);
    
insert into t_shopping_board(boardNO, title, content, writedate)
    values(4, '택배기사 파업', '택배 기사 파업관계로 배송이 4~5일 이상 소요됩니다.', sysdate);
    
insert into t_shopping_board(boardNO, title, content, writedate)
    values(5, '추석 이벤트', '추석 기념 모든 상품10%할인 들어갑니다.', sysdate);
    SELECT
        *
    FROM t_shopping_board;
    
    commit;