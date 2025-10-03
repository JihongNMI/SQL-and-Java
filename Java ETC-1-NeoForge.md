# 1. 네오포지'드'를 깔아본다

## 1) 처음 까는데...

Install client	💻 클라이언트용: 네가 만든 모드를 직접 게임에서 테스트하거나 플레이할 때 사용

Install server	🖥️ 서버용: 다른 사람과 멀티플레이 서버를 만들고 거기서 모드 적용할 때 사용

모드 개발자에게 중요한 건?

처음 모드를 만들고 테스트하려면 클라이언트가 필요해

서버는 나중에 네 모드를 멀티에 올릴 때 설치하면 돼

## 2) github애서 MDK를 다운

1. ✅ 어떤 걸 선택하는 게 좋을까?

프로젝트 규모 / 필요성	추천 플러그인

처음 모드 개발, 단일 버전	ModDevGradle

여러 버전 타겟 또는 복잡한 구조 필요	NeoGradle

>그래서 ModDev로

2. ✅ 어떻게 받지? 

리포지토리 메인 페이지에서 “Code” 버튼 클릭

“Download ZIP” 을 선택

3. ✅ 폴더 : D:\Dev\MinecraftMod\MDK-1.21.9-ModDevGradle-main 로 함

## 3) gradlew genEclipseRuns... [는 결국 잘 안되네; 요즘 버전은 무시해도 될듯]

이걸 진행을 안하고 했는데
> To use the NeoForge plugin, please run Gradle with Java 17 or newer. You are currently running on Java 11 (11).

가 떠서... 
1. SE 21을 설치하고
2. 환경변수 지정(JAVA_HOME 만 변경)
   
하고 다시 하니 잘 됨

> 이게 안되는데요 갑자기

가장 중요한 점: runClient가 작동하므로, 프로젝트 자체는 이미 정상입니다. 

대부분의 경우 방법 1처럼 Eclipse의 내장 Gradle Import 기능을 사용하는 것이 최신 MDK 환경에서는 가장 빠르고 정확한 해결책입니다.

# 2. Eclipse에서 MDK 프로젝트 열기 (ModDevGradle 기준) : MDK를 임포트

메뉴에서 File → Import... 선택

Gradle → Existing Gradle Project 선택 후 Next

Project root directory에서 압축 푼 MDK 폴더 경로 지정 (예: D:\MinecraftMod\MDK-1.21.9-ModDevGradle-main)

Finish 클릭하면 Gradle 프로젝트로 불러와짐

빌드가 자동으로 시작되고 필요한 라이브러리들이 다운로드됨

# 3. AI가 말하는 runClient 가 어디에도 없어서 없어서 막힘

이 점은 결국 최신 버전? 이 mod development 안에 있는 runClient를 하면 되는 것으로...(맞겠지?)

현재 마크는 1.21.9이다

특히 앞서 말한 gradlew genEclipseRuns 같은게 잘 안되서 지웠다고 다시 만들었다가를 반복..

# 4. AI한테 예제파일 만들어달라고 했다가 안되서

또 지웠다가 반복...

결국 원래 맨 처음 있는 예제 파일이 무슨 기능인지부터 파악해보기로 함.

# 5. 뭘 해도 막히고 잘 안돼서 일단 재정리를....;;

>
지금 너 말이 꼬여있는 것 같다. 내가 명확하게 이야기해줄테니 다시 해보자
1. 나는 지금 원래 있던 자바&이클립스 위에 NeoForged랑 MDK를 설치했다. 
2. 이클립스를 실행해서, 임포트를 하고 안에 ExampleMod.java를 확인했으니, 이것이 궁금해서 Gradle Tasks, mod development 안의 runClient를 실행했더니, 마인크래프트 프로그램이 실행되었다.
3. 자. 이제 난 뭘 해야 이 예제파일이 의미하는 걸 알 수 있지? 월드를 만들어야 하나?

그래서 월드를 만들면 된다고 함.

이 월드의 생성이 헷깔린다. 1. Singleplayer인가 Create Test World인가? 2. 게임 모드는 Creative로 해야만 하는가?

싱글로 하면 되고, Creative가 확인하기 편하다고 한다

# 6. 기능을 무사히 확인해봤다.

아이템이 있다. 

1. Example Block이랑
2. Example Item이 있고,
3. Example Mod Tab이 있고
4. 마지막으로 서버 메세지가 있다고 한다(이건 서버 환영멘트 처럼 바로 확인 할 수가 없었다. 다른 방법이 있다곤 한데 이건 나중에 많이 익숙해지면 다뤄봐야겠다.)

# 7. 이제 아이템 이름만 좀 바꿔서 확인해보려고 하는데...

뭐가 이리 안되는지...;;

그냥 아이템 텍스트만 바꿨는데 왜 안돼냐???? java.lang.exceptionininitializererror가 계쏙 뜬다...

동작 확인 끝에(
1. 처음엔 일본어&특수문자
2. 영어(example_ITEM)도 안되네

크래시 레포트를 보여주니 확인해주더라

```
Exception message: net.minecraft.ResourceLocationException: Non [a-z0-9/._-] character in path of location: examplemod:example_ITEM
examplemod:example_ITEM
여기서 example_ITEM에서 _와 대문자 I가 포함되어 있습니다. 이는 Minecraft의 ResourceLocation 규칙에 맞지 않아서 에러가 발생한 것입니다.
```
3. 그래서, uri로 바꾸니, item.examplemod.uri라고 아이템 이름이 나온다;;

4. 네임스페이스. 이건 원래 자바의 용어? 아니면 이 mod 의 용어? = 이 마인크래프트 mod의 용어랜다.

# 8. 자바 문법적으로 해설을 요구했다

자바 문법을 잘 모를 때는 이런 코드가 헷갈릴 수 있습니다. 그럼 지금까지 나온 코드를 자바 문법 관점에서 하나하나 분석해볼게요.

### 1. `public static final DeferredItem<Item> EXAMPLE_ITEM = ITEMS.registerSimpleItem("example_item", new Item.Properties());`

이 구문을 단계별로 설명하겠습니다:

#### a. `public static final`

* `public`: 이 변수는 **모든 클래스에서 접근 가능**하다는 뜻입니다. 즉, 이 변수는 **어디서든 참조할 수 있다**는 것입니다.
* `static`: 이 변수는 **객체를 생성하지 않고 클래스 자체에서 접근**할 수 있다는 뜻입니다. 객체를 만들지 않아도 `ExampleMod.EXAMPLE_ITEM`처럼 클래스 이름을 통해 직접 참조할 수 있습니다.
* `final`: 이 변수는 **초기화 후 값이 변경되지 않**다는 뜻입니다. 한 번 값을 설정하면 이후에는 변경할 수 없습니다.

#### b. `DeferredItem<Item>`

* `DeferredItem`은 **아이템을 등록하기 위한 객체**입니다. 이 타입은 **나중에 아이템을 실제로 게임에 등록하는 동작을 미루고** (deferred), 등록이 완료될 때 아이템을 사용하기 위한 참조를 제공합니다.
* `<Item>`은 제네릭 타입을 지정하는 부분입니다. `DeferredItem`은 **`Item` 객체를 저장하는** 데 사용됩니다. 즉, `DeferredItem`은 `Item`의 인스턴스를 다루는 객체입니다.

#### c. `ITEMS.registerSimpleItem("example_item", new Item.Properties())`

* `ITEMS`: `DeferredRegister` 객체로, 아이템을 등록하기 위한 레지스트리입니다. `DeferredRegister.createItems(MODID)`에서 `ITEMS`는 **"examplemod"라는 네임스페이스**에 아이템을 등록할 수 있는 도구입니다.
* `registerSimpleItem`: `DeferredItem`에 아이템을 등록하는 메소드입니다. 이 메소드를 호출하면 아이템을 `DeferredItem`에 추가하고, 나중에 실제 게임에 등록됩니다.
* `"example_item"`: 등록되는 아이템의 **이름**입니다. 이 값은 리소스 경로에서 사용됩니다. 예를 들어, `examplemod:example_item`으로 등록됩니다.
* `new Item.Properties()`: `Item` 객체의 **속성(Properties)**을 설정하는 부분입니다. 아이템의 `속성`에는 여러 가지 설정이 있는데, 여기서는 `new Item.Properties().food(...)`와 같이 **음식 아이템 속성**을 추가할 수 있습니다. 이 부분은 아이템이 가진 특성들을 정의하는 부분입니다.

### 2. `public static final DeferredBlock<Block> EXAMPLE_BLOCK = BLOCKS.registerSimpleBlock("example_block", BlockBehaviour.Properties.of().mapColor(MapColor.STONE));`

이 구문도 비슷하게 이해할 수 있습니다.

#### a. `DeferredBlock<Block>`

* `DeferredBlock`: **블록을 등록하기 위한 객체**입니다. `DeferredItem`과 비슷하게, 이 객체는 **블록 등록을 나중에** 처리하도록 미루는 역할을 합니다.
* `<Block>`은 제네릭 타입입니다. `DeferredBlock`이 **`Block` 객체를 다룬다는 것을 의미**합니다.

#### b. `BLOCKS.registerSimpleBlock("example_block", BlockBehaviour.Properties.of().mapColor(MapColor.STONE))`

* `BLOCKS`: `DeferredRegister` 객체로, **블록을 등록하는 레지스트리**입니다. `DeferredRegister.createBlocks(MODID)`로 블록 등록을 준비합니다.
* `registerSimpleBlock`: 블록을 등록하는 메소드입니다. `"example_block"`이라는 이름으로 블록을 등록합니다.
* `BlockBehaviour.Properties.of()`: 블록의 **속성(Properties)**을 설정합니다. `BlockBehaviour.Properties`는 블록이 어떻게 동작할지를 결정하는 다양한 속성을 설정할 수 있습니다.
* `.mapColor(MapColor.STONE)`: 블록의 색상을 지정하는 속성입니다. 여기서는 `MapColor.STONE`을 지정해서, 블록의 색상이 돌처럼 보이도록 설정합니다.

### 3. `public static final DeferredHolder<CreativeModeTab, CreativeModeTab> EXAMPLE_TAB = CREATIVE_MODE_TABS.register("example_tab", () -> CreativeModeTab.builder()...);`

이 구문은 **아이템이 속할 창 탭(Creative Tab)을 정의하는 부분**입니다.

#### a. `DeferredHolder<CreativeModeTab, CreativeModeTab>`

* `DeferredHolder`: 이 객체는 **크리에이티브 모드 탭**을 등록하는 역할을 합니다. `CreativeModeTab`은 **아이템이나 블록을 그룹화해서 보여주는 UI 탭**입니다.
* `<CreativeModeTab, CreativeModeTab>`: 제네릭 타입으로, `DeferredHolder`는 **`CreativeModeTab`을 다루는 객체**입니다.

#### b. `CREATIVE_MODE_TABS.register("example_tab", () -> CreativeModeTab.builder()...)`

* `CREATIVE_MODE_TABS`: `DeferredRegister` 객체로, **크리에이티브 모드 탭을 등록**하는 레지스트리입니다.
* `register`: 탭을 등록하는 메소드입니다. `"example_tab"`이라는 이름으로 탭을 등록합니다.
* `CreativeModeTab.builder()...`: 크리에이티브 모드 탭을 **빌드**하는 코드입니다. 아이템을 이 탭에 추가하고, 탭의 아이콘을 설정합니다.

### 자바 문법적인 해석

* **클래스 선언**: `public class ExampleMod`로, 클래스의 시작을 나타냅니다.
* **상수 선언**: `public static final`을 사용해 값이 한 번 설정되면 변경되지 않는 변수를 선언합니다.
* **제네릭 타입**: `DeferredItem<Item>`과 같은 형태는, 특정 타입(여기선 `Item`이나 `Block`)을 **유연하게 다룰 수 있도록 도와주는** 제네릭 문법입니다.
* **메소드 호출**: `.registerSimpleItem()`, `.registerSimpleBlock()`, `.builder()` 등의 부분은 해당 객체에 설정된 **메소드**들을 호출하여 아이템이나 블록의 등록을 준비하고, 다양한 속성을 설정합니다.

### 결론

이 코드에서 주로 사용된 자바 문법은 **클래스 정의**, **상수 선언**, **제네릭**, **메소드 호출** 등이며, Minecraft Modding에서 객체를 등록하고, 그 객체의 속성을 설정하는 방식을 사용하고 있습니다. 이 코드는 자바 문법을 기반으로 작성되었으며, Minecraft의 **모드 등록 시스템**을 위한 로직을 포함하고 있습니다.

아이템 이름을 변경하려면 `"example_item"`을 원하는 이름으로 바꾸면 됩니다. 다만, `아이템 ID`와 관련된 규칙(소문자, 숫자, 언더스코어 `_`만 사용 가능)을 지켜야 한다는 점을 유의해야 합니다.

# 9. 음.. "example_item"은, 표시되는 이름이 아니고, mod 내부에서 쓰이는 아이템의 이름이다?

맞습니다! `"example_item"`은 **아이템의 내부 이름**입니다. 이 이름은 **아이템을 구분하기 위해 mod 내부에서 사용하는 고유 식별자**로, 게임에서 **실제 아이템 이름**을 화면에 표시할 때 사용되는 **표시 이름(display name)**과는 별개입니다.

### 두 가지 이름 구분

1. **아이템의 내부 이름 (ID, 예: `"example_item"`)**

   * 이것은 **아이템의 고유 식별자**로 사용됩니다. **mod 내에서만 사용되는 이름**이고, 아이템을 등록할 때 사용합니다. 예를 들어, `"examplemod:example_item"` 같은 방식으로 `examplemod`라는 네임스페이스를 기준으로 **아이템을 구분**합니다.
   * 주로 **리소스 파일**에서 사용되며, 예를 들어 아이템 아이콘 이미지나 아이템 텍스트 데이터를 찾을 때 사용됩니다.
   * 이 이름은 **소문자**, **숫자**, **언더스코어**만 사용할 수 있으며, 특수문자나 공백 등은 포함될 수 없습니다.

2. **아이템의 표시 이름 (Display Name, 예: `"Example Item"`)**

   * 이 이름은 **게임 내에서 실제로 사용자에게 보이는 이름**입니다. 예를 들어, 인벤토리나 핸드에 있는 아이템의 이름을 이 표시 이름으로 사용합니다.
   * 표시 이름은 **다양한 언어로 번역**될 수 있으며, **자유롭게 텍스트를 지정할 수 있습니다**. 대문자, 한글, 일본어 등 다양한 문자를 사용 가능합니다.
   * 보통 **리소스 파일**에 작성된 **언어 파일**(`.json` 또는 `.lang` 형식)에 저장되어 있습니다.

### 예시

```java
public static final DeferredItem<Item> EXAMPLE_ITEM = ITEMS.registerSimpleItem("example_item", new Item.Properties()
        .food(new FoodProperties.Builder()
            .alwaysEdible().nutrition(1).saturationModifier(2f).build())
);
```

* `"example_item"`은 **아이템을 내부적으로 식별하기 위한 이름**입니다.
* 실제로 **게임에서 보이는 이름**은 보통 리소스 파일에서 관리합니다. 예를 들어, 아이템 이름을 "Example Item"으로 표시하려면, 해당 이름을 리소스 파일(예: `.json` 파일)에 정의해야 합니다.

### 리소스 파일 예시

아이템 이름을 리소스 파일에서 설정하려면, `en_us.json` 파일에 다음과 같이 작성합니다:

#### `assets/examplemod/lang/en_us.json`

```json
{
  "item.examplemod.example_item": "Example Item"
}
```

* `"item.examplemod.example_item"`는 **아이템의 내부 이름**(ID)을 의미합니다.
* `"Example Item"`은 **게임에서 표시되는 이름**입니다.

### 결론

* `"example_item"`은 **mod 내부에서 사용되는 이름**(아이템의 ID)이고, **게임에서 보이는 이름**은 `lang` 파일이나 다른 리소스 파일에 정의된 **표시 이름**입니다.
* 아이템의 **표시 이름**을 변경하려면 **리소스 파일**에 해당 이름을 **변경**하거나 추가해줘야 합니다.

아이템 이름을 바꿨다면, 그 이름이 **게임 내에서 어떻게 표시될지**는 `en_us.json`과 같은 파일을 통해 관리해야 합니다.

# 10. 그래... 그런 거였다. json 안의 텍스트를 바꾸니 모든 것이 해결되었다.

특수문자 써도 잘 된다.

참 이렇게 산다. 10월 3일, 오후 전부를 써서, 겨우 알아냈다.
