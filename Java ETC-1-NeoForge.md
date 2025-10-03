# 1. 네오포지를 깔아본다

## 1) 처음 까는데

Install client	💻 클라이언트용: 네가 만든 모드를 직접 게임에서 테스트하거나 플레이할 때 사용

Install server	🖥️ 서버용: 다른 사람과 멀티플레이 서버를 만들고 거기서 모드 적용할 때 사용

모드 개발자에게 중요한 건?

처음 모드를 만들고 테스트하려면 클라이언트가 필요해

서버는 나중에 네 모드를 멀티에 올릴 때 설치하면 돼

## 2) github애서 MDK를

1. ✅ 어떤 걸 선택하는 게 좋을까?

프로젝트 규모 / 필요성	추천 플러그인

처음 모드 개발, 단일 버전	ModDevGradle

여러 버전 타겟 또는 복잡한 구조 필요	NeoGradle

그래서 ModDev로

2. ✅ 어떻게 받지? 

리포지토리 메인 페이지에서 “Code” 버튼 클릭

“Download ZIP” 을 선택

3. ✅ 폴더 : D:\Dev\MinecraftMod\MDK-1.21.9-ModDevGradle-main 로 함

✅ Eclipse에서 MDK 프로젝트 열기 (ModDevGradle 기준)

Eclipse 실행

메뉴에서 File → Import... 선택

Gradle → Existing Gradle Project 선택 후 Next

Project root directory에서 압축 푼 MDK 폴더 경로 지정 (예: D:\MinecraftMod\MDK-1.21.9-ModDevGradle-main)

Finish 클릭하면 Gradle 프로젝트로 불러와짐

빌드가 자동으로 시작되고 필요한 라이브러리들이 다운로드됨

4. runClient 가 없어서 막힘
5. cmd에서 gradlew runClient 실행하니 java 버전이 딸린다고...
6. 그래서 JAVA SE 21을 설치하기로
