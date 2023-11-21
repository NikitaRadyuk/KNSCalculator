function openCalcPage(){
    window.location.href = "Calculator.html";
}

function initMap() {
    var myLatLng = { lat: 51.5074, lng: -0.1278 }; // Координаты для метки на карте
    var map = new google.maps.Map(document.getElementById('map'), {
        center: myLatLng,
        zoom: 12
    });

    var marker = new google.maps.Marker({
        position: myLatLng,
        map: map,
        title: 'Метка на карте'
    });

    var infowindow = new google.maps.InfoWindow({
        content: 'Текст вашей метки'
    });

    marker.addListener('click', function() {
        infowindow.open(map, marker);
    });
}
