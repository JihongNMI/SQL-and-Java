# 1. 어색하지만 확실한 것

🤷‍♀️에러난다
```
public class Ex01_MethodType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex01_MethodType.sayhello();
	}

	void sayhello() {
		System.out.println("HELLO");
	}
	
}
```

✨
좋은 시도입니다! 하지만 현재 작성한 코드는 컴파일 에러가 발생합니다.

그 이유와 해결 방법을 설명드릴게요.

sayhello()는 static이 아닌 인스턴스 메서드

main()은 static 메서드

static 메서드에서 인스턴스 메서드인 sayhello()를 직접 호출할 수 없음

```
public class Ex01_MethodType {

    public static void main(String[] args) {
        Ex01_MethodType obj = new Ex01_MethodType();
        obj.sayhello();  // 인스턴스를 통해 호출
    }

    void sayhello() {
        System.out.println("HELLO");
    }
}
```

sayhello()를 그대로 둘 수 있고, main() 안에서 new로 객체를 생성해서 호출합니다.

혹은

```
public class Ex01_MethodType {

    public static void main(String[] args) {
        Ex01_MethodType.sayhello();  // 이제 정상 작동
    }

    static void sayhello() {
        System.out.println("HELLO");
    }
}
```
static으로 바꾸면 클래스 이름으로 직접 호출 가능해져서 main()에서 에러 안 납니다.


# 2. 어색함을 해소

🤷‍♀️Ex01_MethodType obj = new Ex01_MethodType(); 이 문장이 좀 이해가 안가는데

✨
이건 Java 문법의 특성 때문이고, 객체지향 언어의 공통된 패턴 중 하나입니다.

앞의 Ex01_MethodType: 변수의 **타입(type)**을 나타냅니다.

new Ex01_MethodType(): 객체를 생성하기 위해 **생성자(constructor)**를 호출하는 부분입니다.

🤷‍♀️int obj = new int(); 처럼 보이는데 어색한데ㅡ내가 어색하게 느끼는건 앞에 적은 ex01...을 뒤에 또 괄호로 쓰고 있다는 점이지

✨비유로 이해하기

📦 "상자 타입은 '과자상자'이고, 새 과자상자를 만든다"

과자상자 box = 새로운 과자상자();  // 말은 이상하지만, 뜻은 분명하죠

앞의 과자상자는 "이 변수에는 어떤 걸 담을 수 있는지" (자료형)

뒤의 새로운 과자상자()는 실제로 "그 과자상자를 하나 만들어라" (생성자 호출)

즉, Java에서는 이걸 명시적으로 구분해서 써야만 하는 문법입니다.

🤷‍♀️이게 다를 일은 없는거네?

✨
맞아요, 이 두 부분은 역할이 완전히 다르지만, 이름이 똑같아서 헷갈릴 뿐이지 전혀 다른 역할을 합니다.

앞에 쓰인 Ex01_MethodType은 **변수의 타입(type)**을 지정하는 부분

뒤에 쓰인 new Ex01_MethodType()은 실제 객체(인스턴스)를 생성하는 생성자 호출 부분

그래서 보기에 똑같아 보여도 기능은 다르고, Java 문법에서 꼭 이렇게 써야 합니다.

🤷‍♀️Scanner sc = new Scanner(System.in);

# 3. Static은

🤷‍♀️왜 Static을 안 쓰지?

✨static 안 쓰는 이유는?
"객체를 먼저 만들고, 그 객체를 통해 행동(메서드)을 하도록"
유도하기 위해서입니다.

✅ 객체지향 프로그래밍의 핵심인
"객체를 중심으로 기능과 데이터를 묶어서 사용"하는 철학을 지키기 위해서입니다.

**OOP 철학에서는 static은 도우미 클래스(utility class)**로 한정하는 게 좋다고 봅니다
>객체와는 무관한 도구적인 기능 (예: Math.max(), System.out.println())
>
>프로그램 시작점 (main 메서드)
>
>공통적으로 쓰이는 상수, 유틸 메서드

# 4. public static

🤷‍♀️public static는 static이랑 무슨 차이지?

✨예를 들어:

public static void main(String[] args)

public → JVM이 어디서든 이 메서드를 실행할 수 있도록 접근 허용

static → JVM이 객체를 생성하지 않고도 바로 호출할 수 있도록 지정

즉, main 메서드에 public static이 꼭 필요한 이유는:

JVM이 프로그램 시작 시, 클래스의 인스턴스를 생성하지 않고

외부에서 main() 메서드를 직접 호출해야 하기 때문이에요.

# 5. 내친김에 Scanner에 대해서

Scanner sc = new Scanner(System.in);라고 주로 쓰잖아. System.in은 왜 굳이 들어있지?

System.in은 **"키보드 입력을 의미하는 입력 스트림(InputStream)"**입니다.

Scanner는 어떤 입력 소스든 받아서 처리할 수 있는데,

우리가 자주 쓰는 **"키보드 입력"**을 사용하려면 System.in을 넘겨줘야 합니다.

✅ 그럼 System.in은 정확히 뭐냐?

요소	의미

System	Java가 제공하는 유틸리티 클래스 (표준 입출력 등 담당)

in	System 클래스 안에 있는 표준 입력 스트림 (InputStream)

즉, System.in	키보드 입력을 의미하는 InputStream 객체입니다

# 5-1. 스캐너 추가

```
Scanner sc = new Scanner("apple banana carrot"); 
while (sc.hasNext()) { System.out.println(sc.next()); } 이건 출력결과가?
```

기본적으로 Scanner는 **공백(스페이스, 탭, 줄바꿈 등)**을 기준으로 입력을 토큰 단위로 분리합니다.

sc.hasNext() → 다음 토큰이 있는 동안 반복

sc.next() → 다음 토큰을 읽어옴

apple

banana

carrot

hasNext()	더 읽을 단어(토큰)가 있으면 true
next()	공백 기준으로 단어 하나 읽음
