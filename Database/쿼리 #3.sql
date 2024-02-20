-- ------------------------------------------------------------------
-- 날짜  함수
-- ------------------------------------------------------------------

-- CONCAT : 문자를 이을떼 사용하는 함수.
-- SMITH(CLERK)
SELECT concat(ename,'(',job,')') "Name AND Job" FROM emp; 

-- format: #,###,###.##(숫자형 데이터의 포맷 지정)
SELECT FORMAT(250500.1254,2);

SELECT empno, ename, sal FROM emp;
SELECT empno,ename, FORMAT(sal,0) FROM emp; 
-- 그냥 출력하는 것과 다른 점이 무엇이냐면 숫자형 데이터를 ,를붙여서 문자형으로바꿔준것입니다.

-- insert: 문자열 내의 지정된 위치에 특정 문자 수만큼 문자열을 변경한다.
SELECT INSERT('http://naver.com',8,5,'kosta');

-- student테이블에서 주민번호 뒤 7자리를 *로 대체하여 조회(학번,이름 , 주민번호 학년)
SELECT studno, NAME, INSERT(jumin,7,7,'*******') jumin, grade FROM student;

-- gogak 테이블의 고객번호, 이름 조회(단, 이름은 가운데 글자를 *로 대체)
SELECT gno 고객번호, INSERT(gname,2,1,'*') 고객명 FROM gogak;

-- instr: 문자열내에서 특정 문자의 위치를 구한다.(SQL은 순서가 1부터시작)
SELECT INSTR('http://naver.com','n');

-- student 테이블에서 tel의 ')'의 위치 조회
SELECT INSTR(tel,')') FROM student;

-- substr: 문자열 내에서 부분 문자열 추출
SELECT SUBSTR('http://naver.com',8,5);
SELECT SUBSTR('http://naver.com',8); -- 뒤에 파라미터를 적지 않으면 8번부터 전체를 끌어옵니다.

-- student 테이블에서 전화번호의 지역번호 조회(힌트: substr, instr 사용)
SELECT NAME, SUBSTR(tel,1, INSTR(tel,')')-1) 지역번호  FROM student;

-- student 테이블에서 전화번호의 앞번호  조회(힌트: substr, instr 사용)
SELECT NAME, SUBSTR(tel,INSTR(tel,')')+1, INSTR(tel,'-')-INSTR(tel,')')-1) 앞번호 FROM student;

-- student 테이블에서 주민번호상 9월생인 학생의 학번, 이름,주민번호, 조회
SELECT studno, NAME, jumin FROM student WHERE jumin LIKE '__09%'; 
SELECT studno, NAME, jumin FROM student WHERE SUBSTR(jumin,3,2)='09';

-- substring: (=substr)

-- length: 문자열의 바이트 수 구하기(영문한글자:1byte, 한글한글자: 3byte)
SELECT LENGTH('stiven');
SELECT LENGTH('스티븐');

SELECT LENGTH(email) FROM professor;
SELECT email, INSTR(email,'@') FROM professor;

SELECT substr(email, INSTR(email,'@')+1) FROM professor;

SELECT email,
substr(email, INSTR(email,'@')+1),
 LENGTH(substr(email, INSTR(email,'@')+1)) length 
 FROM professor;
 
 SELECT email,
 INSERT(email, INSTR(email, '@')+1, LENGTH( SUBSTR(email, INSTR(email,'@')+1)), 'kosta.com') AS email
 FROM professor;
 
 -- char_length: 문자열의 글자수 구하기
 SELECT CHAR_LENGTH('홍길동') 한글글자수, CHAR_LENGTH('hfd') 영문글자수;
 -- LOWER: 소문자로 변경, UPPER: 대문자로 변경
 SELECT LOWER('Abc'), UPPER('Abc');
-- ------------------------------------------------------------------
-- 숫자 함수
-- ------------------------------------------------------------------



-- ------------------------------------------------------------------
-- 문자열 함수
-- ------------------------------------------------------------------
