--1、列出至少有三个员工的所有部门和部门信息。
SELECT * FROM dept d,(SELECT COUNT(*) number FROM emp e GROUP BY e.deptno) n
WHERE n.number>=3;
--2、列出受雇日期早于直接上级的所有员工的编号，姓名，部门名称
SELECT e.empno '员工编号',e.ename '员工姓名',e.deptno '员工部门',d.dname '部门名称',
e.hiredate '员工入职',
e.mgr '上司',e2.hiredate '上司入职'
FROM emp e,emp e2,dept d
WHERE e.mgr=e2.empno
AND e.hiredate < e2.hiredate
AND e.deptno=d.deptno;
--3、列出职位为“CLERK”的姓名和部门名称，部门人数：
SELECT e.ename,e.deptno,number
FROM emp e ,(SELECT f.deptno, COUNT(*) number FROM emp f GROUP BY f.deptno) f
WHERE e.job='CLERK'
AND e.deptno=f.deptno
GROUP BY e.empno;
--4、列出和“SCOTT”从事相同工作的所有员工及部门名称：
SELECT e1.ename,e1.deptno FROM emp e1 
WHERE EXISTS(SELECT * FROM emp e2 WHERE e1.job=e2.job 
AND e2.ename='scott' 
AND e1.ename!=e2.ename);
 
--5、列出每个部门工作的员工数量、平均工资和平均服务期限（单位为年）
SELECT e.deptno,
COUNT(*) num,
ROUND(SUM(sal)/COUNT(*),2) averageSal,
CEIL(SUM(TIMESTAMPDIFF(YEAR,hiredate,NOW()))/COUNT(*)) averageYear
FROM emp e GROUP BY e.deptno;
--6、列出各个部门的MANAGER 的最低薪金：
SELECT e1.deptno,MIN(e2.sal) 
FROM emp e1,emp e2
WHERE e1.mgr=e2.empno
AND e1.deptno=e2.deptno
GROUP BY e2.deptno;
--7、给任职日期超过10年的人加薪10%；
SELECT  e.empno, e.sal*1.1 FROM emp e
WHERE TIMESTAMPDIFF(year,e.hiredate,NOW())>10;

--8、统计薪资 大于 薪资最高的员工 所在部门 的平均工资 和 薪资最低的员工所在部门的平均工资 的平均工资 的员工信息。
SELECT SUM(sal)/COUNT(*) averagesal2 FROM  emp i,(SELECT empno,deptno FROM emp e,(SELECT Min(sal) min FROM emp ) f
WHERE e.sal=f.min) j
WHERE i.deptno=j.deptno;
SELECT *  from emp k ,
(SELECT SUM(sal)/COUNT(*) averagesal1 FROM  emp g,(SELECT empno,deptno FROM emp e,(SELECT MAX(sal) max FROM emp ) f
WHERE e.sal=f.max) h
WHERE g.deptno=h.deptno) l,
(SELECT SUM(sal)/COUNT(*) averagesal2 FROM  emp i,(SELECT empno,deptno FROM emp e,(SELECT Min(sal) min FROM emp ) f
WHERE e.sal=f.min) j
WHERE i.deptno=j.deptno) m
WHERE k.sal> (l.averagesal1+m.averagesal2)/2;

