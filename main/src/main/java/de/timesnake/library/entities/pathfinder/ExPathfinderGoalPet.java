package de.timesnake.library.entities.pathfinder;

import de.timesnake.library.entities.entity.extension.ExEntityInsentient;
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