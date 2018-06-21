package interfaces;

import java.util.ArrayList;

import modelado.Plan;

public interface PlanInterface {
	
	public ArrayList<Plan> listarPlanes();
	
	public int registraPlanes(Plan p);
	
	public int actualizar (Plan p);

}
