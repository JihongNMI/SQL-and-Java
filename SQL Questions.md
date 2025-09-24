# 1. 달력 만들기에서 왜 MAX를 썼을까

🤷‍♀️SELECT max(decode(day,'sun',dayno)) SUN ?

✨의미

day가 'sun'인 행들의 dayno 중 가장 큰 값을 가져온다

즉, 일요일(sun)에 해당하는 가장 큰 dayno 값을 조회

dayno에 1~31까지 있는데, decode를 7개 쓰면 값이 7개밖에 안 나올텐데, 왜 달력이 만들어지지?

정확히 말하면, DECODE를 7번 쓰면 실제 값은 7개가 맞지만,

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
