import java.util.List;

import model.*;

import static java.lang.StrictMath.PI;

public final class MyStrategy implements Strategy {
    @SuppressWarnings("rawtypes")
	@Override
    public void move(Tank self, World world, Move move) {
        
    	Bonus allBns[] = world.getBonuses();
    	int currBon=0;
    	double minDist = 1000;
		int minDistNum = 0;
		double binusAngle = 0;
		
		Tank allTanks[] = world.getTanks();
    	int currTank=0;
    	double minDistTank = 1000;
		int minDistTankNum = 0;
		double tankAngle = 0;
    	
    	
    	for(Bonus i : allBns) {
    		if(i.getDistanceTo(self) < minDist){
    			minDist = i.getDistanceTo(self);
    			minDistNum = currBon;
//    			System.out.println(minDistNum);
    		}
    	currBon++;
    	}
    	
		if (minDistNum != allBns.length) {
			binusAngle = self.getAngleTo(allBns[minDistNum]);
			if (binusAngle > 10) {
				move.setLeftTrackPower(0.75D);
				move.setRightTrackPower(-1.0D);
			} else if (binusAngle < -10) {
				move.setLeftTrackPower(-1.0D);
				move.setRightTrackPower(0.75D);
			} else {
				move.setLeftTrackPower(1.0D);
				move.setRightTrackPower(1.0D);
			}
		}


		for(Tank i : allTanks) {
    		if(i.getDistanceTo(self) < minDistTank){
    			minDistTank = i.getDistanceTo(self);
    			minDistTankNum = currTank;
    		}
    	currTank++;
    	}
		
		tankAngle = self.getTurretAngleTo(allTanks[minDistTankNum]);
		if (tankAngle > 10) {
			move.setTurretTurn(1.0D);
		} else if (tankAngle < -10) {
			move.setTurretTurn(-1.0D);
		} else {		
			move.setFireType(FireType.PREMIUM_PREFERRED);
		}
    
    }

    @Override
    public TankType selectTank(int tankIndex, int teamSize) {
        return TankType.MEDIUM;
    }
}
