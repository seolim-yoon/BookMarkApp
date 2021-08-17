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


* 화면 구성
1. 홈 화면 (HomeFragment) : API를 통해 데이터를 가져온 후 Room DB에 저장하고, 저장된 Room DB를 Paging을 사용하여 20개 단위로 가져온다.
    
2. 즐겨찾기 화면 (BookMarkFragment) : 하트(즐겨찾기) 버튼을 누르면 DB의 isBookMark가 true/false로 변경되며, true인 데이터를 선택한 정렬 타입대로 나열한다.
 [정렬 타입 = 최근 등록 순, 오래된 순, 평점 높은 순, 평점 낮은 순]
    
3. 정렬 타입 선택 화면 (BookMarkSortBottomSheetFragment) : 보고싶은 정렬 타입을 선택할 수 있다.

4. 상세 화면 (DetailFragment) : 리스트의 아이템 클릭 시 선택한 데이터의 상세화면을 보여준다.
    
