# 1. 아직 모르는 부분이 많다



# 2. SQL 테이블 연결 첫 부분
```
...get set코드...
```
🤷‍♀️여기까지 했는데, 이 테이블은 null값이 있는것에 대해서 어떻게 해줘야 하지?

✨ Wrapper 클래스 사용 (null 허용) ← 더 정확한 표현

int	Integer, double	Double, boolean	Boolean

🤷‍♀️wrapper를 모르겠는데 일단 궁금한 건 자바에서 null을 뭐라고 확인하지?

✨자바에서 null을 확인하려면?	if (변수 == null)

기본형도 null이 되나?	❌ 안 됨 (int, double 등은 null 불가)

null을 쓰려면?	래퍼 클래스(Integer, Double)를 써야 함

🤷‍♀️그럼 if(mgr<0||mgr>9999 || mgr==null)이라고 쓰면 오류가 나나?

✨mgr이 null인 상태에서 mgr < 0을 먼저 실행하려다 NullPointerException 또는 컴파일 오류가 나요.

✅ 해결 방법: null 체크를 먼저 하자

앞에 썼다고 해도 int면 에러가 나나?

✨네, int 타입이면 mgr == null 자체가 컴파일 에러입니다.

✔ null 처리를 하고 싶다면 Integer를 써야 함
