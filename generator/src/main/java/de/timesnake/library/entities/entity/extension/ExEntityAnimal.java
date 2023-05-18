/*
 * Copyright (C) 2023 timesnake
 */

/*
    Copied from entity generator. Should only be edited in generator files
*/

package de.timesnake.library.entities.entity.extension;

import net.minecraft.server.level.WorldServer;
import net.minecraft.world.entity.animal.EntityAnimal;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftAnimals;

public class ExEntityAnimal extends ExEntityAgeable {

  public ExEntityAnimal(CraftAnimals entity) {
    super(entity);
  }

  public ExEntityAnimal(EntityAnimal entity) {
    super(entity);
  }

  @Override
  public EntityAnimal getNMS() {
    return (EntityAnimal) super.getNMS();
  }

  public void setLoveTicks(int i) {
    this.getNMS().s(i);
  }

  public boolean isInLove() {
    return this.getNMS().fQ();
  }

  public void resetLove() {
    this.getNMS().fG();
  }

  public boolean mate(ExEntityAnimal entity) {
    return this.getNMS().a(entity.getNMS());
  }

  public void makeLove(WorldServer worldServer, ExEntityAnimal entity) {
    this.makeLove(worldServer, entity.getNMS());
  }

  public void makeLove(WorldServer worldServer, EntityAnimal entity) {
    this.getNMS().a(worldServer, entity);
  }
}
