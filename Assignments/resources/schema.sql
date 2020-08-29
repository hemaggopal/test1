USE learning;

DROP TABLE students;
DROP TABLE grades;
CREATE TABLE students (id INT, stu_name VARCHAR(255), marks INT, PRIMARY KEY(id));
CREATE TABLE grades(grade INT, min_mark INT, max_mark INT, PRIMARY KEY(grade));

INSERT INTO students VALUES(1, 'Julia', 88);
INSERT INTO students VALUES(2, 'Samantha', 68);
INSERT INTO students VALUES(3, 'Maria', 99);
INSERT INTO students VALUES(4, 'Scarlet', 78);
INSERT INTO students VALUES(5, 'Ashley', 73);
INSERT INTO students VALUES(6, 'Jane', 81);

INSERT INTO grades VALUES(1, 0, 9);
INSERT INTO grades VALUES(2, 10, 19);
INSERT INTO grades VALUES(3, 20, 29);
INSERT INTO grades VALUES(4, 30,39);
INSERT INTO grades VALUES(5, 40, 49);
INSERT INTO grades VALUES(6, 50, 59);
INSERT INTO grades VALUES(7, 60, 69);
INSERT INTO grades VALUES(8, 70, 79);
INSERT INTO grades VALUES(9, 80, 89);
INSERT INTO grades VALUES(10, 90, 100);


SELECT CASE WHEN g.grade >=8 THEN s.stu_name ELSE NULL END,
g.grade, s.marks
FROM students s, grades g 
WHERE s.marks >= g.min_mark AND s.marks <= g.max_mark
ORDER BY g.grade DESC, s.stu_name ASC;

DROP TABLE challenges;
DROP TABLE submissions;

CREATE TABLE hackers(hacker_id INT, h_name VARCHAR(255), PRIMARY KEY(hacker_id));
CREATE TABLE difficulty(difficulty_level INT, score INT, PRIMARY KEY(difficulty_level));
CREATE TABLE challenges(challenge_id INT, hacker_id INT, difficulty_level INT, PRIMARY KEY(challenge_id, hacker_id), 
FOREIGN KEY (hacker_id) REFERENCES hackers(hacker_id));
CREATE TABLE submissions(submission_id INT, hacker_id INT, challenge_id INT, score INT, PRIMARY KEY(submission_id),
FOREIGN KEY(hacker_id) REFERENCES hackers(hacker_id),
FOREIGN KEY(challenge_id) REFERENCES challenges(challenge_id));


INSERT INTO hackers VALUES(86870, 'Todd');
INSERT INTO hackers VALUES(90411, 'Joe');

INSERT INTO difficulty VALUES(1,20);
INSERT INTO difficulty VALUES(2,30);
INSERT INTO difficulty VALUES(3,40);
INSERT INTO difficulty VALUES(4,60);
INSERT INTO difficulty VALUES(5,80);
INSERT INTO difficulty VALUES(6,100);
INSERT INTO difficulty VALUES(7,120);

INSERT INTO challenges VALUES(71055, 86870, 2);
INSERT INTO challenges VALUES(71055, 90411, 2);
INSERT INTO challenges VALUES(66730, 90411, 6);

INSERT INTO submissions VALUES(97431, 90411, 71055, 30);
INSERT INTO submissions VALUES(97397, 90411, 66730, 100);
INSERT INTO submissions VALUES(94613, 86870, 71055, 30);



SELECT *
FROM hackers h JOIN submissions s ON h.hacker_id=s.hacker_id
JOIN challenges c ON s.challenge_id=c.challenge_id
JOIN difficulty d ON d.difficulty_level=c.difficulty_level
WHERE d.score=s.score
GROUP BY h.hacker_id 
HAVING COUNT(*) > 2
ORDER BY COUNT(*) DESC, h.hacker_id ASC;


CREATE TABLE challenges1(challenge_id INT, hacker_id INT, PRIMARY KEY(challenge_id));

INSERT INTO hackers VALUES(5077, 'Rose');
INSERT INTO hackers VALUES(21283, 'Angela');
INSERT INTO hackers VALUES(62743, 'Frank');
INSERT INTO hackers VALUES(88255, 'Patrick');
INSERT INTO hackers VALUES(96196, 'Lisa');

INSERT INTO challenges1 VALUES(1, 21283);
INSERT INTO challenges1 VALUES(21989, 5077);
INSERT INTO challenges1 VALUES(21879, 5077);
INSERT INTO challenges1 VALUES(21654, 5077);
INSERT INTO challenges1 VALUES(2, 62743);
INSERT INTO challenges1 VALUES(3, 62743);
INSERT INTO challenges1 VALUES(4, 88255);
INSERT INTO challenges1 VALUES(5, 88255);

SELECT * FROM
(SELECT hacker_id, COUNT(*) AS cnt FROM challenges1 GROUP BY hacker_id) AS t1
JOIN
(SELECT hacker_id, COUNT(*) AS cnt FROM challenges1 GROUP BY hacker_id) AS t2
ON t1.hacker_id != t2.hacker_id


SELECT * FROM
(SELECT hacker_id, COUNT(*) AS cnt FROM challenges1 GROUP BY hacker_id) AS t1
JOIN
(SELECT hacker_id, COUNT(*) AS cnt FROM challenges1 GROUP BY hacker_id) AS t2
ON t1.hacker_id != t2.hacker_id AND t1.cnt=t2.cnt AND t1.cnt!=
(SELECT COUNT(*) AS max_cnt FROM challenges1 GROUP BY hacker_id ORDER BY COUNT(*) DESC LIMIT 1)


SELECT h.hacker_id, h.h_name, COUNT(*) FROM hackers h JOIN challenges1 c ON h.hacker_id=c.hacker_id
GROUP BY h.hacker_id

SELECT h.hacker_id, h.h_name, COUNT(*) FROM hackers h JOIN challenges1 c ON h.hacker_id=c.hacker_id
WHERE h.hacker_id NOT IN 
(SELECT t1.hacker_id FROM
(SELECT hacker_id, COUNT(*) AS cnt FROM challenges1 GROUP BY hacker_id) AS t1
JOIN
(SELECT hacker_id, COUNT(*) AS cnt FROM challenges1 GROUP BY hacker_id) AS t2
ON t1.hacker_id != t2.hacker_id AND t1.cnt=t2.cnt AND t1.cnt!=
(SELECT COUNT(*) AS max_cnt FROM challenges1 GROUP BY hacker_id ORDER BY COUNT(*) DESC LIMIT 1))
GROUP BY h.hacker_id
ORDER BY COUNT(*) DESC, h.hacker_id


/*
 * JOINS - Day 4
 */
 CREATE TABLE dept (
	deptno NUMERIC,
	dname VARCHAR(255),
	loc VARCHAR(255),
	PRIMARY KEY(deptno)
);
 CREATE TABLE emp (
	empno NUMERIC,
	ename VARCHAR(255),
	job VARCHAR(255),
	mgr NUMERIC,
	deptno NUMERIC,
	PRIMARY KEY (empno),
	FOREIGN KEY(deptno) REFERENCES dept(deptno)
);

INSERT INTO dept VALUES(10, 'marketing', 'hyderabad'); 
INSERT INTO dept VALUES(20, 'finance', 'bangalore');
INSERT INTO dept VALUES(30, 'hr', 'chennai');

INSERT INTO emp VALUES(1, 'name1', 'analyst', 4, 10);
INSERT INTO emp VALUES(2, 'name2', 'associate', 3, 20);
INSERT INTO emp VALUES(3, 'name3', 'manager', 5, 20);
INSERT INTO emp VALUES(4, 'name4', 'manager', 5, 10);
INSERT INTO emp VALUES(5, 'name5', 'director', 5, 20);

/* EQUIJOIN */
SELECT * FROM emp e, dept d WHERE e.deptno=d.deptno; 
/* INNER JOIN */
SELECT * FROM emp e JOIN dept d ON e.deptno=d.deptno ORDER BY e.empno;
/* LEFT JOIN */
SELECT * FROM emp e LEFT JOIN dept d ON e.deptno=d.deptno ORDER BY e.empno;
/* RIGHT JOIN */
SELECT * FROM emp e RIGHT JOIN dept d ON e.deptno=d.deptno ORDER BY e.empno;
/* NO FULL JOIN in MySQL
 * SELECT * FROM emp e FULL JOIN dept d ON e.deptno=d.deptno ORDER BY e.empno;
 */
 
 SELECT * FROM emp e LEFT JOIN dept d ON e.deptno=d.deptno
 UNION ALL
 SELECT * FROM emp e RIGHT JOIN dept d ON e.deptno=d.deptno
 
/* CROSS JOIN */	 
SELECT * FROM emp e CROSS JOIN dept d;

/*
Harry Potter and his friends are at Ollivander's with Ron, finally replacing Charlie's old broken wand.
Hermione decides the best way to choose is by determining the minimum number of gold galleons needed to buy 
each non-evil wand of high power and age. Write a query to print the id, age, coins_needed, and power of the 
wands that Ron's interested in, sorted in order of descending power. If more than one wand has same power, 
sort the result in order of descending age.
*/
CREATE TABLE wands (
id NUMERIC,
w_code NUMERIC,
coins_needed NUMERIC,
w_power NUMERIC,
PRIMARY KEY(id),
FOREIGN KEY(w_code) REFERENCES wands_property(w_code)
);

CREATE TABLE wands_property (
w_code NUMERIC,
age NUMERIC,
is_evil NUMERIC,
PRIMARY KEY(w_code)
);

INSERT INTO wands_property VALUES(1, 45, 0);
INSERT INTO wands_property VALUES(2, 40, 0);
INSERT INTO wands_property VALUES(3, 4, 1);
INSERT INTO wands_property VALUES(4, 20, 0);
INSERT INTO wands_property VALUES(5, 17, 0);
 

INSERT INTO wands VALUES(5, 1, 6020, 2);
INSERT INTO wands VALUES(9, 1, 1647, 10);
INSERT INTO wands VALUES(14, 2, 5408, 1);
INSERT INTO wands VALUES(18, 2, 3312, 3);
INSERT INTO wands VALUES(11, 2, 7587, 5);
INSERT INTO wands VALUES(15, 2, 6018, 7);
INSERT INTO wands VALUES(17, 2, 8798, 7);
INSERT INTO wands VALUES(6, 2, 6773, 7);
INSERT INTO wands VALUES(10, 4, 504, 5);
INSERT INTO wands VALUES(16, 4, 7710, 5);
INSERT INTO wands VALUES(19, 4, 7651, 6);
INSERT INTO wands VALUES(1, 4, 3688, 8);
INSERT INTO wands VALUES(20, 5, 5689, 3);
INSERT INTO wands VALUES(12, 5, 9897, 10);

SELECT w.id, wp.age, MIN(w.coins_needed) AS min_coins, w.w_power
FROM wands w JOIN wands_property wp 
WHERE wp.is_evil = 0 AND w.w_code=wp.w_code
GROUP BY w.w_power, wp.age

SELECT 
w.id, wp.age, w.coins_needed, w.w_power
FROM 
(
SELECT 
w.id, wp.age, MIN(w.coins_needed) AS min_coins, w.w_power
FROM wands w JOIN wands_property wp 
WHERE wp.is_evil = 0 AND w.w_code=wp.w_code
GROUP BY w.w_power, wp.age 
) sub,
wands w, wands_property wp 
WHERE w.w_code=wp.w_code AND sub.min_coins=w.coins_needed AND sub.age=wp.age
ORDER BY w.w_power DESC, wp.age DESC;


/*Write a query to print the hacker_id, name, and total score of the hackers ordered by 
the descending score. If more than one hacker achieved the same total score, then sort 
the result by ascending hacker_id. Exclude all hackers with a total score of 0 from your result.
*/

INSERT INTO submissions VALUES(1, 90411, 66730, 30);

SELECT *, MAX(s.score) AS max_score FROM submissions s
GROUP BY s.challenge_id, s.hacker_id

SELECT h.hacker_id, h.h_name, SUM(max_score) FROM 
(SELECT *, MAX(s.score) AS max_score FROM submissions s
GROUP BY s.challenge_id, s.hacker_id) sub,
hackers h WHERE h.hacker_id=sub.hacker_id
GROUP BY sub.hacker_id
HAVING SUM(max_score) > 0
ORDER BY sub.max_score DESC, h.hacker_id;
