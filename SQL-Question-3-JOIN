# 1. OUTER JOIN은 방향 가르킨 쪽이 기준

🤷‍♀️SELECT s.name, p.name FROM student s RIGHT OUTER JOIN professor p ON (s.profno = p.profno);

✨❓ 무슨 뜻이냐면:

모든 교수(professor)를 기준으로,
해당 교수에게 배정된 학생(student)이 있다면 학생 이름도 함께 보여줘,
그런데 학생이 없어도 교수는 반드시 결과에 포함되도록 해줘.

```
김 이
박 최
x  장
```

🤷‍♀️학생은 왼쪽인데 왜 right outer join 하면 학생이 빠져?

🎯 핵심 원리

OUTER JOIN에서 중요한 건 **"어느 테이블을 기준으로 전부 보여줄지"**예요.

LEFT OUTER JOIN → 왼쪽 테이블 기준으로 전부 보여줌

RIGHT OUTER JOIN → 오른쪽 테이블 기준으로 전부 보여줌

🤷‍♀️여기선 그냥 left outer join으로 바꾸기만 해도 학생 기준이 돼?

✨네! ✅ 정확히 맞습니다.
