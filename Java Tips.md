# 1. eclipse 단축키
한줄 지우기 : Ctrl + d

줄 정리 : Ctrl + shift + f

emmet처럼 빨리 치기 : syso Ctrl + space = System.out.println()

>응용 : 클래스. Ctrl+space = 각종 기능

줄 빨리 넘기기 : Ctrl + Enter Enter, Shift + Enter

실행 : Ctrl + F11

자동 임포트 단축키 : Ctrl + Shift + o


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
