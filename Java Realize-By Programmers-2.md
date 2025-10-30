# 0. 스트림 패키지 말인데
import java.util.*; 는 util 패키지 안에 있는 클래스들만이라서(그 밑에 폴더들의 클래스는 X)
import java.util.stream.*;
해야된다

# 자동 들여쓰기
Eclipse에서 자동 들여쓰기: Ctrl + Shift + F (코드 포맷팅)

---

# 1. 스트림이랑 람다식 말인데[기초]

```java
import java.util.stream.LongStream;

class Solution {
    public long[] solution(int x, int n) {
        long[] answer = LongStream.rangeClosed(1, n)   // 1부터 n까지 생성
                                   .map(i -> (long) x * i) // x씩 증가
                                   .toArray();             // 배열로 변환
        return answer; // answer 반환
    }
}

```
1. rangeClosed는 책에 없고
2. map은 있음
  - 이 안에 있는 게 람다식
  - i는 [바깥에 없는 선언 안 한 변수]를 사용 : 지역변수
3. toArray도 책에 없음

# 2. 기초2 : Optional 반환의 처리법

```java
import java.util.stream.IntStream;

class Solution {
    public int solution(int n) {
        int answer = IntStream.range(2,n)
                                .filter(x -> n % x == 1)
                                .findFirst()
                                .getAsInt();
        return answer;
    }
}

```
1. findFirst는 말하자면 반복문의 break 역할을 해준다
2. 이것도 원래 1️⃣ findFirst() 반환 타입이

기본형 스트림에서는 OptionalInt / OptionalLong / OptionalDouble 객체를 반환, 객체 스트림(Stream<T>)에서는 Optional<T> 반환, Optional: “값이 있을 수도, 없을 수도 있음”을 나타내는 객체

라서 getAsInt()나 orElse(-1);를 사용한다

# 3. 

