# ClothesVillage
가지고 있는 옷들을 효율적으로 코디해 입을 수 있도록 도와주는 안드로이드 어플리케이션입니다.

### 프로젝트 기간
2021.03 ~ 2021.06

### 프로젝트 목적
코로나 19의 영향으로 인해 외출에 제약이 많아지면서 의류 소비가 감소했습니다. 그로인해 옷을 구입하기보다는 대여를 할 수 있는 서비스를 요구하는 사용자가 생겨났고, 이미 있는 옷들을 어떻게 효율적으로 코디해 입을 수 있는지에 대한 정보를 필요로 하고있습니다. 본 프로젝트는 사용자가 자신의 옷들을 한눈에 쉽게 파악할 수 이도록 도와주고, 사용자간의 중고거래 또는 대여 서비스를 제공하고, 커뮤니티를 통해 소통하고 기온별로 옷차림을 추천받을 수 있음에 목적을 두고 있습니다. 또한 입지 않는 옷을 거래함으로써 환경오염을 방지하는 것에 핵심 가치를 둔 어플리케이션 제작을 목적으로 합니다.

## 사용한 기술
- Java
- Android Studio

## 기능
- 로그인 및 회원가입
- 홈화면
: 요일/시간별 날씨 정보 확인, 옷차림 추천
- 코디 피드
: 옷장에서 옷을 골라 직접 코디, 다른 사용자의 코디를 탐색. 댓글 기능을 통해 사용자간 커뮤니케이션
- 옷장 
: 소유하고 있는 옷을 모바일 옷장에 등록 및 삭제
- 중고거래 및 대여
: 모바일 옷장에 등록한 옷 중 불필요하거나 한두번밖에 안입는 옷을 거래 혹은 대여할 수 있으며, 거래를 원하는 상대방과 1대1 채팅 가능
- 마이페이지
: 회원 정보 수정 가능, 사용자의 코디 피드와 중고거래 및 대여 게시물 관리. 좋아요한 목록 관리

## DB
![image](https://user-images.githubusercontent.com/56482682/156565281-a3b7cc11-e916-4943-9062-a9a3c4cbd127.png)

## 구현 화면
### 회원가입 / 로그인
![image](https://user-images.githubusercontent.com/56482682/156561854-5b9fc8ae-7b78-4f08-8b9e-b4f1d44148ca.png)
![image](https://user-images.githubusercontent.com/56482682/156561875-8a204946-97fc-4cb1-8687-96924755e3bf.png)

### Home
홈 화면에서 3시간 간격 일별과 일주일간의 날씨를 확인할 수 있습니다. <br /><br />
![image](https://user-images.githubusercontent.com/56482682/156561937-55d748de-9967-42c1-be82-4f542b4c9c9b.png)
![image](https://user-images.githubusercontent.com/56482682/156561951-2d2717ec-d696-429a-b5c4-f3b9b1e0225e.png)

### 옷장
카테고리를 선택하여 옷을 옷장에 등록할 수 있습니다. <br /><br />
![image](https://user-images.githubusercontent.com/56482682/156562444-cd4397da-b33e-4487-a911-9defc6976f12.png)
![image](https://user-images.githubusercontent.com/56482682/156562475-adac0ef0-971b-4cf2-a228-12f203358d17.png)


### 코디
코디 화면에서는 다른 사용자가 공유한 게시글을 조회할 수 있고, 댓글을 게시할 수 있습니다. <br /><br />
![image](https://user-images.githubusercontent.com/56482682/156562648-7f29bb6b-7f5d-4449-abb0-321288108bdc.png)
![image](https://user-images.githubusercontent.com/56482682/156562665-7b17f279-914d-4174-b533-c69be32bea78.png) <br />
검색 기능을 통해 원하는 상품을 검색할 수 있습니다.
- [@닉네임] 형식으로 해당 닉네임을 가진 사용자의 코디를 검색할 수 있습니다.
- [#태그] 형식으로 해당 태그를 포함하고 있는 코디를 검색할 수 있습니다.
- [제목] 형식으로 해당 제목을 포함하고 있는 코디를 검색할 수 있습니다. <br /><br />
![image](https://user-images.githubusercontent.com/56482682/156565446-e623d937-6e14-4116-af3b-c5427b1774e7.png)

### 중고 거래 및 대여
![image](https://user-images.githubusercontent.com/56482682/156563280-e1641603-7736-412f-91de-03f27380fa03.png)
![image](https://user-images.githubusercontent.com/56482682/156563290-ba72ed93-f136-4ffe-aac7-fd53c7b78cd5.png) <br /><br />
검색 필터를 설정하여 원하는 카테고리 혹은 키, 몸무게를 가진 사용자의 게시물을 검색할 수 있습니다. <br /><br />
![image](https://user-images.githubusercontent.com/56482682/156563324-91b94c7a-8e74-47be-a0bc-5b01b97001f1.png)

### 마이페이지
![image](https://user-images.githubusercontent.com/56482682/156563461-d55cb79c-e4c1-4ec5-be03-817a343c5b1b.png)

