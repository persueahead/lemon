--1���г�����������Ա�������в��źͲ�����Ϣ��
SELECT * FROM dept d,(SELECT COUNT(*) number FROM emp e GROUP BY e.deptno) n
WHERE n.number>=3;
--2���г��ܹ���������ֱ���ϼ�������Ա���ı�ţ���������������
SELECT e.empno 'Ա�����',e.ename 'Ա������',e.deptno 'Ա������',d.dname '��������',
e.hiredate 'Ա����ְ',
e.mgr '��˾',e2.hiredate '��˾��ְ'
FROM emp e,emp e2,dept d
WHERE e.mgr=e2.empno
AND e.hiredate < e2.hiredate
AND e.deptno=d.deptno;
--3���г�ְλΪ��CLERK���������Ͳ������ƣ�����������
SELECT e.ename,e.deptno,number
FROM emp e ,(SELECT f.deptno, COUNT(*) number FROM emp f GROUP BY f.deptno) f
WHERE e.job='CLERK'
AND e.deptno=f.deptno
GROUP BY e.empno;
--4���г��͡�SCOTT��������ͬ����������Ա�����������ƣ�
SELECT e1.ename,e1.deptno FROM emp e1 
WHERE EXISTS(SELECT * FROM emp e2 WHERE e1.job=e2.job 
AND e2.ename='scott' 
AND e1.ename!=e2.ename);
 
--5���г�ÿ�����Ź�����Ա��������ƽ�����ʺ�ƽ���������ޣ���λΪ�꣩
SELECT e.deptno,
COUNT(*) num,
ROUND(SUM(sal)/COUNT(*),2) averageSal,
CEIL(SUM(TIMESTAMPDIFF(YEAR,hiredate,NOW()))/COUNT(*)) averageYear
FROM emp e GROUP BY e.deptno;
--6���г��������ŵ�MANAGER �����н��
SELECT e1.deptno,MIN(e2.sal) 
FROM emp e1,emp e2
WHERE e1.mgr=e2.empno
AND e1.deptno=e2.deptno
GROUP BY e2.deptno;
--7������ְ���ڳ���10����˼�н10%��
SELECT  e.empno, e.sal*1.1 FROM emp e
WHERE TIMESTAMPDIFF(year,e.hiredate,NOW())>10;

--8��ͳ��н�� ���� н����ߵ�Ա�� ���ڲ��� ��ƽ������ �� н����͵�Ա�����ڲ��ŵ�ƽ������ ��ƽ������ ��Ա����Ϣ��
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

