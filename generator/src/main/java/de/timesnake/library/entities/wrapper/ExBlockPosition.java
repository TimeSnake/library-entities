/*
 * Copyright (C) 2023 timesnake
 */

package de.timesnake.library.entities.wrapper;

import net.minecraft.core.BaseBlockPosition;
import net.minecraft.core.BlockPosition;

public class ExBlockPosition extends ExBaseBlockPosition {

  public ExBlockPosition(BlockPosition block) {
    super(block);
  }

  public ExBlockPosition(int x, int y, int z) {
    super(x, y, z);
  }

  public ExBlockPosition(double x, double y, double z) {
    super(x, y, z);
  }

  @Override
  public BlockPosition getNMS() {
    return (BlockPosition) super.getNMS();
  }

  public BlockPosition shift(ExEnumDirection direction) {
    return new BlockPosition(this.getX() + direction.getAdjacentX(),
        this.getY() + direction.getAdjacentY(),
        this.getZ() + direction.getAdjacentZ());
  }

  public BlockPosition shift(ExEnumDirection direction, int i) {
    return i == 0 ? this.getNMS() : new BlockPosition(this.getX() + direction.getAdjacentX() * i,
        this.getY() + direction.getAdjacentY() * i, this.getZ() + direction.getAdjacentZ() * i);
  }

  public BlockPosition up() {
    return this.shift(ExEnumDirection.UP);
  }

  public BlockPosition up(int var0) {
    return this.shift(ExEnumDirection.UP, var0);
  }

  public BlockPosition down() {
    return this.shift(ExEnumDirection.DOWN);
  }

  public BlockPosition down(int var0) {
    return this.shift(ExEnumDirection.DOWN, var0);
  }

  public BlockPosition north() {
    return this.shift(ExEnumDirection.NORTH);
  }

  public BlockPosition north(int var0) {
    return this.shift(ExEnumDirection.NORTH, var0);
  }

  public BlockPosition south() {
    return this.shift(ExEnumDirection.SOUTH);
  }

  public BlockPosition south(int var0) {
    return this.shift(ExEnumDirection.SOUTH, var0);
  }

  public BlockPosition west() {
    return this.shift(ExEnumDirection.WEST);
  }

  public BlockPosition west(int var0) {
    return this.shift(ExEnumDirection.WEST, var0);
  }

  public BlockPosition east() {
    return this.shift(ExEnumDirection.EAST);
  }

  public BlockPosition east(int var0) {
    return this.shift(ExEnumDirection.EAST, var0);
  }

  public ExBlockPosition exshift(ExEnumDirection direction) {
    return new ExBlockPosition(this.shift(direction));
  }

  public ExBlockPosition exshift(ExEnumDirection direction, int i) {
    return new ExBlockPosition(this.shift(direction, i));
  }

  public ExBlockPosition exup() {
    return new ExBlockPosition(this.up());
  }

  public ExBlockPosition exup(int var0) {
    return new ExBlockPosition(this.up(var0));
  }

  public ExBlockPosition exdown() {
    return new ExBlockPosition(this.down());
  }

  public ExBlockPosition exdown(int var0) {
    return new ExBlockPosition(this.down(var0));
  }

  public ExBlockPosition exnorth() {
    return new ExBlockPosition(this.north());
  }

  public ExBlockPosition exnorth(int var0) {
    return new ExBlockPosition(this.north(var0));
  }

  public ExBlockPosition exsouth() {
    return new ExBlockPosition(this.south());
  }

  public ExBlockPosition exsouth(int var0) {
    return new ExBlockPosition(this.south(var0));
  }

  public ExBlockPosition exwest() {
    return new ExBlockPosition(this.west());
  }

  public ExBlockPosition exwest(int var0) {
    return new ExBlockPosition(this.west(var0));
  }

  public ExBlockPosition exeast() {
    return new ExBlockPosition(this.east());
  }

  public ExBlockPosition exeast(int var0) {
    return new ExBlockPosition(this.east(var0));
  }

  public BlockPosition b(BaseBlockPosition blockPosition) {
    return this.getNMS().b(blockPosition);
  }

  public ExBlockPosition b(ExBaseBlockPosition blockPosition) {
    return new ExBlockPosition(this.b(blockPosition.getNMS()));
  }

  public BlockPosition.MutableBlockPosition i() {
    return this.getNMS().i();
  }
}
