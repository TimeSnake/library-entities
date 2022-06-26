package de.timesnake.library.entities.pathfinder.custom;

import de.timesnake.library.entities.entity.extension.ExEntityInsentient;
import org.bukkit.entity.Player;

public class ExCustomPathfinderGoalPet extends ExCustomPathfinderGoal {

    public ExCustomPathfinderGoalPet(Player owner, double entitySpeed, float minDistance, float teleportDistance) {
        super(new CustomPathfinderGoalPet(null, owner, entitySpeed, minDistance, teleportDistance));
    }

    @Override
    public void injectEntity(ExEntityInsentient entity) {
        this.setNMSField("pet", entity);
    }

}