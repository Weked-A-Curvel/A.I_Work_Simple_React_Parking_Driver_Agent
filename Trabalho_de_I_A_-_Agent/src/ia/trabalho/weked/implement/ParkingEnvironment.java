package ia.trabalho.weked.implement;

import java.util.Random;

import ia.trabalho.weked.interfaces.Agent;
import ia.trabalho.weked.interfaces.Percept;

public class ParkingEnvironment extends AbstractEnvironment{

	public ParkingEnvironment(DriverAgent agent) {
		super(3, 3, (Agent)agent);
		// TODO Auto-generated constructor stub
		this.createConstraints();
		/*for(int i=0; i < 3; i++) {//--
			for(int j=0; j < 3; j++) {
				System.out.print(this.environment[i][j] + " ");
			}
			System.out.println(" ");
		}*/
		System.out.println("estacionamento Criado, tamanho é de" + this.environment[0].length + " " + this.environment.length);
	}

	public ParkingEnvironment(int[][] environment) {
		super(environment);

	}
	
	public void createConstraints() {
		if(this.environment != null) {
			int decisionVet[] = {Integer.MAX_VALUE, Integer.MIN_VALUE};
			int valor = 0;

			Random gerador = new Random();

		    for (int i = 0; i < 3; i++) {
			    	valor = gerador.nextInt(99);
			    	//System.out.println(valor);
			    	valor = valor % 2;
			    	//System.out.println(valor);
		    	if(valor == 0) {
		    		this.environment[i][0] = decisionVet[0];
		    		//System.out.println(decisionVet[0]);
		    	}else {
		    		this.environment[i][0] = decisionVet[1];
		    		//System.out.println(decisionVet[1]);
		    	}
		    	this.environment[i][1] = 0;
			 }
		    
	    	//--------------
	    	gerador = new Random();
	    	
	    	 for (int i = 0; i < 3; i++) {
			    	valor = gerador.nextInt(99);
			    	//System.out.println(valor);
			    	valor = valor % 2;
			    	//System.out.println(valor);
		    	if(valor == 0) {
		    		this.environment[i][2] = decisionVet[0];
		    		//System.out.println(decisionVet[0]);
		    	}else {
		    		this.environment[i][2] = decisionVet[1];
		    		//System.out.println(decisionVet[1]);
		    	}
	    	 }
			
			/*
			 this.environment[0][0] = 2147483647;
			 this.environment[0][1] =0;
			 this.environment[0][2] = 2147483647;
			 this.environment[1][0] = 2147483647;
			 this.environment[1][1] = 0;
			 this.environment[1][2] = 2147483647;
			 this.environment[2][0] = 2147483647;
			 
			 this.environment[2][2] = 2147483647;	    	 
			 */
			
	    	 this.environment[2][1] = 1;
		}
	}
	
	@Override
	public Percept createView() {
		//encontrar o agente
		//olhar verificar a esquerda e a direita
		//salvar a posicao
		//vetor de visao é de tam 4
		int[] view;
		AgentPercept percept;
		
		
		view = new int[3];
		//descobrindo onde esta o agente
		if(view != null) {
			for(int i = 0; i < 3; i++) {
				if(this.environment[i][1] == 1) {
					view[0] = this.environment[i][0];
					view[1] = this.environment[i][2];
					view[2] = i;
				}
			}
			percept = new AgentPercept(view);			
			return percept;
		}
		return null;				
	}
	
	@Override
	public boolean sendViewToAgente() {
		DriverAgent driver;
		driver = (DriverAgent)this.environmentAgent.get(0);
		
		
		if(driver.action(this.createView(), this)) {
		
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					System.out.print(this.environment[i][j] + " ");
				}
				System.out.println(" ");
			}		
			
			return this.sendViewToAgente();
		}
		System.out.println("Me Desligando...");
		this.environmentAgent.get(0).setMeAlive(false);
				
		return false;
		
	}
		
}
