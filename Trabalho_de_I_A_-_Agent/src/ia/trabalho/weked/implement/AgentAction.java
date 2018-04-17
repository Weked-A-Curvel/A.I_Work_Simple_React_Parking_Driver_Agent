package ia.trabalho.weked.implement;

import ia.trabalho.weked.interfaces.Action;


public class AgentAction implements Action{ 
	
	public AgentAction() {
	}
	
	public boolean agentMovement(AgentPercept perception, ParkingEnvironment env) {
		if(perception != null) {
			if(perception.perceptions[0] < 0) {
				if(moveLeft(perception, env)) {
					System.out.println("Senhor Irei Estacionar nesta Vaga a Esquerda!");
					return true;
				}
			}else if (perception.perceptions[1] < 0) { 
				if(moveRight(perception, env)) { 
					System.out.println("Senhor Irei Estacionar nesta Vaga a Direita!");
					return true;
				}
			}else {
				if(moveUp(perception ,env)) {
					System.out.println("Senhor Aqui não Existem Vagas Disponiveis Irei Tentar as Proximas Vagas!");
					return true;
				}
			}
		}
		if(perception.perceptions[0] > 0 && perception.perceptions[1] > 0) {
			System.out.println("Senhor me Desculpe, nao posso Estacionar o Carro, as Vagas Devem estar Todas Cheias!");
			System.out.println("Ou Me Programaram um Tanto Errado xD!");
			System.out.println("Colocarei o Carro Fora Do Estacionamento e Irei me Desligar!");
			for(int i = 0; i < 3; i++) {
				env.environment[i][1] = 0;
			}
		}
		return false;
	}
	
	public boolean moveLeft(AgentPercept perception, ParkingEnvironment env) {
		if(env != null) {
			int parkingLocation = perception.perceptions[2];
			if(env.environment[parkingLocation][0] != 1) {
				env.environment[parkingLocation][0] = 1;
				env.environment[parkingLocation][1] = 0;
				return true;
			}
		}
		return false;
	}
	
	public boolean moveRight(AgentPercept perception, ParkingEnvironment env) {
		if(env != null) {
			int parkingLocation = perception.perceptions[2];
			if(env.environment[parkingLocation][2] != 1) {
				env.environment[parkingLocation][2] = 1;
				env.environment[parkingLocation][1] = 0;
				return true;
			}
		}
		return false;
	}
	
	public boolean moveUp(AgentPercept perception, ParkingEnvironment env) {
		if(env != null) {
			int parkingLocation = perception.perceptions[2];
			if((parkingLocation - 1) >= 0) {
				env.environment[parkingLocation][1] = 0;
				env.environment[parkingLocation - 1][1] = 1;
				return true;
			}			
		}
		return this.noAct();		
	}
	/*
	 * public agentMovement(perception)[
	 * 		se esq livre ir esquerda, se nao se direita livre ir pra direita, se nao avancar no estacionamento
	 * }
	 * 
	 * public moveLeft(){
	 * 		agente se move para a esquerda, isso deve ser marcado no environment
	 * }
	 * 
	 * public moveRight(){
	 * 		agente se move para a direira isso deve ser marcado no environment
	 * }
	 * 
	 * public moveUp(){
	 * 		agente se move para frente isso deve ser marcado no environment
	 * }
	 * */
	
	@Override
	public boolean noAct() {
		// TODO Auto-generated method stub
		return false;
	}

}
