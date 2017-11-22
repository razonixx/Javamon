
public class Move {
	private String name,
				   type;
	
	private int power,
				accuracy,
				currentPP,
				totalPP,
				critModifier;
	
	private boolean recoil;
	
	public Move(String move) {
		switch (move) {
		case "THUNDERSHOCK":
			this.setName("THNDRSHCK");
			this.setType("ELECTRIC");
			this.setPower(40);
			this.setAccuracy(100);
			this.setCurrentPP(48);
			this.setTotalPP(48);
			this.setCritModifier(1);
			break;
			
		case "VOLT TACKLE":
			this.setName("VOLT TACKLE");
			this.setType("ELECTRIC");
			this.setPower(120);
			this.setAccuracy(100);
			this.setCurrentPP(24);
			this.setTotalPP(24);
			this.setRecoil(true);
			this.setCritModifier(1);
			break;
			
		case "QUICK ATTACK":
			this.setName("QUICK ATTACK");
			this.setType("NORMAL");
			this.setPower(40);
			this.setAccuracy(100);
			this.setCurrentPP(48);
			this.setTotalPP(48);
			this.setRecoil(false);
			this.setCritModifier(1);
			break;
			
		case "IRON TAIL":
			this.setName("IRON TAIL");
			this.setType("STEEL");
			this.setPower(100);
			this.setAccuracy(75);
			this.setCurrentPP(24);
			this.setTotalPP(24);
			this.setRecoil(false);
			this.setCritModifier(1);
			break;
			
		case "FLARE BLITZ":
			this.setName("FLARE BLITZ");
			this.setType("FIRE");
			this.setPower(120);
			this.setAccuracy(100);
			this.setCurrentPP(24);
			this.setTotalPP(24);
			this.setCritModifier(1);
			this.setRecoil(true);
			break;
			
		case "EXTREMESPEED":
			this.setName("EXTREMESPEED");
			this.setType("NORMAL");
			this.setPower(80);
			this.setAccuracy(100);
			this.setCurrentPP(8);
			this.setTotalPP(8);
			this.setRecoil(false);
			this.setCritModifier(1);
			break;
			
		case "FLAMETHROWER":
			this.setName("FLAMETHROWER");
			this.setType("FIRE");
			this.setPower(90);
			this.setAccuracy(100);
			this.setCurrentPP(24);
			this.setTotalPP(24);
			this.setRecoil(false);
			this.setCritModifier(1);
			break;
			
		case "WILD CHARGE":
			this.setName("WILD CHARGE");
			this.setType("ELECTRIC");
			this.setPower(90);
			this.setAccuracy(100);
			this.setCurrentPP(24);
			this.setTotalPP(24);
			this.setRecoil(true);
			this.setCritModifier(1);
			break;
			
		case "WING ATTACK":
			this.setName("WING ATTACK");
			this.setType("FLYING");
			this.setPower(60);
			this.setAccuracy(100);
			this.setCurrentPP(56);
			this.setTotalPP(56);
			this.setRecoil(false);
			this.setCritModifier(1);
			break;
			
		case "STONE EDGE":
			this.setName("STONE EDGE");
			this.setType("ROCK");
			this.setPower(100);
			this.setAccuracy(80);
			this.setCurrentPP(8);
			this.setTotalPP(8);
			this.setRecoil(false);
			this.setCritModifier(4);
			break;
			
		case "HEAD SMASH":
			this.setName("HEAD SMASH");
			this.setType("ROCK");
			this.setPower(150);
			this.setAccuracy(80);
			this.setCurrentPP(8);
			this.setTotalPP(8);
			this.setRecoil(true);
			this.setCritModifier(1);
			break;
			
		case "CRUNCH":
			this.setName("CRUNCH");
			this.setType("DARK");
			this.setPower(80);
			this.setAccuracy(100);
			this.setCurrentPP(24);
			this.setTotalPP(24);
			this.setRecoil(false);
			this.setCritModifier(1);
			break;
			
		case "X-SCISSOR":
			this.setName("X-SCISSOR");
			this.setType("BUG");
			this.setPower(80);
			this.setAccuracy(100);
			this.setCurrentPP(24);
			this.setTotalPP(24);
			this.setRecoil(false);
			this.setCritModifier(1);
			break;
			
		case "BULLET PUNCH":
			this.setName("BULLET PUNCH");
			this.setType("STEEL");
			this.setPower(40);
			this.setAccuracy(100);
			this.setCurrentPP(48);
			this.setTotalPP(48);
			this.setRecoil(false);
			this.setCritModifier(1);
			break;
			
		case "BUG BITE":
			this.setName("BUG BITE");
			this.setType("BUG");
			this.setPower(60);
			this.setAccuracy(100);
			this.setCurrentPP(32);
			this.setTotalPP(32);
			this.setRecoil(false);
			this.setCritModifier(1);
			break;
			
		case "IRON HEAD":
			this.setName("IRON HEAD");
			this.setType("STEEL");
			this.setPower(80);
			this.setAccuracy(100);
			this.setCurrentPP(24);
			this.setTotalPP(24);
			this.setRecoil(false);
			this.setCritModifier(1);
			break;
			
		case "EARTHQUAKE":
			this.setName("EARTHQUAKE");
			this.setType("GROUND");
			this.setPower(100);
			this.setAccuracy(100);
			this.setCurrentPP(16);
			this.setTotalPP(16);
			this.setRecoil(false);
			this.setCritModifier(1);
			break;
			
		case "FIRE BLAST":
			this.setName("FIRE BLAST");
			this.setType("FIRE");
			this.setPower(110);
			this.setAccuracy(85);
			this.setCurrentPP(8);
			this.setTotalPP(8);
			this.setRecoil(false);
			this.setCritModifier(1);
			break;
			
		case "AEROBLAST":
			this.setName("AEROBLAST");
			this.setType("FLYING");
			this.setPower(100);
			this.setAccuracy(95);
			this.setCurrentPP(8);
			this.setTotalPP(8);
			this.setRecoil(false);
			this.setCritModifier(4);
			break;
			
		case "AQUA TAIL":
			this.setName("AQUA TAIL");
			this.setType("WATER");
			this.setPower(90);
			this.setAccuracy(90);
			this.setCurrentPP(16);
			this.setTotalPP(16);
			this.setRecoil(false);
			this.setCritModifier(1);
			break;
			
		case "DRAGON PULSE":
			this.setName("DRAGON PULSE");
			this.setType("DRAGON");
			this.setPower(85);
			this.setAccuracy(100);
			this.setCurrentPP(16);
			this.setTotalPP(16);
			this.setRecoil(false);
			this.setCritModifier(1);
			break;
			
		case "PSYSHOCK":
			this.setName("PSYSHOCK");
			this.setType("PSYCHIC");
			this.setPower(80);
			this.setAccuracy(100);
			this.setCurrentPP(16);
			this.setTotalPP(16);
			this.setRecoil(false);
			this.setCritModifier(1);
			break;
			
		case "PSYSTRIKE":
			this.setName("PSYSTRIKE");
			this.setType("PSYCHIC");
			this.setPower(100);
			this.setAccuracy(100);
			this.setCurrentPP(16);
			this.setTotalPP(16);
			this.setRecoil(false);
			this.setCritModifier(1);
			break;
			
		case "THUNDER":
			this.setName("THUNDER");
			this.setType("ELECTRIC");
			this.setPower(110);
			this.setAccuracy(70);
			this.setCurrentPP(16);
			this.setTotalPP(16);
			this.setRecoil(false);
			this.setCritModifier(1);
			break;
			
		case "BLIZZARD":
			this.setName("BLIZZARD");
			this.setType("ICE");
			this.setPower(110);
			this.setAccuracy(70);
			this.setCurrentPP(8);
			this.setTotalPP(8);
			this.setRecoil(false);
			this.setCritModifier(1);
			break;
			
		case "POISON JAB":
			this.setName("POISON JAB");
			this.setType("POISON");
			this.setPower(80);
			this.setAccuracy(100);
			this.setCurrentPP(32);
			this.setTotalPP(32);
			this.setRecoil(false);
			this.setCritModifier(1);
			break;
			
		case "DYNAMIC PUNCH":
			this.setName("DYNMC PNCH");
			this.setType("FIGHTING");
			this.setPower(100);
			this.setAccuracy(100);
			this.setCurrentPP(8);
			this.setTotalPP(8);
			this.setRecoil(false);
			this.setCritModifier(1);
			break;
			
		case "MACH PUNCH":
			this.setName("MACH PUNCH");
			this.setType("FIGHTING");
			this.setPower(40);
			this.setAccuracy(100);
			this.setCurrentPP(48);
			this.setTotalPP(48);
			this.setRecoil(false);
			this.setCritModifier(1);
			break;
			
		case "ICE PUNCH":
			this.setName("ICE PUNCH");
			this.setType("ICE");
			this.setPower(75);
			this.setAccuracy(100);
			this.setCurrentPP(24);
			this.setTotalPP(24);
			this.setRecoil(false);
			this.setCritModifier(1);
			break;
			
		case "FIRE PUNCH":
			this.setName("FIRE PUNCH");
			this.setType("FIRE");
			this.setPower(75);
			this.setAccuracy(100);
			this.setCurrentPP(24);
			this.setTotalPP(24);
			this.setRecoil(false);
			this.setCritModifier(1);
			break;
			
		case "SACRED FIRE":
			this.setName("SACRED FIRE");
			this.setType("FIRE");
			this.setPower(100);
			this.setAccuracy(95);
			this.setCurrentPP(8);
			this.setTotalPP(8);
			this.setRecoil(false);
			this.setCritModifier(1);
			break;
			
		case "FLAME CHARGE":
			this.setName("FLAME CHARGE");
			this.setType("FIRE");
			this.setPower(50);
			this.setAccuracy(100);
			this.setCurrentPP(32);
			this.setTotalPP(32);
			this.setRecoil(false);
			this.setCritModifier(1);
			break;
			
		case "BRAVE BIRD":
			this.setName("BRAVE BIRD");
			this.setType("FLYING");
			this.setPower(120);
			this.setAccuracy(100);
			this.setCurrentPP(24);
			this.setTotalPP(24);
			this.setRecoil(true);
			this.setCritModifier(1);
			break;
			
		case "BODY SLAM":
			this.setName("BODY SLAM");
			this.setType("NORMAL");
			this.setPower(85);
			this.setAccuracy(100);
			this.setCurrentPP(24);
			this.setTotalPP(24);
			this.setRecoil(false);
			this.setCritModifier(1);
			break;
			
		case "HYPER BEAM":
			this.setName("HYPER BEAM");
			this.setType("NORMAL");
			this.setPower(150);
			this.setAccuracy(90);
			this.setCurrentPP(8);
			this.setTotalPP(8);
			this.setRecoil(false);
			this.setCritModifier(1);
			break;
			
		case "SURF":
			this.setName("SURF");
			this.setType("WATER");
			this.setPower(90);
			this.setAccuracy(100);
			this.setCurrentPP(24);
			this.setTotalPP(24);
			this.setRecoil(false);
			this.setCritModifier(1);
			break;
			
		case "ICE BEAM":
			this.setName("ICE BEAM");
			this.setType("ICE");
			this.setPower(90);
			this.setAccuracy(100);
			this.setCurrentPP(16);
			this.setTotalPP(16);
			this.setRecoil(false);
			this.setCritModifier(1);
			break;
			
		case "SHADOW BALL":
			this.setName("SHADOW BALL");
			this.setType("GHOST");
			this.setPower(80);
			this.setAccuracy(100);
			this.setCurrentPP(24);
			this.setTotalPP(24);
			this.setRecoil(false);
			this.setCritModifier(1);
			break;

		default:
			break;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}

	public boolean hasRecoil() {
		return recoil;
	}

	public void setRecoil(boolean recoil) {
		this.recoil = recoil;
	}

	public int getCurrentPP() {
		return currentPP;
	}

	public void setCurrentPP(int currentPP) {
		this.currentPP = currentPP;
	}

	public int getTotalPP() {
		return totalPP;
	}

	public void setTotalPP(int totalPP) {
		this.totalPP = totalPP;
	}

	public int getCritModifier() {
		return critModifier;
	}

	public void setCritModifier(int critModifier) {
		this.critModifier = critModifier;
	}
}
