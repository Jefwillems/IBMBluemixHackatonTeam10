var giveDuration = function (origin, destination) {
    //var origin = 'Brussel';
    //var destination = 'Oostende';
    var bounds = new google.maps.LatLngBounds;
    var markersArray = [];

    var origins = origin;
    var destinations = destination;
    var geocoder = new google.maps.Geocoder;

    var service = new google.maps.DistanceMatrixService;
    service.getDistanceMatrix({
        origins: [origin],
        destinations: [destination],
        travelMode: 'DRIVING',
        unitSystem: google.maps.UnitSystem.METRIC,
        avoidHighways: false,
        avoidTolls: false
    }, function (response, status) {
        if (status !== 'OK') {
            alert('Error was: ' + status);
        } else {
            var time = response.rows[0].elements[0].duration.text;
            document.getElementById('time').innerHTML = time;
        }
    });
}
window.onload = function () {

    giveDuration("Brussel", "Poverello Gent");
}
