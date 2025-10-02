# 1. 너는 아직도 클래스가 헷깔린다
일단 백지에서 만드는 요령을 알아보자

## 스캐너를 기억한다면 대충 윤곽이 보일것이다.
```
Scanner sc = new Scanner(System.in);
```
1. Scanner: 자바에서 제공하는 클래스 이름이에요.
2. sc: Scanner 타입의 변수 이름(참조변수)입니다. : 이걸로 sc.뭐시기()를 함 : sc.next();
3. new Scanner(System.in): Scanner 클래스의 생성자를 호출해서 객체를 새로 만드는 작업이에요.
new는 "새로운 객체 생성"을 뜻하고 System.in은 '키보드 입력 스트림' (키보드로부터 입력받는 통로) 입니다.

그래서 new Scanner(System.in) 은 "키보드 입력을 처리하는 Scanner 객체"를 만드는 것.
