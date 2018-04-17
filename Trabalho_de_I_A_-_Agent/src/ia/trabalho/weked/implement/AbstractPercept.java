package ia.trabalho.weked.implement;

import ia.trabalho.weked.interfaces.Percept;

public abstract class AbstractPercept implements Percept{
	protected int []perceptions;
	
	public AbstractPercept(int[] perceptions) {
		this.makePercept(perceptions);
	}
	
	public int[] makePercept(int []perceptions) {
		if(perceptions != null) {
			this.perceptions = perceptions;
			return this.perceptions;
		}
		return null;
	}
}
