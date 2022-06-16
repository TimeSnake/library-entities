package de.timesnake.library.entities.inventory;

import de.timesnake.library.reflection.NmsReflection;
import net.minecraft.world.item.trading.MerchantRecipe;
import org.bukkit.craftbukkit.v1_18_R2.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;

@NmsReflection
public class ExMerchantRecipe {

    private final MerchantRecipe nms;

    public ExMerchantRecipe(ItemStack item1, ItemStack item2, ItemStack sellingItem, int uses, int maxUses, int xp,
                            float priceMultiplier) {
        this.nms = new MerchantRecipe(CraftItemStack.asNMSCopy(item1), CraftItemStack.asNMSCopy(item2),
                CraftItemStack.asNMSCopy(sellingItem), uses, maxUses, xp, priceMultiplier);
    }

    public ExMerchantRecipe(MerchantRecipe nms) {
        this.nms = nms;
    }

    public MerchantRecipe getNMS() {
        return nms;
    }

    public ItemStack getBuyItem1() {
        return CraftItemStack.asCraftMirror(this.getNMS().a());
    }

    public ItemStack getBuyItem2() {
        return CraftItemStack.asCraftMirror(this.getNMS().c());
    }

    public ItemStack getSellingItem() {
        return CraftItemStack.asCraftMirror(this.getNMS().d());
    }

    public int getUses() {
        return this.getNMS().g();
    }

    public void resetUses() {
        this.getNMS().h();
    }

    public int getMaxUses() {
        return this.getNMS().i();
    }

    public void increaseUses() {
        this.getNMS().j();
    }

    public int getDemand() {
        return this.getNMS().k();
    }

    public void increaseSpecialPrice(int i) {
        this.getNMS().a(i);
    }

    public void setSpecialPrice() {
        this.getNMS().l();
    }

    public int getSpecialPrice() {
        return this.getNMS().m();
    }

    public void setSpecialPrice(int i) {
        this.getNMS().b(i);
    }

    public float getPriceMultiplier() {
        return this.getNMS().n();
    }

    public int getXp() {
        return this.getNMS().o();
    }

    public boolean isFullyUsed() {
        return this.getNMS().p();
    }

    public boolean isRewardExp() {
        return this.getNMS().s();
    }
}
