package ec.gob.agricultura.dsii.sw;

import javax.jws.WebParam;
import javax.jws.WebService;

import ec.gob.agricultura.dsii.sw.vo.VoAval;

@WebService(name="ServiciosSiscomtec")
public interface ServiciosSiscomtec {
	
	VoAval consultaAvalTecnico(@WebParam(name="numcedula") String numCedula, @WebParam(name="numaval") int numAval);

}
