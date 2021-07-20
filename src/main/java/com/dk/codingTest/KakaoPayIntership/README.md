# KakaoPay 2021 채용 연계형 개발자 인턴십<br> 코딩 테스트 준비

>프로그래머스 2021 카카오 채용연계형 인턴십 문제로 카카오페이 코팅 테스트 준비  
> 총 5개 문제
>> 1. [숫자 문자열과 영단어](https://programmers.co.kr/learn/courses/30/lessons/81301) 
>> 2. [거리두기 확인하기](https://programmers.co.kr/learn/courses/30/lessons/81302)
>> 3. [표 편집](https://programmers.co.kr/learn/courses/30/lessons/81303)
>> 4. [미로탈출](https://programmers.co.kr/learn/courses/30/lessons/81304)
>> 5. [시험장 나누기](https://programmers.co.kr/learn/courses/30/lessons/81305)
>   
> 요기요(딜리버리 히어로) 코딩 테스트 시 시간 부족으로 연습부터 시간 체크 해야함.  
> 2시간에 3문제, 한 문제당 평균 30분 정도 소요해 문제 푸는 것으로 연습해야 할거 같아용.~  
## <center> **문제당 30분 !!!**</center>


Table of Contents
=================
* [숫자 문자열과 영단어](#1.-숫자-문자열과-영단어)

## 1. 숫자 문자열과 영단어
>
> 총 소요 시간 37분  
> 문제 : "one4seveneight" 로 주어지면 1478로 변환.
>>  **접근 방식**<br>
>> 주어진 문자열을 순회하면서 Character.isDigit을 통해 숫자 or 문자를 판별  
>> 숫자 라면, 따로 처리할 필요 없이 바로 정답으로 직행!
>> 문자라면 (is Digit = false), 숫자로 변환이 필요  
>> 숫자로 변환 필요. 아래와 같이 숫자 변환 표가 제공됨.
>> 변환표 영단어를 살펴보면 3글자만으로도 구분이 가능  
>> 문자가 시작된 지점 부터 3글자까지 글자만으로 문자를 숫자로 변환  
>> 변환 후 해당 문자의 길이를 for문 index에 업데이트 해 중복으로 문자 처리 방지
>
> 
| **숫자** | **영단어** | 
| --- | ----- |
| 0 | zero |
| 1 | one |
| 2 | two |
| 3 | three |
| 4 | four |
| 5 | five |
| 6 | six |
| 7 | seven |
| 8 | eight |
| 9 | nine |
