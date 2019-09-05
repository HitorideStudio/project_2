<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>마커 클러스터러 사용하기</title>
    
</head>
<body>

<div id="map" style="width:100%;height:350px;"></div>
<script
  src="https://code.jquery.com/jquery-3.4.1.min.js"
  integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
  crossorigin="anonymous"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=6e0cc7f923dfb2d33aa1685a125ad6cb&libraries=clusterer"></script>
<script>
    var map = new kakao.maps.Map(document.getElementById('map'), { // 지도를 표시할 div
        center : new kakao.maps.LatLng(37.55608, 126.9234), // 지도의 중심좌표 
        level : 6 // 지도의 확대 레벨 
    });
    
    // 마커 클러스터러를 생성합니다 
    var clusterer = new kakao.maps.MarkerClusterer({
        map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체 
        averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정 
        minLevel: 2 // 클러스터 할 최소 지도 레벨 
    });
 
    var list = new Array();
    var lon = new Array();
    var lat = new Array();

    //jstl 혼합사용
    <c:forEach items="${list}" var="list">
    list.push("${list.placename}"); //list[i]
    list.push("${list.lon}"); //list[i+1]
    list.push("${list.lat}"); //list[i+2]
    </c:forEach>
    // 데이터를 가져와 마커를 생성하고 클러스터러 객체에 넘겨줍니다
  
	
    
    // 마커 이미지의 이미지 주소입니다
    var imageSrc = "http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; 
       
        for(var i=0; i<list.length; i+=3){ // 3씩증가
        // 마커 이미지의 이미지 크기 입니다
        var imageSize = new kakao.maps.Size(24, 35); 
        
        // 마커 이미지를 생성합니다    
        var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
        
        // 마커를 생성합니다
        var marker = new kakao.maps.Marker({
            map: map, // 마커를 표시할 지도
            position: new kakao.maps.LatLng(list[i+2],list[i+1]), // 마커를 표시할 위치
            title : list[i], // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
            image : markerImage // 마커 이미지 
        });

}



    
</script>
</body>
</html>




