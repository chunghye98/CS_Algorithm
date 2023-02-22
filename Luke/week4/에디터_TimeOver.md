### [에디터](https://www.acmicpc.net/problem/1406)

### 시간 복잡도
- O(N^2)

### 어떻게 풀 것인가? / 코드 설명
시간 초과 풀이
- StringBuilder 사용
- int pos: 현재 커서 위치
- 입력되는 명령에 따라 StringBuilder의 insert, delete, pos++, pos-- 등의 연산 수행

### 이 문제를 통해 얻어갈 것
StringBuilder 메소드의 시간 복잡도
- append(): O(1)
- insert(): O(N)
- delete(): O(N)
- toString(): O(N)

StringBuilder는 사실 단일 쓰레드 환경에서 동작 속도가 꽤 빠르다고 생각했던 클래스다. (String보다는 당연히 훨씬 빠르다.)  
StringBuilder는 배열을 기반으로 구성되어 있다.  
배열의 복사 또는 배열의 중간에 데이터를 삽입하는 것은 한땀 한땀 복사해야 하기 때문에 O(N)의 시간 복잡도를 가진다.  

AbstractBuilder 클래스의 shift 연산: arraycopy 사용! -> 시간 복잡도 (O(N))
```java
private void shift(int offset, int n) {
        System.arraycopy(value, offset << coder,
                         value, (offset + n) << coder, (count - offset) << coder);
    }
```