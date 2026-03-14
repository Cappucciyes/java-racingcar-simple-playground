# 1단계 - 움직이는 자동차
## 요구사항
- 자동차 객체
  - 자동차는 자신만의 이름을 가진다
  - 자동차는 전진할 수 있다
    - 전진하기 위해 스스로 0부터 9사이의 정수를 무작위로 고른다
- 정상 작동하는지 테스트 한다.
## 구현
- `Car.java` : 자동차 객체
- `NumberGenerator.java` : 숫자 생성을 담당하는 인터페이스
- `NumberGeneratorImpl.java` : 실제 자동차 객체에 사용하는 `NumberGenerator.java`의 구현체
- `TestNumberGeneratorImpl.java` : 테스트에서 사용할 `NumberGenerator.java`의 구현체