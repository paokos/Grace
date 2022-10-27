function cambioQuant() {
    var http = new XMLHttpRequest();
    var url = "json_comuni.php";
    var params = "provincia="+ provincia;
    http.open("GET", url+"?"+params, true);
    http.onreadystatechange = function() {
        if(http.readyState === 4 && http.status === 200) {
            var response = http.responseText;
            var json = JSON.parse(response); //parsa la stringa JSON che restituisce lo script json_comuni.php
            //elimina options
            $("#comune").children("option").remove(); // elimina tutte le select che ci sono già
            for(var i=0; i<json.length;i++){// ciclo che riempie di nuovo la select con id "comune" con le nuove option
                $('#comune').append('<option value="' + json[i].nome + '">' + json[i].nome + '</option>'); //nome è definito nella stringa JSON
            }
        }
    };
    http.send(null);
}