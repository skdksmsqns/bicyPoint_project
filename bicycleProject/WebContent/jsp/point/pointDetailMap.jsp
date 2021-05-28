<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>상세보기</title>
<script type="text/javascript" src="http://map.vworld.kr/js/vworldMapInit.js.do?version=2.0&apiKey=009E0540-DCD5-3862-822B-0E9D2DCE1FAB&domain=localhost:8080"></script>
</head>

<body>
	
		<header>
		<div id="main">
			<aside>
				<jsp:include page="/jsp/includ/navMap.jsp" />
			</aside>
		</div>
		</header>
	

   
<div id="vmap" style=" height: 90
vh; width: 100vw;;left:0px;top:0px"></div>
<script type="text/javascript">
	vw.ol3.MapOptions = {
	    basemapType: vw.ol3.BasemapType.GRAPHIC
	  , controlDensity: vw.ol3.DensityType.EMPTY
	  , interactionDensity: vw.ol3.DensityType.BASIC
	  , controlsAutoArrange: true
	  , homePosition: vw.ol3.CameraPosition
	  , initPosition: vw.ol3.CameraPosition
	}; 
	vmap = new vw.ol3.Map("vmap",  vw.ol3.MapOptions); 
	
	var markerLayer = new vw.ol3.layer.Marker(vmap); 
	
	//컨트롤러에서 값받기
	var pointInfo = '${pointInfo}'; 
	
	//마커 레이어 생성
	vw.ol3.markerOption = {
		x : "${pointInfo.x_geom}",
		y : "${pointInfo.y_geom}",
		epsg : "EPSG:4326",
		title : '현위치',
		contents : '대여소 ID=${pointInfo.id}<br>대여소 정보=${pointInfo.ctv_nam}',
		iconUrl : 'http://map.vworld.kr/images/ol3/marker_blue.png'
	}; 

	//마커 옵션 설정
	markerLayer.addMarker(vw.ol3.markerOption);// 마커를 레이어에 등록
	vmap.addLayer(markerLayer) //마커를 vmap에 등록
	
	
</script>


</body>
</html>

</body>
</html>