package ia.trabalho.weked.interfaces;

import java.util.ArrayList;

public interface Environment {
	void startEnvironmentInitialState(int line, int colunm);
	
	void addAgent(Agent agent);
	
    boolean removeAgent(Agent outAgent);
	
	ArrayList<Agent> getAgents();		
	
	Percept createView();
	
	boolean sendViewToAgente();
	
}
