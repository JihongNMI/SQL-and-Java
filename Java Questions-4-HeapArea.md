# 1. 스택은 그거

함수 호출 시 생성되는 **지역 변수들(primitive 타입 변수, 참조 변수)**이 저장되는 공간

함수 호출 시 쌓였다가, 함수가 끝나면 바로 사라짐 (LIFO 구조)

메모리 할당과 해제가 빠름

🤷‍♀️일단 지역변수라는건 num1을 말하는거지

✨맞아요! 여기서 말하는 지역 변수란 바로 num1, num2, result 같은 변수를 의미해요.

# 2. 힙은 객체(인스턴스)가 저장되는 공간?

🤷‍♀️
```
package chapter10;

public class Ex02_MemoryInHeap1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book book1 = new Book();
		Book book2 = new Book();
		book1.num = 10;
		book2.num = 20;
		System.out.println(book1.num);
		System.out.println(book1);
		System.out.println(book2.num);
		System.out.println(book2);
		
		book2 = book1;
		System.out.println(book2.num);
		System.out.println(book2);
		
		book1 = null;
		book2 = null;
	}

}
```
를 예로 들면 객체는 book1, 2인거야 10, 20인거야?

✨객체는 book1, book2가 아니라 new Book()으로 만들어진 힙에 있는 각각의 Book 인스턴스예요.

book1, book2는 그 객체들을 가리키는 참조 변수일 뿐입니다.

10, 20은 각각 book1 객체와 book2 객체 내부의 num 필드 값입니다.

🤷‍♀️힙 영역에 생성된 객체는 1개인거야 2개인거야

✨힙 영역에 생성된 객체는 처음엔 2개입니다!

🤷‍♀️new Book()으로 만든게 book1인데 book1은 객체가 아니라고?

1. new Book()

힙 영역에 실제 객체(인스턴스)를 생성하는 명령어예요.

즉, new Book()이 실행되면 메모리에 실제 책(Book) 객체가 하나 만들어집니다.

2. book1

이건 **참조 변수(reference variable)**예요.

book1 변수는 스택에 저장되며, 힙에 생성된 객체의 주소(참조값)를 가리킵니다.

쉽게 비유하면

new Book() → 책상 아래(힙)에 실제 책 한 권을 만들었어요

book1 → 책상 위(스택)에 그 책이 어디에 있는지 알려주는 ‘책 위치 표시’ 쪽지가 있어요

그래서

book1은 객체가 아니라, 객체를 가리키는 변수입니다.

new Book()으로 힙에 생성된 것이 실제 객체입니다.

🤷‍♀️그럼 그 객체를 가르킬 때는 뭐라고 표현해야해?

✨book1 변수는 힙에 있는 Book 객체를 참조(reference)하고 있다.

book1은 Book 객체의 **참조 변수(reference variable)**이다.

book1은 Book 객체를 가리키고 있다.
