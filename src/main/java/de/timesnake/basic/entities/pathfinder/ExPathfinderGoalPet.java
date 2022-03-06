package de.timesnake.basic.entities.pathfinder;

import de.timesnake.basic.entities.entity.extension.ExEntityInsentient;
import org.bukkit.entity.Player;

public class ExPathfinderGoalPet extends ExPathfinderGoal {

    public ExPathfinderGoalPet(Player owner, double entitySpeed, float minDistance, float teleportDistance) {
        super(new PathfinderGoalPet(null, owner, entitySpeed, minDistance, teleportDistance));
    }

    @Override
    public void injectEntity(ExEntityInsentient entity) {
        this.setNMSField("pet", entity);
    }

}