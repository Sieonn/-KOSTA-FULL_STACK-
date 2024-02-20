
-- select 컬럼명1, 컬럼명2... from 테이블 이름 :테이블의 데이터를 조회할 때 사용
SELECT ename,job,hiredate FROM emp;
SELECT studno,NAME,grade,deptno1  FROM student;

-- dept 테이블의 전체 칼럼 조회
SELECT * FROM dept;

-- select from where절 :행에대한 조건절
SELECT * FROM emp WHERE deptno=10;
-- 사번이 7782인 직원의 모든 항목 조회
SELECT * FROM emp WHERE empno=7782;

-- job이 clerk인 직원의 모든 항목 조회
SELECT * FROM emp WHERE job='CLERK';
-- emp테이블에서 급여가 1000이상인 직원의 사번, 이름, 급여 조회
SELECT empno,ename,sal FROM emp WHERE sal>= 1000;
-- student 테이블에서4학년 학생들의 학번, 이름, 생일,전화번호, 학년
SELECT studno,NAME,birthday,tel,grade FROM student WHERE grade=4;
-- student 테이블에서 1,2,4학년 학생들의 모든 컬럼 조회
SELECT * FROM student WHERE grade=1 OR grade=2 OR grade=4;
SELECT * FROM student WHERE grade IN(1, 2, 4);
SELECT * FROM student WHERE NOT grade=4;

-- student 테이블에서 2,3학년 학생들의 모든 컬럼 조회
SELECT * FROM student WHERE grade=2 OR grade=3;
SELECT * FROM student WHERE grade>2 AND grade <=3;
SELECT * FROM student WHERE grade IN(2,3);

-- emp 테이블에서 업무(job)가 CLERK이거나 SALESMAN인 직원의 사번, 이름 , 업무 조회
SELECT empno, ename, job FROM emp WHERE job= 'CLERK' OR job='SALESMAN';

-- student 테이블에서 4학년이면서 학과번호가 10인 학생의 학번, 이름, 학년, 학과 번호조회
SELECT studno, NAME, grade, deptno1 FROM student WHERE grade=4 AND deptno1=101;

-- student 테이블에서 주전공이나 부전공이 101인 학생의 모든 정보 조회
SELECT * FROM student WHERE deptno1=101 OR deptno2=101;

-- 날짜 형식도 비교연산이 가능합니다.
SELECT * FROM emp WHERE hiredate>='1985-01-01'
-- student테이블에서 1976년생 학생 조회
SELECT * FROM student WHERE birthday>='1976-01-01' AND birthday <='1977-01-01';
-- between a and b
SELECT * FROM student WHERE birthday BETWEEN '1976-01-01' AND '1977-01-01';
-- professpr 테이블에서 급여가 500대인 교수의 정보 조회
SELECT *  FROM professor WHERE pay>='500' AND pay <='600';
SELECT * FROM professor WHERE pay BETWEEN '500' AND '600';

-- order by: 정렬-오름차순이 기본
SELECT * FROM emp ORDER BY sal; -- 오름 차순 기본
SELECT * FROM emp ORDER BY sal DESC; --내림차순
SELECT * FROM emp WHERE deptno=10 order BY sal DESC;
SELECT studno,NAME FROM student order by 2;
SELECT * FROM professor WHERE pay>=500 AND pay<=600 ORDER BY pay DESC;

-- student 테이블에서 4학년 학생들을 이름 순으로 정렬
SELECT * FROM student where grade=4 ORDER BY name;
SELECT * FROM emp ORDER BY deptno;
SELECT * FROM emp ORDER BY deptno, hiredate DESC;
-- student 테이블에서 학년순으로 정렬, 같은 학년일 경우 키가 큰 순으로 정렬
SELECT * FROM student ORDER BY grade,height;

-- DISTINCT: 중복 행 제거
SELECT distinct(deptno) FROM emp;

-- CONCAT : 문자를 이을떼 사용하는 함수.
-- SMITH(CLERK)
SELECT concat(ename,'(',job,')') "Name AND Job" FROM emp; 

--실제 ename과 job의 이름을설정해주는데 이때는 큰따옴표를 사용합니다. 이때 AS를 생략해도 됩니다.

SELECT ename 이름 FROM emp; 
SELECT ename AS "이 름", hiredate AS "입 사 일" FROM emp;

-- SMITH
SELECT CONCAT(ename,'''s sal is $',sal) AS "Name And Pay" FROM emp; 
-- '를 문자열을 사용하는것 외에 사용하고 싶을때는 두개를 사용해주면 하나로 인식합니다.

-- like연산자
SELECT * FROM student WHERE NAME LIKE '%김%';
-- 김%는 김으로 시작하는 사람 %김은 김으로 끝나는 사람 %김%은 김이 들어간 사람
-- 김_ 은 김으로 끝나는 두글자

-- student 테이블에서 주민번호를 기준으로 8월인 학생의 학번, 주민번호, 생년월일 조회
SELECT studno, jumin, birthday FROM student WHERE jumin LIKE '__08%';

SELECT * FROM professor WHERE email LIKE '%@naver.com';

SELECT * FROM emp WHERE comm IS NULL; 
-- 널 비교는 =을 쓰지 않고 is를 씁니다.
SELECT * FROM emp WHERE comm IS NOT NULL;

-- professor 테이블에서 개인 홈페이지가 있는 교수남 출력
SELECT * FROM professor WHERE hpage IS NOT NULL;

-- emp 테이블에서 sal이 1000보다 크고
-- comm이 1000보다 작거나 없는 직원의 사번, 이름, 급여, 커미션,조회
SELECT empno, ename, sal, comm FROM emp WHERE sal > 1000 AND (comm < 0 OR comm IS NULL)

-- emp 테이블에서 각 사원의 사번, 이름, 급여+ 커미션 조회
SELECT empno, ename, sal+comm FROM emp WHERE comm IS NOT NULL;
SELECT empno, ename, sal, comm, sal+IFNULL(comm,0) FROM emp; -- 이 컬럼이 null이면 안에 주어진 수로 대체해라.

-- ifnull: 해당하는 컬럼이 null일 경우 대체하는 값 지정

-- professor 테이블에서 각 교수의 사번, 이름,급여,보너스, 총금여(pay+bonus)
SELECT profno ,NAME, pay, bonus, pay+IFNULL(bonus,0) total FROM professor; 