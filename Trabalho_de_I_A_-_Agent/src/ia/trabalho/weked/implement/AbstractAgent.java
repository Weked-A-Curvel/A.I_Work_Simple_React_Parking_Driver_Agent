package ia.trabalho.weked.implement;

import ia.trabalho.weked.interfaces.Agent;


public abstract class AbstractAgent implements Agent {
	protected boolean alive;
	
	public AbstractAgent(boolean alive) {
		this.setMeAlive(alive); 
	}

	public boolean iAmAlive() {
		return this.alive;
		
	}
	
	public void setMeAlive(boolean alive) {
		this.alive = alive;
	}
}
