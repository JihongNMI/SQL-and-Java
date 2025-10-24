# 1. 컬렉션(Collection): 여러 개의 객체(데이터)를 하나로 묶어서 다루는 그릇

# 2. 종류
좋아요! Java 컬렉션 프레임워크에서 자주 쓰이는 **모든 주요 종류와 선언 방법**을 1문장씩 정리해 드릴게요. (Array는 컬렉션 프레임워크는 아니지만 참고용으로 같이 적을게요)

---

### **List 계열**

* **ArrayList** : `List<Type> list = new ArrayList<>();`
* **LinkedList** : `List<Type> list = new LinkedList<>();`
* **Vector** : `List<Type> list = new Vector<>();`
* **Stack** : `Stack<Type> stack = new Stack<>();` (LIFO 구조, Vector 기반)

### **Set 계열**

* **HashSet** : `Set<Type> set = new HashSet<>();`
* **LinkedHashSet** : `Set<Type> set = new LinkedHashSet<>();` (입력 순서 유지)
* **TreeSet** : `Set<Type> set = new TreeSet<>();` (정렬된 순서 유지)

### **Queue / Deque 계열**

* **Queue (LinkedList)** : `Queue<Type> queue = new LinkedList<>();`
* **PriorityQueue** : `Queue<Type> pq = new PriorityQueue<>();` (우선순위 기반)
* **Deque (ArrayDeque)** : `Deque<Type> deque = new ArrayDeque<>();`

### **Map 계열**

* **HashMap** : `Map<KeyType, ValueType> map = new HashMap<>();`
* **LinkedHashMap** : `Map<KeyType, ValueType> map = new LinkedHashMap<>();` (입력 순서 유지)
* **TreeMap** : `Map<KeyType, ValueType> map = new TreeMap<>();` (키 기준 정렬)
* **Hashtable** : `Map<KeyType, ValueType> map = new Hashtable<>();` (구버전, 동기화 지원)

---

좋아요! 😄 아까처럼 **Java에서 선언할 때 필요한 import까지 포함해서 1문장씩** 정리해 볼게요.

---

| 인터페이스     | 구현체           | 필요한 import                                                | 특징                              |
| --------- | ------------- | --------------------------------------------------------- | ------------------------------- |
| **List**  | ArrayList     | `import java.util.ArrayList; import java.util.List;`      | 순서 있음, 중복 허용, 배열 기반, 접근 빠름      |
|           | LinkedList    | `import java.util.LinkedList; import java.util.List;`     | 순서 있음, 중복 허용, 노드 기반, 삽입/삭제 빠름   |
|           | Vector        | `import java.util.Vector; import java.util.List;`         | 순서 있음, 중복 허용, 동기화 지원, 구버전       |
|           | Stack         | `import java.util.Stack;`                                 | LIFO 구조, Vector 기반, push/pop 지원 |
| **Set**   | HashSet       | `import java.util.HashSet; import java.util.Set;`         | 순서 없음, 중복 불가, 해시 기반             |
|           | LinkedHashSet | `import java.util.LinkedHashSet; import java.util.Set;`   | 입력 순서 유지, 중복 불가                 |
|           | TreeSet       | `import java.util.TreeSet; import java.util.Set;`         | 정렬된 순서 유지, 중복 불가                |
| **Queue** | LinkedList    | `import java.util.LinkedList; import java.util.Queue;`    | FIFO 구조, 삽입/삭제 편리               |
|           | PriorityQueue | `import java.util.PriorityQueue; import java.util.Queue;` | 우선순위 기반 정렬, 최소/최대 값 접근 용이       |
| **Deque** | ArrayDeque    | `import java.util.ArrayDeque; import java.util.Deque;`    | 양쪽 끝에서 삽입/삭제 가능, 큐/스택 둘 다 가능    |
| **Map**   | HashMap       | `import java.util.HashMap; import java.util.Map;`         | 키-값 쌍 저장, 순서 없음, 해시 기반          |
|           | LinkedHashMap | `import java.util.LinkedHashMap; import java.util.Map;`   | 입력 순서 유지, 키-값 쌍 저장              |
|           | TreeMap       | `import java.util.TreeMap; import java.util.Map;`         | 키 기준 정렬, 키-값 쌍 저장               |
|           | Hashtable     | `import java.util.Hashtable; import java.util.Map;`       | 구버전, 동기화 지원, 키-값 쌍 저장           |


