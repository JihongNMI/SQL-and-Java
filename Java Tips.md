# 0. cmd에서
긴 파일 이름 일부분만 입력하고 tab 누르면 전체 완성이 되는 듯

# 1. eclipse 단축키
한줄 지우기 : Ctrl + d

줄 정리 : Ctrl + shift + f

emmet처럼 빨리 치기 : syso Ctrl + space = System.out.println()

>응용 : 클래스. Ctrl+space = 각종 기능

줄 빨리 넘기기 : Ctrl + Enter Enter, Shift + Enter

실행 : Ctrl + F11

자동 임포트 단축키 : Ctrl + Shift + o

student.age에서 Ctrl누른 채로 커서를 갖다 대고 클릭하면 원래 그게 나온다 : Open Declaration

# 2. 아직도 잘 까먹는 거
>스캔
import java.util.Scanner;
>
Scanner sc = new Scanner(System.in);

# 5. Java랑 C++이 대표적인 오버로딩을 지원하는 언어(객체지향언어)
System.out.println만 해도 오버로딩으로 만든 대표적인 예시

C에는 없고 파이썬도 없는 거나 다름없

# 5-1. 그래서 생성자 오버로딩을 하면
생성자를 안 만들면 자동으로 Npc(){}가 생기고

생성자를 커스텀해서 만들면 기본생성자는 안생겨서 이것도 쓰고 싶으면 직접 이걸 추가

그리고 오버로딩이 가능
```
package chapter9;

public class Npc {
	String name;
	int hp;
	String appeal;
	
	Npc(){
		
	}
	
	Npc(String name, int hp, String appeal){
		this.name = name;
		this.hp=hp;
		this.appeal=appeal;
	}
	
	
	
	//자기소개
	void say() {
		System.out.println("안녕 나는 "+name+"입니다");
		System.out.println(appeal);
	}
	
	//데이터 변경
	void setHp(int hpData) {
		hp = hpData;
	}
	
}
```


```
			Npc npc2 = new Npc();
			
			npc2.name = "요리사";
			npc2.hp = 90;
			npc2.appeal = "김치를 싸서 드셔 보세요";
```
```
Npc npc3 = new Npc("대장장이",90,"하하하 이녀석 하하하");
```

# 5-2. Source-Generate Constructor..로 자동생성 가능


# 6. 디버그

🔵 파란 동그라미 ; 일반 Breakpoint ;	해당 줄에서 코드 실행 시 멈춤

🟢 녹색 C가 있는 동그라미 ;	Class Load Breakpoint ;	클래스가 JVM에 로딩될 때 멈춤 (코드 실행 전)

F5 스텝인투 : 안으로

F6 스텝오버 : 안으로 안가고 다음

F7 스텝리턴 : 안으로 갔지만 다됐다 싶을때

# 7. 체킹하는 변수는 boolean이 더 편할 수도 있다

check = check+1; 하면 계속 늘어날 때 불편할 수도 있는 경우가 잇고
