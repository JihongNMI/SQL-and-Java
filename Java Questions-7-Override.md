# 0. 이름 복습

- 생성자, 접근자, 설정자

# 1. 우리 차근차근 절차를 써봐요



# 1. 하나 새로 알게 된 사실

toString은 원래 있는 것이고 
```
@Override
	public String toString() {
		return "책이름 " + title + "페이지 " + pages + "작가 " + writer;  
	}
```
보통 이렇게 @Override를 해서 코드를 짜더라


# 2. 또 새로 알게 된 사실

🤷‍♀️상속받았음에도 그냥 바로 쓰지는 못한다?

✨맞아요, 핵심을 정확히 짚으셨어요!
자바에서 상속을 받았다고 해도 "private"으로 선언된 변수는 자식 클래스에서 직접 사용할 수 없습니다.


```
	@Override
	public String toString() {
		return "책이름 : " + getTitle() +  "    페이지 : " + getPages() + "    작가 : " + getWriter() + "   날짜 : " + Date;  
	}

```
>Date는 자기꺼라서 그대로 사용했음

# 3. 음~
