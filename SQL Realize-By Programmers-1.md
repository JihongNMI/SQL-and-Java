🤷‍♀️다시 한번 물어볼게

-- 코드를 입력하세요
SELECT b.title, b.board_id, r.reply_id, r.writer_id, r.contents, r.created_date
FROM used_goods_board b JOIN used_goods_reply r ON (b.board_id = r.board_id)
-- WHERE b.created_date = '2022-10-99'
ORDER BY r.created_date, b.title;

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

