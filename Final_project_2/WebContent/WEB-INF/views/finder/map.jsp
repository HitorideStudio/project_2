<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>여러개 마커 표시하기</title>
    
</head>
<body>
<div id="map" style="width:80%;height:800px;"></div>
<script
  src="https://code.jquery.com/jquery-3.4.1.min.js"
  integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
  crossorigin="anonymous"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=6e0cc7f923dfb2d33aa1685a125ad6cb"></script>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
    mapOption = { 
        center: new kakao.maps.LatLng(37.55608, 126.9234), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

var clusterer = new kakao.maps.MarkerClusterer({
    map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체 
    averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정 
    minLevel: 10 // 클러스터 할 최소 지도 레벨 
});

// 마커를 표시할 위치와 title 객체 배열입니다 


    var list = new Array();
	var lon = new Array();
	var lat = new Array();
	
	//jstl 혼합사용
	<c:forEach items="${list}" var="list">
	list.push("${list.placename}"); //list[i]
	list.push("${list.lon}"); //list[i+1]
	list.push("${list.lat}"); //list[i+2]
	</c:forEach>


    $.get("/download/web/data/chicken.json", function(data) {
        // 데이터에서 좌표 값을 가지고 마커를 표시합니다
        // 마커 클러스터러로 관리할 마커 객체는 생성할 때 지도 객체를 설정하지 않습니다
		
        
    	var imageSrc = "http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; 

	        for(var i=0; i<list.length; i+=3){ // 3씩증가
	        // 마커 이미지의 이미지 크기 입니다
	        var imageSize = new kakao.maps.Size(24, 35); 
	        
	        // 마커 이미지를 생성합니다    
	        var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
	        
	        // 마커를 생성합니다
		        var markers = new kakao.maps.Marker({
		            map: map, // 마커를 표시할 지도
		            position: new kakao.maps.LatLng(list[i+2],list[i+1]), // 마커를 표시할 위치
		            title : list[i], // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
		            image : markerImage // 마커 이미지 
		        });
	        clusterer.addMarker(markers);
	        }
    });
</script>
</body>
</html>
