var RedCross = {
    Name: "Red cross",
    City:"Brussels",
    Street: "Rue de Stalle",
    Number: 96,
    NeededFood: null
}

var Oxfam = {
    Name: "Oxfam",
    City:"Ghent",
    Street: "Ververijstraat", 
    number: 17,
    NeededFood: "apple"
}

var Poverello = {
    Name: "Poverello",
    City: "Ghent",
    Street: "Komijnstraat",
    Number: 5,
    Street: "",
    NeededFood : null

}

var BroederlijkDelen= {
    Name: "Broederlijk Delen",
    City: "Brussels",
    Street: "Huidevettersstraat",
    Number: 165,
    NeededFood : "apple"
}
var NGOs = [RedCross, Oxfam, Poverello, BroederlijkDelen];


var optimalChoice = function (expirationDate, maxRange, neededGoods, stock) {
    
    if (expirationDate.day > 5) {
        return NGOs.firstChild;
    }
    else if (expirationDate.day > 2) {
        for (var ngo in NGOs) {
            if (ngo.NeededFood === stock);
        }
    } else {
        return NGOs.firstChild;
    }
    return null;
}