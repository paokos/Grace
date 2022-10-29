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
                            // <div className="col">
                            //     <div className="card h-100" id="${prod.codice}">
                            //         <img src="${prod.imgsrc}" className="card-img-top" alt="...">
                            //             <div className="card-body">
                            //                 <h5 className="card-title">${prod.nome}</h5>
                            //                 <a href="prodotto?codice=${prod.codice}"
                            //                    className="btn btn-primary stretched-link">Visualizza</a>
                            //             </div>
                            //     </div>
                            // </div>

                            prodotti += '<div class="col">' +
                                '<div class="card h-100" id="' + json[i].codice + '"><img src="' + json[i].imgSrc + '" class="card-img-top"><div class="card-body">' +
                                '<h5 class="card-title">' + json[i].nome + '</h5>+<a href="prodotto?codice=' + json[i].codice +
                                '" class="btn btn-outline-secondary stretched-link">' + json[i].prezzo + '€</a></div></div></div>';
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