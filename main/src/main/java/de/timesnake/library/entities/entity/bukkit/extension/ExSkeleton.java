package de.timesnake.library.entities.entity.bukkit.extension;

import de.timesnake.library.entities.entity.bukkit.ExSkeletonBasis;
import de.timesnake.library.entities.wrapper.ExEntityType;
import de.timesnake.library.entities.wrapper.ExMobEffects;
import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.monster.EntitySkeleton;
import net.minecraft.world.entity.projectile.EntityArrow;
import net.minecraft.world.entity.projectile.EntityTippedArrow;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_18_R2.CraftServer;
import org.bukkit.craftbukkit.v1_18_R2.CraftWorld;
import org.bukkit.craftbukkit.v1_18_R2.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;

@NmsReflection
public class ExSkeleton extends ExSkeletonBasis {

    public ExSkeleton(World world, boolean loadDefaultPathfinderGoals) {
        super(((CraftServer) Bukkit.getServer()), new EntitySkeleton(ExEntityType.SKELETON.getNMSType(),
                ((CraftWorld) world).getHandle()) {
            @Override
            public void u() {
                if (loadDefaultPathfinderGoals) {
                    super.u();
                }
            }
        });
    }

    public ExSkeleton(World world, boolean loadDefaultPathfinderGoals, ExMobEffects arrowEffect, int durationInTicks,
                      int amplifier) {
        super(((CraftServer) Bukkit.getServer()), new EntitySkeleton(ExEntityType.SKELETON.getNMSType(),
                ((CraftWorld) world).getHandle()) {
            @Override
            public void u() {
                if (loadDefaultPathfinderGoals) {
                    super.u();
                }
            }

            @Override
            public EntityArrow b(net.minecraft.world.item.ItemStack var0, float var1) {
                EntityTippedArrow var2 =
                        (EntityTippedArrow) super.b(CraftItemStack.asNMSCopy(new ItemStack(Material.TIPPED_ARROW)),
                                var1);
                var2.a(new MobEffect(arrowEffect.getMobEffectList(), durationInTicks, amplifier));
                return var2;
            }
        });
    }

    public ExSkeleton(EntitySkeleton entity) {
        super(((CraftServer) Bukkit.getServer()), entity);
    }

}
