# ✅ 1. Flowchart (순서도)
```mermaid
flowchart TD
    A[Start] --> B{Condition}
    B -- Yes --> C[Do something]
    B -- No --> D[Do something else]
    C --> E[End]
    D --> E
```

# ✅ 2. Sequence Diagram (시퀀스 다이어그램
```mermaid
sequenceDiagram
    participant Alice
    participant Bob
    Alice->>Bob: Hello Bob, how are you?
    Bob-->>Alice: I am good, thanks!
```

# ✅ 3. Gantt Chart (간트 차트)
```mermaid
gantt
    title Project Timeline
    dateFormat  YYYY-MM-DD
    section Design
    Spec Design :a1, 2025-10-01, 5d
    Final Design :after a1, 3d
    section Development
    Coding :2025-10-10, 10d
    Testing :2025-10-20, 5d
```

# ✅ 4. Class Diagram (클래스 다이어그램)
```mermaid
classDiagram
    class Animal {
        +String name
        +void makeSound()
    }
    class Dog {
        +void bark()
    }
    Animal <|-- Dog
```

# ✅ 5. State Diagram (상태도)
```mermaid
stateDiagram-v2
    [*] --> Idle
    Idle --> Working : start
    Working --> Idle : stop
    Working --> Error : error
    Error --> Idle : reset
```

# ✅ 6. Entity Relationship Diagram (ERD)
```mermaid
erDiagram
    USERS ||--o{ ORDERS : places
    USERS {
        string name
        string email
    }
    ORDERS {
        int id
        string product
        int quantity
    }
```

# ✅ 7. Pie Chart (파이 차트)
```mermaid
pie
    title Project Status
    "Done" : 60
    "In Progress" : 30
    "To Do" : 10
```

# ✅ 8. Mindmap (마인드맵)
```mermaid
mindmap
  root
    subtopic1
      sub-sub1
      sub-sub2
    subtopic2
```



# ✅ 9. Timeline (타임라인)
```mermaid
timeline
    title 프로젝트 주요 일정
    2025-10-01 : 프로젝트 시작
    2025-10-05 : 기획 완료
    2025-10-10 : 디자인 시작
    2025-10-20 : 개발 시작
    2025-11-01 : 테스트 시작
    2025-11-10 : 릴리즈
```
