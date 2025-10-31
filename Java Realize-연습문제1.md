# 1. 숫자 맞추기에서 : return false

```
❌ 문제 원인

NumberGame 클래스 안의 check() 메서드(현재는 Check)에
모든 경우에 대해 return이 보장되지 않기 때문이에요.

자바는 “모든 실행 경로에서 반드시 값을 반환해야 하는” 규칙이 있습니다.
그런데 지금 코드에서는 마지막 if (player == answer) 문이 true일 때만 return true;가 실행되고,
그 외의 경우에 대비한 return 문이 마지막에 없어서
컴파일러가 “혹시 반환 안 할 수도 있잖아?” 라고 에러를 냅니다.

✅ 해결 방법 1 — 마지막에 return false; 추가
```

완성코드

```java
import java.util.Random;
import java.util.Scanner;

class NumberGame
{
	final private int answer;
	private int count;
	
	public NumberGame(int answer) {
		this.answer = answer;
		this.count = 0;
	}
	
	public boolean check(int player)
	{
		count++;
		
		if(player < answer) {
			System.out.println("더 큰 수입니다.");
			return false;
		}
		else if(player > answer) {
			System.out.println("더 작은 수입니다.");
			return false;
		}
		if(player == answer) {
			System.out.println(count + "회 만에 맞췄습니다.");
			return true;
		}
		
		System.out.println("혹시 에러가 난 거 아닌지 확인해보세요");
		return false;
		
	}
	
}

public class Q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
			System.out.println("=== 숫자맞추기 게임을 시작합니다. ===");
			
			Random rand = new Random();
			final int answer = rand.nextInt(100)+1;
			
			if(answer % 2 == 0) System.out.println("힌트는 짝수입니다");
			else if(answer % 2 == 1) System.out.println("힌트는 홀수입니다");
			
						
			NumberGame game = new NumberGame(answer);
			Scanner sc = new Scanner(System.in);
			
			while(true){
				System.out.print("1~100 사이의 값을 입력 >> ");
				int player = sc.nextInt();
				if(game.check(player) == true) break;
			}
			
			System.out.println("=== 게임을 종료합니다. ===");
	}

}


```



