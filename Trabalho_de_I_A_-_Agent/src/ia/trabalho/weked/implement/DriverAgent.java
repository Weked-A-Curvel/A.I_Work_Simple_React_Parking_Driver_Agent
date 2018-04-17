package ia.trabalho.weked.implement;

import ia.trabalho.weked.interfaces.Environment;
import ia.trabalho.weked.interfaces.Percept;

public class DriverAgent extends AbstractAgent{
	protected AgentAction action;
	
	public DriverAgent() {
		super(true);
		action = new AgentAction();
		System.out.println("fui criado, pronto para estacionar senhor!");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean action(Percept percepcao, Environment environment) {
		if(percepcao != null) {
			 return action.agentMovement((AgentPercept) percepcao, (ParkingEnvironment) environment);					 
		}
		return false;
	}

}
