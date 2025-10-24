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

원하면 제가 이거를 **표로 만들어서 인터페이스-구현-특징**까지 한눈에 보이게 정리해 드릴 수도 있어요.
그거 해드릴까요?
