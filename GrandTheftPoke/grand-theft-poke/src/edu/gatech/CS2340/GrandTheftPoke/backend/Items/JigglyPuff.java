package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

public class JigglyPuff extends Pokemon {

	public JigglyPuff() {
		super(1, 2, 3, 4);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Jiggly Puff Pokemon";
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}
}