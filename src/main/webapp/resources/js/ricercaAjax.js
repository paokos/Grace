// function ricercaAjax(q) {
//     let http = new XMLHttpRequest();
//     let url = "ricercaJSON";
//     let params = "q=" + q;
//     http.open("GET", url+"?"+params, true);
//     http.onreadystatechange = function() {
//         if(http.readyState === 4 && http.status === 200) {
//             let response = http.responseText;
//             let json = JSON.parse(response);
//             $('prodotti').remove();
//             for(let i=0; i<json.length; i++){
//                 $('div#prodotti').append('<a href="prodotto?codice=$"'+ json[i].codice +'" value="' + json[i].codice + '">' + json[i].nome + json[i].prezzo +
//                     '</a><img src="'+ ${prod.imgsrc} + '" height="200px" width="200px">');
//                 // <a href="prodotto?codice=${prod.codice}">
//                 //     <img src="${prod.imgsrc}" height="200px" width="200px">
//                 // </a>
//
//             }
//         }
//     };
//     http.send(null);
// }
function cerca() {
        let q = $('#q').val()
        $.ajax({
            url: 'ricercaJSON',
            method: 'GET',
            data: {
                "q": q
            },
            success: function (response) {
                if (response!=null){
                    let json = JSON.parse(response);
                    let prodotti = "";
                    for (let i = 0; i < json.length; i++) {
                        prodotti+='<a href="prodotto?codice=' + json[i].codice + '" value="' + json[i].codice + '">' + json[i].nome + json[i].prezzo +
                            '</a><img src="' + json[i].imgSrc +'" height="200px" width="200px">';
                    }
                    $('#prodotti').html(prodotti);
                }
            },
            error: function () {
                $(location).attr('href', 'error.page.jsp');
            }
        });

        // http.open("GET", url+"?"+params, true);
        // http.onreadystatechange = function() {
        //     if(http.readyState === 4 && http.status === 200) {
        //         let response = http.responseText;
        //         let json = JSON.parse(response);
        //         $('prodotti').remove();
        //         for(let i=0; i<json.length; i++){
        //             $('div#prodotti').append('<a href="prodotto?codice=$"'+ json[i].codice +'" value="' + json[i].codice + '">' + json[i].nome + json[i].prezzo +
        //                 '</a><img src="'+ ${prod.imgsrc} + '" height="200px" width="200px">');
        //         }
        //     }
        // };
        // http.send(null);
        // $('#changeable_text').text($(this).val());
}

// $.ajax({
//     url: 'modQuantCartDB',
//     type: 'GET',
//     data: {
//         attr_id: id, attr_newQuant: quant, attr_OldQuant: oldQuant
//     },
//     success: function (){
//         alert("Quantità aggiornata correttamente");
//     },
//     error: function () {
//         $(location).attr('href','error.page.jsp');
//     }
// });
