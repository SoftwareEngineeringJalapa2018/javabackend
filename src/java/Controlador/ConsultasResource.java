
package Controlador;

import Modelo.ConsultaDAO;
import Modelo.consultaStock;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("Stock")
public class ConsultasResource {
    ConsultaDAO conDao = new ConsultaDAO();
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<consultaStock> getConsultaStocks(){
        return conDao.getCosultaStock();
    }
    
}
