$('#sendFunds').on('click', function (event) {
    /*
        {
            "$class": "xyz.jefwillems.AddFunds",
            "amount": 1,
            "name": "Apple",
            "expiringDate": 123456775,
            "houdbaarheid": "YES",
            "location": "Gent",
            "receiving": "resource:xyz.jefwillems.UserAsset#willems.jef@outlook.com",
            "timestamp": "2017-10-21T12:49:48.357Z"
        }
    */
    $.post('http://localhost:3000/api/AddFunds', {
            "$class": "xyz.jefwillems.AddFunds",
            "amount": 1,
            "name": "Apple",
            "expiringDate": 123456775,
            "houdbaarheid": "YES",
            "location": "Gent",
            "receiving": "resource:xyz.jefwillems.UserAsset#willems.jef@outlook.com",
            "timestamp": "2017-10-21T12:49:48.357Z"
        },
        function (err, data) {

        });
});