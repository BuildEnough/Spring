# Spring
## 간단한 웹 애플리케이션 개발
- 스프링 프로젝트 생성
- 스프링 부트로 웹 서버 실행
- 회원 도메인 개발
- 웹 MVC 개발
- DB 연동: JDBC, JPA, 스프링 데이터 JPA
- 테스트 케이스 작성
- 오래된 스프링 기술 X
- 마이너한 스프링 기술 X

---
## 로드맵
- 스프링 입문
- 스프링 핵심 원리
- 스프링 웹 MVC
- 스프링 DB 데이터 접근 기술
- 실전! 스프링 부트

---

## 프로젝트 환경설정
- 프로젝트 생성
- 라이브러리 살펴보기
- View 환결설정
- 빌드하고 실행하기

---

## 프로젝트 생성
**사전 준비물**
- java 11 설치
- IDE: IntelliJ 또는 Eclipse 설치
- *본좌는 IntelliJ 사용하겠다*


<br>

### 스프링 부트 스타터 사이트 이동 후 스프링 프로젝트 생성
https://start.spring.io/

<br>

### 프로젝트 선택
- Project Gradle Project
  - SPring Boot: 2.3.x
  - Language: Java
  - Packaging: Jar
  - Java: 11
- Project Metadata
  - groupId: hello
  - artifactId: hello-spring
- DependenciesL Spring Web, Thymeleaf

<br>

### Gradle 전체 설정
`build.gradle`
```groovy
plugins {
	id 'java'
	id 'org.springframework.boot' version '3.0.2'
	id 'io.spring.dependency-management' version '1.1.0'
}

group = 'hello'
version = '0.0.1-SNAPSHOT'
sourceCompatibility = '17'

repositories {
	mavenCentral()
}

dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'
	implementation 'org.springframework.boot:spring-boot-starter-web'
	testImplementation 'org.springframework.boot:spring-boot-starter-test'
}

tasks.named('test') {
	useJUnitPlatform()
}
```

<br>

### 실행
- src -> main -> java -> hello.hellospring -> HelloSpringApplication -> 실행  

![](images/run.png)

<br>

### 실행속도 향상
- IntelliJ 사용 중이라면,
- Settings -> Appearance -> Gradle 검색 -> Build and run using, Run tests using를 Gradle에서 IntelliJ IDEA로 바꿔줌
![](images/settings.png)
- Gradle을 통해 run 실행하는 것보다 IntelliJ를 통해 run을 실행하는 것이 속도가 더 빠를 때가 있기 때문에 설정해줌