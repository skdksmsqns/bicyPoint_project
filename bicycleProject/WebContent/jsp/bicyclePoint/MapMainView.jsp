<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	
	<!-- CSS here -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/magnific-popup.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/themify-icons.css">
    <link rel="stylesheet" href="css/nice-select.css">
    <link rel="stylesheet" href="css/flaticon.css">
    <link rel="stylesheet" href="css/gijgo.css">
    <link rel="stylesheet" href="css/animate.min.css">
    <link rel="stylesheet" href="css/slick.css">
    <link rel="stylesheet" href="css/slicknav.css">
    <link rel="stylesheet" href="css/style.css">
	
<link rel="stylesheet"
href="https://cdn.jsdelivr.net/gh/openlayers/openlayers.github.io@master/en/v6.5.0/css/ol.css"
	type="text/css">
<style>
body {
	width: 100vw;
	height: 100vh;
	margin: 0;
	padding: 0;
	overflow: hidden;
}

p {
	margin: 0;
	padding: 0;
}

.map {
	height: 100%;
	width: 100%;
}
</style>
<script src="https://cdn.jsdelivr.net/gh/openlayers/openlayers.github.io@master/en/v6.5.0/build/ol.js"></script>
<title>OpenLayers example</title>
</head>

<body>
   	<div id="page">
		<header>
		<div id="main">
			<aside>
				<jsp:include page="/jsp/includ/navMap.jsp" />
			</aside>
		</div>
		</header>
	</div>
   
	<div id="map" class="map">
		<h3>지도화면</h3>
	</div>
	<script type="text/javascript">

        /**
		* Geosever, Chrome CORS plugin, live server extension íì
		*/

        const map = new ol.Map({
            target: 'map',
            layers: [
			/*
                new ol.layer.Tile({
                    source: new ol.source.OSM()
                }),
			*/
				new ol.layer.Tile({ 
					source: new ol.source.XYZ({
						//vworld tile map
						url: 'http://xdworld.vworld.kr:8080/2d/Base/service/{z}/{x}/{y}.png'
					})
				})				
				
				
            ],
            view: new ol.View({
                center: ol.proj.fromLonLat([128.07666015625014, 36.4696612599073]),
                zoom: 8,
				minZoom: 5,
				maxZoom: 20
            })
        });
        //폴리곤 레이어 추가
        const sourcePolygon = new ol.source.TileWMS({
            url: 'http://localhost:13000/geoserver/chwigong2/wms',
            params: {'LAYERS': 'chwigong2:chwi_polygon', 'TILED': true},
            serverType: 'geoserver',
        })
        const layerPolygon = new ol.layer.Tile({
            source: sourcePolygon,
        });
        //map.addLayer(layerPolygon);
        map.addLayer(layerPolygon);
        
    /*   	//point 레이어 추가
        const sourcePoint = new ol.source.TileWMS({
            url: 'http://localhost:13000/geoserver/chwigong2/wms',
            params: {'LAYERS': 'chwigong2:chwi_point', 'TILED': true},
            serverType: 'geoserver',
        })
        const layerPoint = new ol.layer.Tile({
            source: sourcePoint,
        });
        map.addLayer(layerPoint); */
        
      	//point 레이어 추가
        const sourceStlt = new ol.source.TileWMS({
            url: 'http://localhost:13000/geoserver/bicycle/wms',
            params: {'LAYERS': 'bicycle:byst_point', 'TILED': true},
            serverType: 'geoserver',
        })
        
        const layerStlt = new ol.layer.Tile({
            source: sourceStlt,
        });
        map.addLayer(layerStlt);
        
        
        
        /* Icon Style */
        var iconStyle = new ol.style.Style({
          image: new ol.style.Icon({/** @type {olx.style.IconOptions} */
            anchor: [0.5, 46],
            anchorXUnits: 'fraction',
            anchorYUnits: 'pixels',
            src: './img/bicy/bicycle-2-48.png'
          })
        })
        
        /* Icon Features (Array) */
        var iconFeatures = dummy.points.map(function(point) {

          var iconFeature = new ol.Feature({
            geometry: new ol.geom.Point(ol.proj.transform([point.lon, point.lat], 'EPSG:4326', 'EPSG:3857')),
            name: point.title,
            population: 4000,
            rainfall: 500
          })

          iconFeature.setStyle(iconStyle)
          return iconFeature
        })
        
		/* Vector Source */
		var vectorSource = new ol.source.Vector({
		  features: iconFeatures
		})
		
		/* Vector Layer */
		var vectorLayer = new ol.layer.Vector({
		  source: vectorSource
		})
		
		map.addLayer(vectorLayer)
		
		
        


      	//지도 이벤트
        map.on('click', function (evt) {
			alert("screen? " + evt.pixel);

			//기본좌표계
			//alert(evt.coordinate);

		    // convert coordinate to EPSG-4326
		    // 경위도 좌표로 표시.
		    alert(ol.proj.transform(evt.coordinate, 'EPSG:3857', 'EPSG:4326'))
        });
    </script>
  
   
</body>

</html>