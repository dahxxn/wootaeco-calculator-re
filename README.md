# ⭐ 미션 : 계산기

---

## 📢프로그램 소개

> 입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.

1. , 또는 : 을 구분자로 가지는 무자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다
2. 기본 구분자(**, :**) 외에 커스텀 구분자를 지정할 수 있다. 이때 커스텀 구분자는 문자열 앞부분 // 와 \n 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
3. 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException` 을 발생시킨 후 애플리케이션은 종료한다.

* **실행 결과 예시 1**
    - 뎃셈할 문자열을 입력해 주세요
    - 1,2:3
    - 결과 : 6

## ✅ 구현 기능 목록

### 사용자에게 입력받기

- 사용자에게 문자열 입력받기

### 입력값 필터링하기

#### 기본 구분자로 입력값 자르기

- , 와 : 를 구분자로 하여 문자열 자르기
- 자른 문자열은 문자열 조각 목록에 저장하기

#### 커스텀 구분자인지 확인하기

- //로 시작하고 \n으로 끝나는지 확인하기
- //{문자}\n 형태 인지 확인하기
- 커스텀 구분자를 커스텀 구분자 목록에 추가하기

#### 문자열 조각이 숫자인지 확인하고 누적합 계산하기

- 숫자이면 누적합 계산하기
- 숫자가 아니면, 커스텀 구분자로 문자열 조각을 다시 자르기
    - 자르고 다시 문자열 조각들의 숫자 여부 확인하기
        - 숫자가 아닌게 있으면, 예외 발생하기
        - 숫자이면, 누적합 계산하기

### 사용자에게 출력하기

- 사용자에게 입력 안내 메시지 출력하기
- 사용자에게 결과 메시지 출력하기
    - 결과 : {결과값} 형태로 출력하기

### 잘못된 값에 대해 예외 발생시키기

- `IllegalArgumentException` 을 발생시킨 후 애플리케이션 종료 시키기

## ✔️ 프로그래밍 요구 사항

- **Java Style Guide 지키기**
- **작은 단위로 자주 Commit 하기**
- **들여쓰기는 3 넘지 않도록 하기**
- **3항 연산자 쓰지 않기**
- **함수는 1가지 일만 하도록 작게 만들고 10라인은 넘지 않도록 하기**
- **배열 대신 컬렉션 사용하기**
- **이름을 통해 의도 들어내고 축약은 최대한 하지 않기**
- **관련 함수를 묶어 클래스를 만들고, 객체들이 협력하여 하나의 큰 기능을 수행하도록 하기**
- **단위테스트로 의도한대로 정확하게 작동하는지 확보하기**
- **else 예약어 쓰지 않기**
- **연관성 있는 상수는 static final이 아닌 Enum 클래스 사용하여 프로그램 구현하기**
- **Java에서 제공하는 API 적극 활용하기**
- **입출력 담당하는 클래스 별도 구현하기**
- **객체의 상태 접근 제한하기**
    - **인스턴스 변수 접근 제어자는 private으로 설정하여 외부 통제 받지 않도록 하기**
- **객체는 객체답게 사용하기**
    - **객체가 스스로 처리할 수 있도록 구조 변경하기**
- **상수는 final 키워드 사용하기**
    - **연관된 상수는 또 enum클래스로 묶기**
- **인스턴스 변수 수 줄이도록 노력하기**
- **예외 케이스도 테스트하기**
- **테스트 코드를 위한 코드는 구현 코드에서 분리하기**