<#include "../Header.ftl">

package ${moduleName};

<#include "../core/ExEntityImports.ftl">

import ${wrapperModuleName}.ExMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.monster.EntitySkeleton;
import net.minecraft.world.entity.projectile.EntityArrow;
import net.minecraft.world.entity.projectile.EntityTippedArrow;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.craftbukkit.${version}.CraftServer;
import org.bukkit.craftbukkit.${version}.CraftWorld;
import org.bukkit.craftbukkit.${version}.entity.CraftSkeleton;
import org.bukkit.craftbukkit.${version}.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;

public class ExSkeleton extends CraftSkeleton implements ExtendedCraftEntity<ExEntitySkeletonAbstract> {

    public ExSkeleton(World world, boolean loadDefaultPathfinderGoals) {
        super(((CraftServer) Bukkit.getServer()), new EntitySkeleton(EntityTypes.aE,
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
        super(((CraftServer) Bukkit.getServer()), new EntitySkeleton(EntityTypes.aE,
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

<#include "../core/ExEntityExtension.ftl">
}
