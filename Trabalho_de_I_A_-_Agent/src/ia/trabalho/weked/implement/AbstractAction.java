package ia.trabalho.weked.implement;

import ia.trabalho.weked.interfaces.Action;

public abstract class AbstractAction implements Action{

	@Override
	public boolean noAct() {
		return false;
	}

}
