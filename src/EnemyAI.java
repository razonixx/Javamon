public class EnemyAI {
	BFrame BFrame;
	Move enemyMove;
	int moveN = 0;
	public boolean moveIsSelected = false;
	public EnemyAI(BFrame BFrame) {
		this.BFrame = BFrame;
	}
	
	public void setUp() {
		BFrame.BSelectMove.enemyAttack();
		BFrame.BSelectMove.checkModifiers(BFrame.BPanel.EnemyMon, enemyMove);
		BFrame.BPanel.damage = BFrame.BSelectMove.calcDamage(BFrame.BPanel.EnemyMon, BFrame.BPanel.PlayerMon, enemyMove);
		if(BFrame.BPanel.damage < 1) {
			BFrame.BPanel.damage = 1;
		}
		BFrame.BSelectMove.setVisible(false);	
		this.moveIsSelected = true;
		BFrame.BText.isPlayerTurn = false;
		BFrame.repaint();
		System.out.println(enemyMove.getName());
		System.out.println(BFrame.BPanel.damage);	
		if(this.enemyMove.hasRecoil()) {
			//BFrame.BSelectMove.recoilDamage(BFrame.BPanel.EnemyMon,(BFrame.BPanel.damage / 3));
		}
	}
	public int enemyAttack() {
		switch ((int)Math.ceil(Math.random() * 4)){
		case 1:
			this.enemyMove = BFrame.BPanel.EnemyMon.enemyMonAttack1;
			this.setUp();
			this.moveN = 1;
			break;
		case 2:
			this.enemyMove = BFrame.BPanel.EnemyMon.enemyMonAttack2;
			this.setUp();
			this.moveN = 2;
			break;
		case 3:
			this.enemyMove = BFrame.BPanel.EnemyMon.enemyMonAttack3;
			this.setUp();
			this.moveN = 3;
			break;
		case 4:
			this.enemyMove = BFrame.BPanel.EnemyMon.enemyMonAttack4;
			this.setUp();
			this.moveN = 4;
			break;
		default:
			System.out.println("El Random del EnemyAI no entro en un rango de valores de 1 - 4");
			break;
		}
		return this.moveN;
	}
}
