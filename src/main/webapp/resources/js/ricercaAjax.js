function cerca() {
        let q = $('#q').val()
        if(q.length>0) {
            $.ajax({
                url: 'ricercaJSON',
                method: 'GET',
                data: {
                    "q": q
                },
                success: function (response) {
                    if (response != null) {
                        let json = JSON.parse(response);
                        let prodotti = "";
                        for (let i = 0; i < json.length; i++) {
                            prodotti += '<div class="col-auto col-sm-6 col-md-4 col-lg-4 col-xl-4 mb-4">' +
                                '<div class="card h-100" id="' + json[i].codice + '"><img src="' + json[i].imgSrc +
                                '" class="card-img-top img-fluid rounded-3 img-card-prodotto"><div class="card-body">' +
                                '<h5 class="card-title text-center">' + json[i].nome + '</h5><a href="prodotto?codice=' + json[i].codice +
                                '" class="btn btn-primary stretched-link btn-prodotto">' + json[i].prezzo + '€</a></div></div></div>';
                        }
                        $('#prodotti').html(prodotti);
                    }
                },
                error: function () {
                    $(location).attr('href', 'errorPage.jsp');
                }
            });
        }
}