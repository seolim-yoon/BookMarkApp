# BookMarkApp


* 사용 기술
  + Kotlin
  + Recyclerview
  + MVVM
  + Databinding
  + LiveData
  + ViewModel
  + Room
  + Paging3
  + Navigation
  + Retrofit2
  + OkHttp
  + RxJava2
  + Dagger2
  + SwipeRefreshLayout
  + Glide  


#


* 프로젝트 구조
<img src="https://user-images.githubusercontent.com/73940842/129688749-6e5d18a5-56d6-42ea-a556-862684990145.PNG" width="400" height="400">


#


* 결과 화면
홈 화면, 북마크 화면(최근 등록 순), 정렬 타입 선택 화면, 북마크 화면(평점 높은 순), 상세 화면


<img src="https://user-images.githubusercontent.com/73940842/129687889-c76fe134-215c-4033-9d91-1f8ce1d2f44b.jpg" width="220" height="450"> <img src="https://user-images.githubusercontent.com/73940842/129687969-579d3d70-0a4a-4d06-89c1-74126608d974.jpg" width="220" height="450"> <img src="https://user-images.githubusercontent.com/73940842/129688055-dfae7768-c42d-469c-ada8-865798147fd2.jpg" width="220" height="450"> 

<img src="https://user-images.githubusercontent.com/73940842/129688004-cb299c80-9b89-427e-b518-47c6ed800dd7.jpg" width="220" height="450"> <img src="https://user-images.githubusercontent.com/73940842/129688085-7f6a8628-51bf-447d-bb7f-cf678cd7e12d.jpg" width="220" height="450">



#


* 화면 구성
1. 홈 화면 (HomeFragment) : API를 통해 데이터를 가져온 후 Room DB에 저장. 저장된 Room DB를 Paging으로 20개 단위로 가져옴
    
2. 즐겨찾기 화면 (BookMarkFragment) : 하트(즐겨찾기) 버튼을 누르면 DB의 isBookMark가 true/false로 변경되며, true인 데이터를 선택한 정렬 타입대로 나열
 정렬 타입 = 최근 등록 순, 오래된 순, 평점 높은 순, 평점 낮은 순
    
3. 정렬 타입 선택 화면 (BookMarkSortBottomSheetFragment) : 보고싶은 정렬 타입을 선택할 수 있음

4. 상세 화면 (DetailFragment) : 리스트의 아이템 클릭 시 선택한 데이터의 상세화면을 보여줌
    
