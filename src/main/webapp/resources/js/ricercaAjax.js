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
                $(location).attr('href', 'errorPage.jsp');
            }
        });
}