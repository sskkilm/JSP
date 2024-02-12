function findLocation() {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(success, fail);
    } else {
        alert("사용자가 웹브라우저에 Geolocation API를 지원하지 않습니다.");
    }
}

function success(position) {
    const lat = position.coords.latitude;
    const lnt = position.coords.longitude;

    document.getElementById('latitude').value = lat;
    document.getElementById('longitude').value = lnt;
}

function fail(error) {
    switch(error.code) {
        case error.PERMISSION_DENIED:
            alert("User denied the request for Geolocation.");
            break;
        case error.POSITION_UNAVAILABLE:
            alert("Location information is unavailable.");
            break;
        case error.TIMEOUT:
            alert("The request to get user location timed out.");
            break;
        case error.UNKNOWN_ERROR:
            alert("An unknown error occurred.");
            break;
    }
}