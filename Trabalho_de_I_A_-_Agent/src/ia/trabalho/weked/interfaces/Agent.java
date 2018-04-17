package ia.trabalho.weked.interfaces;

public interface Agent {
	boolean action(Percept percepcao, Environment environment) ;
	
	boolean iAmAlive();
	
	void setMeAlive(boolean alive);
}
