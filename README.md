<p align="center">
    <img width="200px;" src="https://raw.githubusercontent.com/woowacourse/atdd-subway-admin-frontend/master/images/main_logo.png"/>
</p>
<p align="center">
  <img alt="npm" src="https://img.shields.io/badge/npm-6.14.15-blue">
  <img alt="node" src="https://img.shields.io/badge/node-14.18.2-blue">
  <a href="https://edu.nextstep.camp/c/R89PYi5H" alt="nextstep atdd">
    <img alt="Website" src="https://img.shields.io/website?url=https%3A%2F%2Fedu.nextstep.camp%2Fc%2FR89PYi5H">
  </a>
  <img alt="GitHub" src="https://img.shields.io/github/license/next-step/atdd-subway-admin">
</p>

<br>

# 지하철 노선도 미션
[ATDD 강의](https://edu.nextstep.camp/c/R89PYi5H) 실습을 위한 지하철 노선도 애플리케이션

<br>

## 🚀 Getting Started

### Install
#### npm 설치
```
cd frontend
npm install
```
> `frontend` 디렉토리에서 수행해야 합니다.

### Usage
#### webpack server 구동
```
npm run dev
```
#### application 구동
```
./gradlew bootRun
```
<br>

## ✏️ Code Review Process
[텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

<br>

## 🐞 Bug Report

버그를 발견한다면, [Issues](https://github.com/next-step/atdd-subway-admin/issues) 에 등록해주세요 :)

<br>

## 📝 License

This project is [MIT](https://github.com/next-step/atdd-subway-admin/blob/master/LICENSE.md) licensed.

## 1단계 - 지하철역 인수 테스트 작성
* 기능 요구사항
  * 지하철역 인수 테스트를 완성하세요.
    * 지하철역 목록 조회 인수 테스트 작성하기
    * 지하철역 삭제 인수 테스트 작성하기


* [x] 기능구현
  * [x] 지하철역 목록 조회 인수 테스트
  * [x] 지하철역 삭제 인수 테스트
  * [x] 중복 테스트 코드 리팩토링


## 2단계 - 지하철 노선 기능
* 기능 요구사항
  * 요구사항 설명에서 제공되는 인수 조건을 기반으로 지하철 노선 관리 기능을 구현하세요.
  * 인수 조건을 검증하는 인수 테스트를 작성하세요.


* 프로그래밍 요구사항
  * 아래의 순서로 기능을 구현하세요.
    * 인수 조건을 검증하는 인수 테스트 작성
    * 인수 테스트를 충족하는 기능 구현
  * 인수 테스트의 결과가 다른 인수 테스트에 영향을 끼치지 않도록 인수 테스트를 서로 격리 시키세요.
  * 인수 테스트의 재사용성과 가독성, 그리고 빠른 테스트 의도 파악을 위해 인수 테스트를 리팩터링 하세요.

* 요구사항 설명
  * 인수 조건
    * 지하철노선 생성
    ```
    When 지하철 노선을 생성하면
    Then 지하철 노선 목록 조회 시 생성한 노선을 찾을 수 있다
    ```
    * 지하철노선 목록 조회
    ```
    Given 2개의 지하철 노선을 생성하고
    When 지하철 노선 목록을 조회하면
    Then 지하철 노선 목록 조회 시 2개의 노선을 조회할 수 있다.
    ```
    * 지하철노선 조회
    ```
    Given 지하철 노선을 생성하고
    When 생성한 지하철 노선을 조회하면
    Then 생성한 지하철 노선의 정보를 응답받을 수 있다.
    ```
    * 지하철노선 수정
     ```
    Given 지하철 노선을 생성하고
    When 생성한 지하철 노선을 수정하면
    Then 해당 지하철 노선 정보는 수정된다
     ```
    * 지하철노선 삭제
    ```
    Given 지하철 노선을 생성하고
    When 생성한 지하철 노선을 삭제하면
    Then 해당 지하철 노선 정보는 삭제된다
    ```
  

* [x] 구현목록
  * [x] 요구사항 설명 목록
  * [x] @sql 애너테이션 사용
    * [x] truncate.sql, data.sql
  * [x] find, delete 시 데이터가 없으면 예외발생 및 404 에러 반환

* 리뷰 피드백(리뷰어: 김석홍 님)
  * 필드 컬럼 설정, 변수명, 의미없는 오버라이드 삭제, 미사용 테스트 클래스 삭제, spring 어노테이션 사용 등
  * Request 필드를 따로 받도록
  * repository.find 시 null 리턴 대신 예외가 발생하도록
  * 특정 상황에서 dto 내부 메소드로 새로운 객체 생성 방법 부적절
