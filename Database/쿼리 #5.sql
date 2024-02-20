SELECT e.empno, e.ename, e.job, e.hiredate, e.sal, e.comm, e.deptno, d.dname, d.loc
FROM emp e JOIN dept d
ON e.deptno=d.deptno;

SELECT e.empno, e.ename, e.job, e.hiredate, e.sal, e.comm, e.deptno, d.dname, d.loc
FROM emp e JOIN dept d
ON e.DEPTNO=d.deptno;
-- ,로조인할 경우 where
SELECT e.empno, e.ename, e.job, e.hiredate, e.sal, e.comm, e.deptno, d.dname, d.loc
FROM emp e, dept d
where e.DEPTNO=d.deptno;

SELECT *
FROM emp JOIN dept
ON emp.DEPTNO=dept.deptno;

-- student, professor 테이블을 이용하여 모든 학생의 정보를 조회하되, 담당 교수면을 함께 조회하시오
SELECT s.*, p.name 
FROM student s left JOIN professor p
ON s.profno = p.profno; 
-- 왼쪽의 값이 on인것은 null의 여부와 상관없이 다 출력해야할 떄 left를 씁니다.

-- student, department 테이블을 이용하여 주전공이 컴퓨터공학과 학생들의
-- 학번, 이름, 학년, 학과번호 , 학과명을 조회하시오

SELECT s.studno, s.NAME, s.grade, s.deptno1, d.deptno, d.dname  
FROM student s join department d
ON s.deptno1 = d.deptno
WHERE d.dname='컴퓨터공학과';

SELECT s.studno, s.name, s.grage, s.deptno1, d.dname
FROM student s, department d
WHERE s.deptno1 = d.deptno AND d.dname = '컴퓨터공학과';

-- student, department 테이블을 이용하여 모든 학생의 정보를 조회하되,
-- 학번, 이름, 학년, 주전공, 부전,학과명

SELECT s.studno, s.name, s.grade, d.deptno2
FROM student s JOIN department d
on s.deptno1 = d.deptno;

SELECT s.studno, s.name, s.grade, d.deptono2, d2.*
FROM student s JOIN department d
ON s.deptno1=d.deptno;
left JOIN department d2
On s.deptno2 = d.deptno;

SELECT s.studno, s.name, s.grade, d.name, d2.dname
FROM student s JOIN department d
ON s.deptno1=d.deptno
LEFT JOIN department d2
ON  s.deptno2 =d2.deptno;
-- join에서 on으로 조건을 주지 않으면 left는 에러가 납니다.

-- emp 테이블을 이용하여 각 사원의 정보와 각 매니저의 이름을 함꼐 조회하시오

SELECT e.*, m.ENAME
FROM emp e left JOIN emp m
ON e.MGR = m.EMPNO;

-- exam_01, hakjum 테이블을 이용하여 학번, 점수, 학점을 조회하시옿
SELECT e.*, h.grade
FROM exam_01 e JOIN hakjum h
-- ON. e.total>= h.min_point AND e.total<=h.max_point;
ON. e.total BETWEEN h.min_point AND h.max_point;

SELECT s.studno, s.name, s.grade, e.total, h.grade
FROM student s JOIN exam_01 e
ON s.studno=e.studno
JOIN hakjum h
ON e.total BETWEEN h.min_point AND h.max_point
ORDER BY h.grade;

-- gogak, gift 테이블을 이용하여 각 고객의 정보와 고객이 포인트로 받을 수 있는 상품명을 조회하시ㅗㅇ

SELECT g.*, g2.gname
FROM gogak g JOIN gift g2
ON g.point BETWEEN g2.g_start AND g2.g_end
ORDER BY g.point DESC;

-- gogak, gift 테이블을 이용하여 노트북 상품을 탈 수 있는 고객의 번호, 이름 포인트를 조회하시오
SELECT go.gno, go.gname, go.point
FROM gogak go, gift gi
WHERE gi.gname = '노트북' AND go.point> gi.g_start;

SELECT go.gno, go.gname, go.point
FROM gogak go JOIN gift gi
ON go.point>=gi.g_start
WHERE gi.gname='노트북';

-- emp, p_grade 테이블을 이용하여 각 직원의 번호, 입사이르 직급, 예상직급을 조회하시오
SELECT CURDATE(), birthday, YEAR(CURDATE())-YEAR(birthday), e.position, p.position
FROM emp2 e JOIN p_grade p;

SELECT e.EMPNO,e.NAME, e.birthday, YEAR(CURDATE())-YEAR(birthday), e.position, p.position
FROM emp2 e, p_grade p;
WHERE YEAR(CURDATE())-YEAR(birthday) BETWEEN p.s_age AND p.e_age;


-- emp2, p_grade 테이블을 이용하여 이름, 직위, 급여, 같은 직급의 최소급여, 최대급여 조회

SELECT e.NAME, e.position, e.pay, p.s_pay, p.e_pay
FROM emp2 e join p_grade p
On e. POSITION=p.position;

-- student, department 테이블을 이요하여 공과대학 학생들의 학번,이름, 학년, 주전공을 조회하시오.

SELECT d1.deptno
FROM department d1 JOIN department d2
ON d1.part = d2.deptno
WHERE d2.dname = '컴퓨터정보학부';

SELECT s.studno, s.name, s.grade, d1.deptno
FROM department d1 JOIN department d2
ON d1.part=d2.deptno
JOIN student s
ON  s.deptno1=d1.deptno
WHERE d2.dname='컴퓨터정보학부';

-- student, department테이블을 이용하여 공과대학 학생들의 학번, 이름, 학년, 주전공을 조히하시오.
-- 1. 공과 대학에 해당하는 학부 조회
SELECT d1.deptno
FROM department JOIN department d2
ON d1.part=d2.deptno
WHERE d2.dname ='공과대학';

-- 2. 공과대학 학부에 해당하는 학과 조회
SELECT d2.deptno
FROM department d1 JOIN department d2
ON d1.part=d2.deptno
JOIN department d3
ON d1.deptno=d3.part
WHERE d2.dname='공과대학';

-- 3. 공과대학 학과에 해당하는 학생 조회
SELECT s.studno, s.name s.grade, s.deptno1
FROM department d1 JOIN department d2
ON d1.part =d2.deptno
JOIN department d3
ON d1.deptno=s.deptno1
WHERE d2.dname='공과대학';

-- 전자제어관 건물에 있는 학과 소속인 학생의 학번, 이름, 학과 조회
SELECT s.studno, s.name,s.deptno1, d.dname, d.bulid
FROM student s JOIN department d
ON s.deptno1=d.deptnowhere
WHERE d.build='전자제어관';

-- emp 테이블을 이용하여 사번, 이름, 입사일, 자신보다 먼저 입사한 사람, 인원수 조회
SELECT e1.*, e2.HIREDATE
FROM emp e1 LEFT JOIN emp e2
ON e1.HIREDATE > e2.HIREDATE
ORDER BY 1; 

SELECT e1.*, COUNT(e1.hiredate)
FROM emp e1 right JOIN emp e2
ON e1.HIREDATE> e2.HIREDATE
group BY e1.HIREDATE
ORDER BY 9;
