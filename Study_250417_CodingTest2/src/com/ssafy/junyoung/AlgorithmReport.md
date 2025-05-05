# 알고리즘 정리
## 자료구조
### 스택

```java
import java.util.Stack;

public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();
    stack.add(123);
    System.out.println(stack.pop());
}
```
- LIFO : Last In and First Out - 나중에 온 것이 먼저 나옴.
- 예시 : 함수 처리 등등
### 큐

```java
import java.util.ArrayDeque;

public static void main(String[] args) {
    Queue<Integer> queue = new ArrayDeque<>();
    queue.offer(123);
}
```
- FIFO : First In and First Out - 먼저 온 것이 먼저 나옴.
- 예시 : bfs
### 맵

```java
import java.util.HashMap;

public static void main(String[] args) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(1, 2);
    
}
```
- key값이 중복되지 않는다.
- 요소의 저장 순서를 유지하지 않는다. 

### 해시 알고리즘
- 임의의 크기를 가진 데이터를 고정된 데이터의 크기로 변환시키는 것을 말한다. 
- 키를 고유한 해시값으로 변환 

- 해싱 충돌 해결
  1. Separate Chaining
     1. 같은 해시값을 갖는 데이터를 링크드리스트로 붙여 나감. 
  2. Open Addressing
  3. 