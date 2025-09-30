# 1. 생각 이상으로 고전한 이유 : 날짜 처리 방법 때문

🤷‍♀️다시 한번 물어볼게
```
-- 코드를 입력하세요
SELECT b.title, b.board_id, r.reply_id, r.writer_id, r.contents, r.created_date
FROM used_goods_board b JOIN used_goods_reply r ON (b.board_id = r.board_id)
-- WHERE b.created_date = '2022-10-99'
ORDER BY r.created_date, b.title;
```
이 코드에서, select b.board_id라고 쓰는 것과 r.board_id라고 쓰는 것의 차이가 있어?

그래 조인조건으로 동일한 board_id여야만 출력한다면, 결국 뭘로 써도 같은 거 아냐?

✨SELECT b.board_id로 쓰든, SELECT r.board_id로 쓰든 결과 값은 동일하게 나옵니다.

다만, 꼭 기억할 점!

같은 값이지만, 컬럼 자체는 다른 테이블의 컬럼이라는 점

그래서 어떤 컬럼을 선택하느냐에 따라 나중에 쿼리 유지보수나 가독성에 차이가 있을 수 있음

(예: 컬럼에 추가로 함수 적용할 때, NULL 값 처리할 때 차이 발생 가능)

🤷‍♀️보통 뭐를 쓰는게 좋아? 내가 기준을 모르겠어

✨
1. 기준 테이블에 있는 컬럼을 쓰는 게 일반적

조인에서 기준이 되는(주체가 되는) 테이블이 있어요.

예를 들어, used_goods_board가 메인 테이블이라면 b.board_id를 쓰는 게 직관적이고 보기 좋습니다.

2. 쿼리 가독성 & 유지보수 관점

나중에 쿼리 읽는 사람도

“이건 메인 테이블에서 가져온 컬럼”인지

“조인된 테이블에서 가져온 컬럼”인지 바로 알 수 있어요.

3. 컬럼에 따라 다를 수도 있음

만약 조인된 테이블의 board_id 컬럼이 의미상 다르거나, 다른 특성이 있다면 그걸 써야 할 수도 있어요.

예를 들어, r.board_id가 어떤 참조값만 있거나, b.board_id가 진짜 기준값이라면 당연히 b.board_id를 씁니다.

내가 where를 주석한 이유는 그 특정 월을 조건으로 출력하고 싶은데, 일 부분을 어떻게 써야할지?

| 방법         | 장점             | 단점                 |
| ---------- | -------------- | ------------------ |
| 날짜 범위 조건   | 인덱스 활용 가능, 명확함 | 약간 길고 귀찮음          |
| EXTRACT 함수 | 직관적, 일 무시 가능   | 함수라서 인덱스 활용 제한 가능성 |
| TO_CHAR 함수 | 간단, 문자열 비교 편리  | 함수라서 인덱스 활용 제한 가능성 |

🤷‍♀️인덱스 활용 제한은 뭔 소리야?

✨4. 성능 차이

인덱스를 활용하면 검색 속도가 수천 배 빠를 수 있는데,

함수가 들어가면 인덱스를 못 쓰니까 느려질 수 있어요.

5. 해결책

인덱스 활용이 중요한 경우, 날짜 범위 조건을 쓰는 게 좋습니다.

또는 함수 기반 인덱스(Function-based Index)를 만들어서 함수가 적용된 컬럼도 인덱스 쓸 수 있게 할 수 있어요 (고급 방법).

🤷‍♀️WHERE b.created_date >= TO_DATE('2022-10-01')만 쓰면 틀리나?

✨이렇게만 써도 문법적으로는 맞아요.

다만, 중요한 점!

TO_DATE 함수는 기본적으로 날짜 문자열과 함께 포맷 문자열을 함께 주는 게 안전하고 명확합니다.

만약 두 번째 인자인 포맷을 생략하면, DB 환경의 기본 날짜 형식(NLS_DATE_FORMAT)에 따라 해석됩니다.

이 기본 형식이 다르면 의도와 다르게 날짜가 해석될 수 있어요.

✨
다만 한 가지 팁을 드리자면, 날짜 범위 조건에서 <= to_date('2022-10-31', 'YYYY-MM-DD') 를 쓸 때, 만약 b.created_date가 시간 정보(시, 분, 초)를 포함하고 있다면, 10월 31일 00:00:00까지만 포함하게 되어 10월 31일 하루 전체 데이터는 누락될 수 있어요.

시간 정보까지 포함해서 10월 31일 전체를 포함하고 싶으면
WHERE b.created_date >= TO_DATE('2022-10-01', 'YYYY-MM-DD')
  AND b.created_date < TO_DATE('2022-11-01', 'YYYY-MM-DD')

이렇게 < 2022-11-01 (11월 1일 00:00:00 이전) 으로 하는 게 더 정확합니다.

🤷‍♀️execute command denied to user 'USERD7063D384681749DDA459097F2'@'%' for routine 'sql_runner_run.to_date' 에러가 나

✨오류 메시지 보니, 이건 사용자 권한 문제라서, to_date 함수 실행 권한이 없다는 뜻이에요.

🤷‍♀️아... to_date는 오라클만?

✨네, 맞아요! TO_DATE 함수는 Oracle의 내장 함수로, 문자열을 날짜 타입으로 변환할 때 사용합니다.

그럼 오라클이나 관계없이 공통적으로 쓰는 방법은 있어?

1. 날짜 컬럼이 날짜 타입이라면

날짜 문자열과 비교하는 방식이 가장 범용적입니다.

YYYY-MM-DD 형식의 문자열은 대부분의 DBMS에서 날짜 타입과 비교할 때 올바르게 처리됩니다.

예)

WHERE b.created_date >= '2022-10-01'
  AND b.created_date < '2022-11-01'


날짜 타입 컬럼과 문자열을 비교할 때, 대부분 DBMS가 자동으로 형변환을 해주거나 정상 비교됩니다.

2. 날짜 컬럼이 문자열 타입이라면

그냥 문자열 비교를 해도 됩니다.

'YYYY-MM-DD' 형식은 문자열 정렬과 날짜 정렬이 일치하기 때문에 범위 비교에 적합합니다.

마지막으로 이거 일자가 사실 시간이 있긴 하네. 출력은 연월일까지만 하려면?공용으로 쓰는 방법이 필요해

공용으로 쓸 수 있는, 대부분 DBMS에서 통하는 방법은 사실 함수가 아니라 —

1. 날짜/시간 타입 컬럼에서 시간 부분을 버리고,
2. 결과를 문자열(YYYY-MM-DD)로 변환하는 것인데,

DBMS마다 함수가 다르니 완전 똑같은 SQL은 없어요.

하지만! 코딩 테스트나 공용으로 쓰기 위해 가장 무난한 방법은
날짜를 문자형으로 비교할 때, 출력도 그냥 날짜 타입 컬럼을 문자열로 캐스팅해서 간단히 잘라내는 방법이에요.

예를 들어,

SELECT SUBSTR(CAST(b.created_date AS CHAR), 1, 10) AS created_date_only, ...

SUBSTR(..., 1, 10) 으로 앞 10글자만 추출 → YYYY-MM-DD 형태가 됩니다.

왜 이게 좋은가?

TO_CHAR (Oracle), DATE_FORMAT (MySQL), TO_CHAR (PostgreSQL) 같은 함수들이 다 다르지만

CAST + SUBSTR 조합은 대부분 환경에서 동작하는 경우가 많아요.

🤷‍♀️
최종적으론 이렇게 되나(mysql이였음)
```
-- 코드를 입력하세요
SELECT b.title, b.board_id, r.reply_id, r.writer_id, r.contents, SUBSTR(CAST(r.created_date AS CHAR), 1, 10)
FROM used_goods_board b join used_goods_reply r on (b.board_id = r.board_id)
WHERE b.created_date >= '2022-10-01' AND 
    b.created_date < '2022-11-01'
order by r.created_date, b.title;
```

🤷‍♀️근데 이거 Oracle에서 오류가 난다?

우여곡절 끝에 얻은 Oracle용 최종 코드
```
-- 코드를 입력하세요
SELECT b.title, b.board_id, r.reply_id, r.writer_id, r.contents, TO_char(r.created_date, 'YYYY-MM-DD')
FROM used_goods_board b join used_goods_reply r on (b.board_id = r.board_id)
WHERE b.created_date >= to_date('2022-10-01', 'YYYY-MM-DD') AND 
    b.created_date < to_date('2022-11-01','YYYY-MM-DD')
order by r.created_date, b.title;
```

🤷‍♀️결국 MySQL에선 이 코드를 쓰고, 오라클에선 위에 코드를 쓰는게  좀 더 좋아 보이네

MySQL용 최종 코드
```
-- 코드를 입력하세요
SELECT b.title, b.board_id, r.reply_id, r.writer_id, r.contents, DATE_FORMAT(r.created_date, '%Y-%m-%d')
FROM used_goods_board b join used_goods_reply r on (b.board_id = r.board_id)
WHERE b.created_date >= '2022-10-01' AND 
    b.created_date < '2022-11-01'
order by r.created_date, b.title;
```

# 1-1. 결국 여기서 얻은 교훈은 날짜는 mysql은 date_format이고 오라클은 to_date인건가...
## TO_char(r.created_date, 'YYYY-MM-DD') VS DATE_FORMAT(r.created_date, '%Y-%m-%d') 인 셈


# 2. 똑같음을 원한다면 inner join(join ... on (...)을 쓰자
🤷‍♀️
```
-- 코드를 입력하세요
SELECT fh.flavor
FROM FIRST_HALF fh LEFT JOIN ICECREAM_INFO ii ON (fh.flavor = ii.flavor)
WHERE fh.TOTAL_ORDER > 3000 AND ii.INGREDIENT_TYPE = 'fruit_based'
ORDER BY fh.TOTAL_ORDER desc;
```
inner join을 추천하던데, 원래 이런 경우 뭘 하고 싶을 때 left join인거지?

✨이런 경우에 **LEFT JOIN**을 사용하고 싶을 때는, 오른쪽 테이블의 정보가 없더라도 왼쪽 테이블의 데이터는 무조건 보고 싶을 때입니다.

1. '녹차' 맛이 ICECREAM_INFO 테이블에 아직 추가되지 않은 (즉, 성분 정보가 없는 NULL) 상태라고 가정해 봅시다.

2. 'ICECREAM_INFO'에 아직 등록되지 않은 모든 아이스크림 맛을 찾고 싶을 때

3.  원래 쿼리처럼 특정 값(fruit_based)으로 필터링하여 양쪽 테이블의 일치를 강제할 때는 INNER JOIN이 더 자연스럽습니다.

```
SELECT fh.flavor
FROM FIRST_HALF fh JOIN ICECREAM_INFO ii ON (fh.flavor = ii.flavor)
WHERE fh.TOTAL_ORDER > 3000 AND ii.INGREDIENT_TYPE = 'fruit_based'
ORDER BY fh.TOTAL_ORDER DESC;
```
