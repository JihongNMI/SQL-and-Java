# 1. 달력 만들기에서 왜 MAX를 썼을까

🤷‍♀️SELECT max(decode(day,'sun',dayno)) SUN ?

✨의미

day가 'sun'인 행들의 dayno 중 가장 큰 값을 가져온다

즉, 일요일(sun)에 해당하는 가장 큰 dayno 값을 조회

🤷‍♀️dayno에 1~31까지 있는데, decode를 7개 쓰면 값이 7개밖에 안 나올텐데, 왜 달력이 만들어지지?

✨정확히 말하면, DECODE를 7번 쓰면 실제 값은 7개가 맞지만,

그걸 GROUP BY 또는 SELECT 범위 내에서 MAX, MIN, CASE, DECODE 등과 함께 조합하면,

1개월치 전체 달력을 만들 수 있습니다.

SELECT

  MAX(DECODE(day, 'SUN', dayno)) AS SUN,
  
  MAX(DECODE(day, 'MON', dayno)) AS MON,
  
  MAX(DECODE(day, 'TUE', dayno)) AS TUE,
  
  MAX(DECODE(day, 'WED', dayno)) AS WED,
  
  MAX(DECODE(day, 'THU', dayno)) AS THU,
  
  MAX(DECODE(day, 'FRI', dayno)) AS FRI,
  
  MAX(DECODE(day, 'SAT', dayno)) AS SAT
  
FROM cal

GROUP BY weekno

ORDER BY weekno;

🤷‍♀️잘 나오는데 궁금한게 있어 weekno로 그룹을 지정했다고 하는데, weekno는 결과 표시가 안나오네?

✨SELECT 절에 weekno 컬럼을 명시하지 않으면 결과에 나타나지 않기 때문입니다.

🤷‍♀️max가 왜 필요한지 모르겠어. 빼고 코드를 쓰면 무슨 결과가 나오지

✨예를 들어, weekno = 1인데 day = 'SUN'인 행이 두 개 이상 있으면

그냥 DECODE만 쓰면 여러 개의 값이 나오고,

SQL에서는 그룹 함수 없이 여러 값이 있으면 에러가 나요.

🤷‍♀️MAX(DECODE(day, 'sun', dayno))라는 첫 구문의 값이 왜 7일까. 28 나오는건 아니고?

✨MAX(DECODE(day, 'sun', dayno))는 한 주(weekno) 그룹 안에서 가장 큰 sun의 날짜만 가져옵니다.

즉, weekno가 1이라면 그 주의 일요일은 7일일 수도 있고,

weekno가 4라면 그 주 일요일은 28일일 수도 있어요.

🤷‍♀️내 생각한 것은 그룹 함수를 쓰기 위해서 max를 쓴 것 처럼 들리는데, 애시당초 그룹에 들어있는 sun은 하나밖에 없잖아. 그럼 굳이 max 말고 다른 함수를 써도 되는거 아냐?

✨weekno별 그룹 안에 sun 요일 데이터가 딱 한 개만 있다면,

MAX, MIN, AVG 같은 집계 함수 중 뭐를 써도 결과는 똑같아요.

MAX가 가장 흔히 쓰이고 무난해서 대부분 예제나 코드에서 MAX를 사용해요.


# 2. PIVOT 이해

🤷‍♀️달력 자체가 어려워서 pivot이 이해가 안가네. 쉬운 예시가 필요해

✨
product	month	amount

A	Jan	100

A	Feb	150

B	Jan	200

B	Feb	250


이걸 피벗하면?

피벗 쿼리

SELECT *
FROM sales
PIVOT (
  SUM(amount)
  FOR month IN ('Jan' AS Jan, 'Feb' AS Feb)
);

결과
product	Jan	Feb

A	100	150

B	200	250

FOR month IN ('Jan', 'Feb')가

month 컬럼의 값을 기준으로 새 컬럼을 만들고

SUM(amount)가

각 새 컬럼에 들어갈 값을 계산하는 집계 함수예요.

🤷‍♀️for in이 무슨 의미라고 했더라

✨FOR 뒤에 오는 컬럼명: 피벗할 기준이 되는 컬럼이에요.(즉, 어떤 컬럼의 값을 가지고 열을 만들어낼지 정하는 것)

IN 뒤에 오는 값 리스트: 그 기준 컬럼에서 어떤 값을 뽑아서 각각을 새로운 열 이름으로 만들지 정하는 부분이에요.

🤷‍♀️그럼 in 안에 들어가는건 for 안에 쓰인 값들만 가능

✨IN 안에 들어가는 값들은 FOR 절에 지정한 컬럼에 실제로 존재하는 값들 중에서 골라야 합니다.

이유는?

PIVOT은 FOR에 지정한 컬럼의 값을 기준으로 열을 만들기 때문에,

만약 IN에 FOR 컬럼에 없는 값을 넣으면

그 열은 항상 NULL로 나오거나

에러가 발생할 수 있습니다.

# 3. DECODE를 쓰는 이유

🤷‍♀️기본 emp테이블에서 부서별로 각 직급별 인원이 몇명인지 계산하기

✨
✅ 방법 1: PIVOT 사용
✅ 방법 2: GROUP BY + DECODE (옛날 방식)
SELECT
  deptno,
  COUNT(DECODE(job, 'CLERK', 1))     AS CLERK,
  COUNT(DECODE(job, 'SALESMAN', 1))  AS SALESMAN,
  COUNT(DECODE(job, 'MANAGER', 1))   AS MANAGER,
  COUNT(DECODE(job, 'ANALYST', 1))   AS ANALYST,
  COUNT(DECODE(job, 'PRESIDENT', 1)) AS PRESIDENT
FROM emp
GROUP BY deptno

🤷‍♀️pivot을 안쓴다고 가정했을 때 방법은 decode를 꼭 써야하나?

✨
✅ 가능한 대안들 (Oracle 기준)
방법	설명
DECODE	전통적인 Oracle 방식 (가장 널리 쓰임)
CASE WHEN	DECODE보다 더 범용적이고 가독성 좋음, ✅ 표준 SQL 구문
FILTER	일부 DBMS에서만 지원 (Oracle은 ❌)

🤷‍♀️지금 decode를 쓰는건 clerk 등을 숫자로 바꾸고 싶어서인건가?

✨직급(job) 값들을 숫자(1 또는 NULL)로 바꿔서, COUNT, SUM 등 집계 함수로 세기 쉽게 만들기 위해서입니다.

# 4. PIVOT 이해 2 : FROM에

🤷‍♀️음 이상하네 select * from emp pivot ( count(empno) for job in ('CLERK', 'MANAGER', 'PRESIDENT', 'ANALYST', 'SALESMAN') ) ORDER BY deptno; 이거 하니까 ename mgr hiredate...comm 까지 나온 뒤에 deptno clerk가 나와

✨🔍 왜 그런 일이 벌어졌을까?

PIVOT은 FROM 절에서 들어온 데이터셋에 대해 피벗을 적용합니다.

SELECT * FROM emp처럼 바로 테이블을 주면,

Oracle은 모든 열을 다 가져온 다음,

피벗된 값들을 그냥 추가 열로 덧붙이는 방식으로 동작하는 것처럼 보입니다.

사실상 이는 Oracle의 내부 처리 방식의 유연성이지, 일반적인 권장 방식은 아닙니다.

🤷‍♀️SELECT * FROM ( SELECT deptno, job, empno FROM emp ) 랑 SELECT deptno, job, empno FROM emp 의 차이는 이 구문에서 있어?

✨
SELECT deptno, job, empno FROM emp	❌ 안 됨	PIVOT은 FROM 절에서 바로 사용해야 하는데, 여기선 직접 PIVOT을 붙일 수 없음
SELECT * FROM (SELECT deptno, job, empno FROM emp)	✅ 됨	이 형태는 FROM (subquery) 안에서 데이터를 먼저 만들어서, 그 위에 PIVOT을 적용 가능

Oracle에서 PIVOT 문법의 위치는 FROM 절 안입니다.

# 5. 정렬 문구는 결국 넣어야 한다

🤷‍♀️SELECT empno, ename, job, sal, rank() OVER (ORDER BY sal) FROM emp; 그러고보니 정렬이 알아서 되네

✨
윈도우 함수의 ORDER BY만 있을 때	순위 계산은 제대로 되지만, 출력 순서는 보장 안 됨
전체 쿼리 마지막에 ORDER BY 있을 때	출력 결과가 확실히 정렬됨

그래서 보통은 안전하게 결과를 정렬하고 싶으면,
윈도우 함수와 별개로 쿼리 마지막에 ORDER BY를 꼭 씁니다!

# 6. 정렬? ORDER BY?

🤷‍♀️누적합을 구하려고 하는데

SELECT p_code, p_store, p_date, p_qty, P_total, sum(p_total) over(PARTITION BY p_store) FROM panmae; 원하는대로 안나왔어

✨혹시 **원하는 출력 형태가 합계가 아니라 누적합(=running total)**이라면
ORDER BY도 추가해야 해요:

🤷‍♀️누적합을 구하기 전에 일단 이 코드로는 왜 값이 똑같이 연속으로 나오는지 알아야겠어

✨이건 각 p_store 그룹 전체의 합계를 계산해서, 해당 그룹에 속한 모든 행에 그 값을 똑같이 채워 넣는 것입니다.

즉, 집계는 한 번, 출력은 여러 번!

🤷‍♀️왜 order by를 써야 누적합이 나오지?

✨✅ SQL에서 누적합을 만들려면?

SQL은 데이터를 테이블로 저장된 상태만 보고는
"어떤 순서로 더해야 하는지"를 알 수 없습니다.

그래서 ORDER BY가 필수인 거예요.

여기서 ORDER BY p_date를 통해 "누적할 순서"를 정해줌

→ 1월 → 2월 → 3월 순서로 누적

🤷‍♀️order by는 단순히 정렬인 줄 알았는데 뭔가 모르는 게 있나 보네

✨많은 분들이 **ORDER BY는 그냥 정렬만 하는 거 아니야?**라고 생각하지만,
윈도우 함수(OVER) 안에서의 ORDER BY는 완전히 다른 의미를 가집니다.

✅ 정리 먼저: ORDER BY의 두 얼굴
위치	역할
쿼리 맨 끝 (ORDER BY)	결과 출력 순서 정렬
윈도우 함수 안 (OVER (...) ORDER BY ...)	계산 순서 지정, 특히 누적합, 순위, 차이 계산 등에 사용

⚠️ 이 ORDER BY는 계산을 위한 정렬입니다.

결과를 정렬해주는 건 아님!

→ 그래서 이걸 보면 정렬된 것처럼 보이지만,
결과 출력 순서는 보장되지 않아요.
→ 진짜 정렬은 쿼리 맨 끝에서 다시 해줘야 해요.

💡 대표적으로 영향을 받는 윈도우 함수들
함수	OVER 안에 ORDER BY 필요?	설명
SUM(...)	누적합이면 필요	ORDER BY 없으면 전체합만 나옴
ROW_NUMBER()	꼭 필요	순번을 정하려면 순서 필요
RANK()	꼭 필요	동점 순위 줄 때 순서 기준 필요
LAG() / LEAD()	보통 필요	이전/다음 행 기준이 되는 순서 필요

✅ 요약 한 줄

ORDER BY는 위치에 따라 의미가 다르다!
출력 정렬이 아니라, 윈도우 함수 안에서는 "계산 순서 지정" 역할을 한다.
