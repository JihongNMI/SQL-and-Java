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

# 2. ㅇㅇ;
