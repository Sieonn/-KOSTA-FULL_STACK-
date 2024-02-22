-- join
CREATE TABLE test1(
A VARCHAR(10),
B VARCHAR(20));
-- test1


CREATE TABLE test2(
A VARCHAR(10),
C VARCHAR(20),
B VARCHAR(20));


CREATE TABLE test2(A VARCHAR(10), B VARCHAR(20), C VARCHAR(20));

DROP TABLE test1;
INSERT INTO test1 VALUES('a1','b1');
INSERT INTO test1 VALUES('a2','b2');

INSERT INTO test2 VALUES('a3','c3','d3');
INSERT INTO test2 VALUES('a4','c4','d4');
INSERT INTO test2 VALUES('a5','c5','d5');

SELECT *
FROM test1 JOIN test2
ORDER BY 1;

-- test1과 test2를 함께 출력하기
SELECT *
FROM test1 JOIN test2
ORDER BY 1;

SELECT e.ename, e.DEPTNO, d.dname
FROM emp e, dept d
WHERE e.deptno=d.deptno;

-- ANSI join(표준 join)
SELECT e.ename, e.DEPTNO, d.dname
FROM emp e JOIN dept d
ON e.DEPTNO=d.DEPTNO;

-- student, department 테이블을 이용하여 학번, 이름, 학과명 조회
SELECT s.studno, s.name, d.dname
FROM student s JOIN department d
on s.deptno1=d.deptno;

-- 위에다가 교수명까지 추가한다면?
SELECT s.studno, s.name, d.dname, p.name
FROM student s JOIN department d
ON s.deptno1=d.deptno
JOIN professor p
ON s.profno=p.profno;


SELECT s.studno, s.NAME, d.dname, p.name
FROM student s JOIN department d 
ON s.deptno1=d.DEPTNO
JOIN professor p
ON s.profno=p.profno;


-- 이런식으로 and로 묶어서도 가능
SELECT s.studno, s.name, d.dname, p.name
FROM student s, department d, professor p
WHERE s.deptno1=d.deptno AND s.profno=p.profno;

-- student, professor 테이블을 이용하여 학번, 이름, 담당교수명 조회
-- left로 null값도 같이 출력합니다.
SELECT s.studno, s.name, p.name
FROM student s left JOIN professor p
ON s.profno=p.profno
ORDER BY 3;

SELECT s.*,p.name
FROM student s LEFT JOIN professor p
ON s.profno=p.profno;

-- student, department 테이블을 이용하여, 학번, 이름, 학년, 제1전공과명, 제2전공과명 조회
SELECT s.studno, s.name, s.grade, d.dname 주전공, d2.dname 부전공
FROM student s left JOIN department d
ON s.deptno1 = d.deptno
LEFT JOIN department d2
ON s.deptno2=d2.deptno;

SELECT s.studno, s.name, s.grade, d1.dname 주전공, d2.dname 부전공
FROM student s JOIN department d1
ON s.deptno1=d1.deptno
left JOIN department d2
ON s.deptno2=d2.deptno;

-- student,exam_01 테이블을 이용하여 학번, 이름, 학년, 점수 조회
SELECT s.studno, s.name, s.grade, ex1.total
FROM student s JOIN exam_01 ex1
ON s.studno=ex1.studno;

SELECT s.studno, s.name, s.grade, e.total
FROM student s JOIN exam_01 e
ON s.studno=e.studno;

-- emp2 테이블을 이용하여 사번, 이름, 나의 관리자 사번, 관리자행 조회
SELECT e1.empno, e1.NAME, e1.PEMPNO, e2.name
FROM emp2 e1 left JOIN emp2 e2
ON e1.PEMPNO=e2.EMPNO;

-- emp 테이블을 이용하여 사번, 이름, 나의 관리자 사번, 관리자명 조회
SELECT e1.EMPNO, e1.ENAME, e1.mgr, e2.ename
FROM emp e1 left JOIN emp e2
ON e1.mgr=e2.Empno

-- student, exam_01, hakjum 테이블을 이용하여 학번, 이름, 점수, 학점 조회
SELECT s.studno, s.grade, e.total, h.grade
FROM student s JOIN exam_01 e
ON s.studno=e.studno
JOIN hakjum h
ON e.total BETWEEN h.min_point AND h.max_point;

-- gogak, gift 테이블을 이용하여 고객이름, 보유포인트, 포인트로 받을 수 있는 가장 좋은 선물이름 조회
SELECT g.gname, g.point, g1.gname
FROM gogak g JOIN gift g1
ON g.point BETWEEN g1.g_start AND g1.g_end;

-- emp2, p_grade 테이블을 이용하여 이름, 직위, 급여, 같은직급의 최소급여, 같은 직급의 최대급여 조회
SELECT e2.NAME, e2.POSITION, e2.PAY, p.s_pay, p.e_pay
FROM emp2 e2, p_grade p
WHERE e2.POSITION=p.position AND e2.pay>p.e_pay;

-- emp2, p_grade 테이블을 이용하여 이름, 지급, 나이, 본인의 나이에 해당하는 예상 직급 조회
SELECT e2.NAME, e2.POSITION, format(DATEDIFF(CURDATE(),e2.BIRTHDAY)/365,0) 나이, p.position
FROM emp2 e2, p_grade p
WHERE format(DATEDIFF(CURDATE(),e2.BIRTHDAY)/365,0) BETWEEN p.s_age AND p.e_age;



