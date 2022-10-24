<#include "../Header.ftl">

package ${moduleName};

<#include "../core/ExEntityImports.ftl">

import ${wrapperModuleName}.ExMobEffects;
import de.timesnake.library.reflection.NmsReflection;
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

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.DifficultyDamageScaler;
import net.minecraft.world.entity.EnumMobSpawn;
import net.minecraft.world.entity.GroupDataEntity;
import net.minecraft.world.level.WorldAccess;

import javax.annotation.Nullable;

@NmsReflection
public class ExSkeleton extends CraftSkeleton implements ${moduleName}.Skeleton {

    public ExSkeleton(World world, boolean loadDefaultPathfinderGoals, boolean randomizeData) {
        super(((CraftServer) Bukkit.getServer()), new EntitySkeleton(EntityTypes.aE,
                ((CraftWorld) world).getHandle()) {
            @Override
            public void u() {
                if (loadDefaultPathfinderGoals) {
                    super.u();
                }
            }

            @Override
            public @Nullable GroupDataEntity a(WorldAccess worldaccess, DifficultyDamageScaler difficultydamagescaler, EnumMobSpawn enummobspawn, @Nullable GroupDataEntity groupdataentity, @Nullable NBTTagCompound nbttagcompound) {
                if (randomizeData) {
                    return super.a(worldaccess, difficultydamagescaler, enummobspawn, groupdataentity, nbttagcompound);
                }
                return null;
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
