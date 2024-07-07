# K-digital training HScode Mapping Project
---
#### 개발 기간 : **2024.05.28 ~ 2024.06.28**
 ---
#### 제안배경 :
 > 국내기업 수출 증진을 위해, 국내기업의 품목을 수입할 수 있는 해외기업 발굴에 대한 필요성이 존재하며, 이를 위해 해외기업 발굴 시, 국내기업이 취급하고 있는 품목과 유사한 품목을 취급하는 해외기업을 발굴할 때 활용하기 위함.
---
#### 팀 소개
|이름|역할|GIT URL|
|------|---|---|
|신건영|데이터 분석|[https://github.com/LinkDiscovery](https://github.com/LinkDiscovery/HScodeMappingProject)|
|김보성|백엔드|https://github.com/kingboseong|
|채수철|프론트엔드|[https://github.com/Charles0304](https://github.com/Charles0304/Contest-Frontend)|
---
#### 데이터 분석 진행일기(Notion)
> https://www.notion.so/cd44b82f39d64adca06035bcb77338dd?pm=c
--- 
#### 시연 영상
> Rink : https://youtu.be/i9hi_IIgkCY
---
#### 웹 개발 페이지 
#### MAIN
![image](https://github.com/LinkDiscovery/HScodeMappingProject/assets/154401566/d73dcaeb-05a6-434a-90c3-f25def6e5453)
#### Search
![image](https://github.com/LinkDiscovery/HScodeMappingProject/assets/154401566/47394857-518d-4a14-b6a1-c62811055c63)


---
#### 분석 내용 및 분석 결과
> 비식별된 해외기업별 영문 텍스트데이터.xlsx의 ‘DSC’ column을 살펴보면 
  해당기업에 대한 세부적인 description이 아닌 해당기업이 속한 국제표준산업
  분류 CODE에 대한 description으로, 기업 ID별 HS부호 추천이 아닌 산업 분류 
  description에 대한 HS부호 추천으로 문제 정의

> 통계청 국제표준산업분류 HSCODE 6단위 매핑.xlsx데이터를 살펴보면 
  국제표준산업분류와 HSCODE 6단위 간의 MAPPING이 되어 있으나, 
  산업분류 CODE와 HSCODE가 새롭게 개편될 때마다 바꿔줘야하는 번거러
  움과 정확히 매칭되기 어려운 부분도 존재한다는 한계점 존재

> 관세청_HS부호_240101.xlsx데이터와 관세법령정보포텅 사이트 참조결과 HS
  부호에 대한 4단위(호), 6단위(소호), 10단위 별 영문 description 또한 존재
  한다는 것을 확인하였음. 

> 국제표준산업분류 CODE에 대한 description의 Depth와
  HS부호 4단위, 6단위에 대한 description의 Depth가 비슷하다는 판단을 기반
  으로, 두 description 데이터에서 겹치는 단어가 많다면 두 텍스트가 유사하며 
  이를 토대로 HS부호를 추천해준다면, 관련성이 높을 것이라 가정하에 텍스트 
  마이닝 분석을 진행하였음.
  
  도식화 하면 아래와 같음.

![image](https://github.com/LinkDiscovery/HScodeMappingProject/assets/154401566/ff6b0df4-a68f-420e-9758-85943fd01d53)

---

#### 분석 결과 개선점 및 한계점

  1. 산업 특성별 추천코드 개수 적용의 어려움
     
     >해당 분석 결과에서는 모든 기업에 대하여 20개의 HS부호를 추천하도록 하였음. 하지만 산업의 고도화 정도에 따라 추천될 수 있는 HS부호 개수가 다른 것이 정확도가 높을 것으로 판단됨.
  
  2. 텍스트 데이터 주요 단어 추출 시 무역 전문가와의 협업 필요
     
     >텍스트 데이터 전처리 과정과 주요 단어 추출 및 벡터화 과정에서 하나의 텍스트 데이터에서 어떤 주요 단어가 추출되느냐에 따라 추천 HS코드에 영향이 있는 바, 해당업에서의 전문가와 협업한다면 정확도가 높아질 것임. 

  3. 정밀도는 높으나 정확도 개선 필요
      
     >추천 HS부호의 정밀도(몰려있는 정도)는 높으나 다양한 HS부호가 나올 수 있도록 정확도를 개선한다면 실용도가 더 높아질 수 있을 것이라 판단됨
---
#### EER Diagram
![image](https://github.com/LinkDiscovery/HScodeMappingProject/assets/154401566/e8672ee7-af22-4c7b-a045-190b08198fbe)
---

#### Architecture
![image](https://github.com/LinkDiscovery/HScodeMappingProject/assets/154401566/75ddedc0-472b-437c-a98c-962cadb03bb2)
---
#### Rest Api List
![image](https://github.com/LinkDiscovery/HScodeMappingProject/assets/154401566/046e19c8-a78f-4147-b571-4535aa2b0475)
---
### 기술 스택

- **프로그래밍 언어**: Python version: 3.11.9

- **데이터 처리 및 분석**:
  - Pandas version: 2.2.2
  - NumPy version: 1.26.4
 
- **머신러닝**:
  - Scikit-learn version: 1.5.0
    
- **데이터베이스**:
  - mySQL
 
- **개발 도구 및 환경**:
  - Jupyter Notebook
  - Visual Studio Code
    
- **버전 관리**:
  - Git
  - GitHub
    
- **Back End**:
![image](https://github.com/LinkDiscovery/HScodeMappingProject/assets/154401566/9b2c121b-c71e-465a-be75-831f77e91cb6)






  
