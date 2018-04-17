package ia.trabalho.weked.implement;

import java.util.ArrayList;

import ia.trabalho.weked.interfaces.Agent;
import ia.trabalho.weked.interfaces.Environment;


public abstract class AbstractEnvironment implements Environment{
	protected int environment[][];
	protected ArrayList<Agent> environmentAgent;
	
	public AbstractEnvironment(int i, int j, Agent agent) {
		this.environment = new int[i][j];
		this.environmentAgent = new ArrayList<Agent>();
		
		if(this.environmentAgent != null) {
			this.environmentAgent.add(agent);
		}
		
		if(this.environment != null) {
			this.startEnvironmentInitialState(i, j);
		}
		
	}
	//---
	public AbstractEnvironment(int environment[][]) {
		this.environment = environment;
	}
	//---
	public void startEnvironmentInitialState(int line, int colunm){
		if(this.environment != null) {
			for(int i=0; i < line; i++) {//--
				for(int j=0; j < colunm; j++) {
					this.environment[i][j] = Integer.MIN_VALUE;
					//System.out.println(environment[i][j]);					
				}
			}//--
		}
	}
	
	public void addAgent(Agent inAgent){
		if(this.environmentAgent != null) {//--
			this.environmentAgent.add(inAgent);
		}//--
	}
	
	public boolean removeAgent(Agent outAgent){
		if(this.environmentAgent != null) {//--
			this.environmentAgent.remove(outAgent);
			return true;
		}//--
		return false;
	}
	
	public ArrayList<Agent> getAgents(){
		return this.environmentAgent;
	}		
	
}
