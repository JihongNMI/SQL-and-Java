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
