package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Prodotto;
import model.ProdottoDAO;

import java.io.IOException;
import java.util.List;

@WebServlet ("/ricercaJSON")
public class ricercaJSON extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String q=req.getParameter("q");
        if(!q.isEmpty()){
            ProdottoDAO pd=new ProdottoDAO();
            List<Prodotto> risultati = pd.doRicerca(q);
            req.setAttribute("risultati", risultati);
            resp.setContentType("text/plain; charset=UTF-8");
            resp.getWriter().append("[");
            Prodotto p;
            for(int i=0; i<risultati.size(); i++) {
                p = risultati.get(i);
                resp.getWriter().append("{\"codice\":\""+p.getCodice()+"\", \"nome\":\""+p.getNome()+
                        "\",\"prezzo\":\""+p.getPrezzo()+"\", \"imgSrc\":\""+p.getImgsrc()+"\"}");
                if(i<risultati.size()-1)
                    resp.getWriter().append(",");
            }
            resp.getWriter().append("]");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
