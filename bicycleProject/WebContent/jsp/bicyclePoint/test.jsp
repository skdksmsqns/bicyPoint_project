<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html xmlns="https://www.w3.org/1999/xhtml">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"> 
	<head>
	<title>WMTS를 이용한 배경지도 사용</title>
	<script src="https://www.openlayers.org/api/2.13/OpenLayers.js" type="text/javascript"></script>
	<SCRIPT language="JavaScript" type="text/javascript" src="https://map.vworld.kr/js/apis.do?type=Base&apiKey=767B7ADF-10BA-3D86-AB7E-02816B5B92E9"></SCRIPT>
	<SCRIPT language="JavaScript" type="text/javascript" src="https://map.vworld.kr/js/apis.do?type=Base&apiKey=CEB52025-E065-364C-9DBA-44880E3B02B8&domain=l"></SCRIPT>
	</head>
 
 <!-- ol2 -->
<script type="text/javascript">
	var map;
	var mapBounds = new OpenLayers.Bounds(123 , 32, 134 , 43);
	var mapMinZoom = 7;
	var mapMaxZoom = 19;

	// avoid pink tiles
	OpenLayers.IMAGE_RELOAD_ATTEMPTS = 3;
	OpenLayers.Util.onImageLoadErrorColor = "transparent";
	
	function init(){
	var options = {
		controls: [],
		projection: new OpenLayers.Projection("EPSG:4326"),
		//displayProjection: new OpenLayers.Projection("EPSG:4326"),
		displayProjection: new OpenLayers.Projection("EPSG:4326"),
		units: "m",
		controls : [],
		numZoomLevels:21,
		maxResolution: 156543.0339,
		maxExtent: new OpenLayers.Bounds(-20037508.34, -20037508.34, 20037508.34, 20037508.34)
		};
	map = new OpenLayers.Map('map', options);
	
	var osm = new OpenLayers.Layer.OSM();   				
	var options = {serviceVersion : "",
		layername: "",
		isBaseLayer: false,
		opacity : 1,
		type: 'png',
		transitionEffect: 'resize',
		tileSize: new OpenLayers.Size(256,256),
		min_level : 7,
		max_level : 18,
		buffer:0};

/* 	//1. 배경지도 추가하기
	vBase = new vworld.Layers.Base('VBASE');
	if (vBase != null){map.addLayer(vBase);}
	//2. 영상지도 추가하기
	vSAT = new vworld.Layers.Satellite('VSAT');
	if (vSAT != null) {map.addLayer(vSAT);};
	//3. 하이브리드지도 추가하기
	vHybrid = new vworld.Layers.Hybrid('VHYBRID');
	if (vHybrid != null) {map.addLayer(vHybrid);} 
	//4. Gray지도 추가하기
	vGray = new vworld.Layers.Gray('VGRAY');
	if (vGray != null){map.addLayer(vGray);}
	//5. Midnight지도 추가하기
	vMidnight = new vworld.Layers.Midnight('VMIDNIGHT');
	if (vMidnight != null){map.addLayer(vMidnight);} */

    var Base = new OpenLayers.Layer.XYZ(
 		  'Base',
 		  ['https://api.vworld.kr/req/wmts/1.0.0/CEB52025-E065-364C-9DBA-44880E3B02B8/Base/${z}/${y}/${x}.png'],
 		  {
 		    sphericalMercator: true,
 		    wrapDateLine: true
 		  }
	);
    var gray = new OpenLayers.Layer.XYZ(
   		  'gray',
   		  ['https://api.vworld.kr/req/wmts/1.0.0/CEB52025-E065-364C-9DBA-44880E3B02B8/gray/${z}/${y}/${x}.png'],
   		  {
   		    sphericalMercator: true,
   		    wrapDateLine: true
   		  }
  	);
    
    var midnight = new OpenLayers.Layer.XYZ(
   		  'midnight',
   		  ['https://api.vworld.kr/req/wmts/1.0.0/CEB52025-E065-364C-9DBA-44880E3B02B8/midnight/${z}/${y}/${x}.png'],
   		  {
   		    sphericalMercator: true,
   		    wrapDateLine: true
   		  }
  	);
    
    var Hybrid = new OpenLayers.Layer.XYZ(
   		  'Hybrid',
   		  ['https://api.vworld.kr/req/wmts/1.0.0/CEB52025-E065-364C-9DBA-44880E3B02B8/Hybrid/${z}/${y}/${x}.png'],
   		  {
   		    sphericalMercator: true,
   		    wrapDateLine: true
   		  }
  	);
	
    var Satellite = new OpenLayers.Layer.XYZ(
     		  'Satellite',
     		  ['https://api.vworld.kr/req/wmts/1.0.0/CEB52025-E065-364C-9DBA-44880E3B02B8/Satellite/${z}/${y}/${x}.jpeg'],
     		  {
     		    sphericalMercator: true,
     		    wrapDateLine: true
     		  }
   	);
    
    
    
	map.addLayers([osm,Base,gray,midnight,Hybrid,Satellite]);

	var switcherControl = new OpenLayers.Control.LayerSwitcher();
	map.addControl(switcherControl);
	switcherControl.maximizeControl();

	map.zoomToExtent( mapBounds.transform(map.displayProjection, map.projection ) );
	map.zoomTo(11);
		
	map.addControl(new OpenLayers.Control.PanZoomBar());
	map.addControl(new OpenLayers.Control.MousePosition());
	map.addControl(new OpenLayers.Control.Navigation());
	//map.addControl(new OpenLayers.Control.MouseDefaults()); //2.12 No Support
	map.addControl(new OpenLayers.Control.Attribution({separator:" "}))
	
    var vectorLayer = new OpenLayers.Layer.Vector("Overlay");
    
    // Define markers as "features" of the vector layer:
    var feature = new OpenLayers.Feature.Vector(
    		
            new OpenLayers.Geometry.Point(126.869407472541 , 37.4908656550751),
            {description:'아이콘 1 '} ,
            {externalGraphic: 'https://map.vworld.kr/images/ol3/marker_blue.png', graphicHeight: 25, graphicWidth: 21, graphicXOffset:-12, graphicYOffset:-25  }
        );    
    vectorLayer.addFeatures(feature);
    
    var feature = new OpenLayers.Feature.Vector(
            new OpenLayers.Geometry.Point(14215633.03459599, 4492228.092116951),
            {description:'아이콘 2 '} ,
            {externalGraphic: 'https://map.vworld.kr/images/ol3/marker_blue.png', graphicHeight: 25, graphicWidth: 21, graphicXOffset:-12, graphicYOffset:-25  }
        );    
    vectorLayer.addFeatures(feature);
   
    map.addLayer(vectorLayer);
    
    //Add a selector control to the vectorLayer with popup functions
    var controls = {
      selector: new OpenLayers.Control.SelectFeature(vectorLayer, { onSelect: createPopup, onUnselect: destroyPopup })
    };

    map.addControl(controls['selector']);
    controls['selector'].activate();
    
    
}
function deleteLayerByName(name){
	for (var i=0, len=map.layers.length; i<len; i++) {
		var layer = map.layers[i];
		if (layer.name == name) {
			map.removeLayer(layer);
			//return layer;
			break;
		}
	}
}

</script>
 </head>
    	<div id="page">
		<header>
		<div id="main">
			<aside>
				<jsp:include page="/jsp/includ/navMap.jsp" />
			</aside>
		</div>
		</header>
	</div>
 <body onload="init()">
<div id="map" style=" height: 75vh; width: 100vw;"></div>
<div >
	</div>		   
  </body>
</html>