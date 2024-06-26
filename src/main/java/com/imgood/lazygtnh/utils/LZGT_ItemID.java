package com.imgood.lazygtnh.utils;

import java.util.Objects;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import org.jetbrains.annotations.Nullable;

public class LZGT_ItemID {

    private Item item;
    private int metaData;
    private NBTTagCompound nbt;

    public LZGT_ItemID(Item item, int metaData, NBTTagCompound nbt) {
        this.item = item;
        this.metaData = metaData;
        this.nbt = nbt;
    }

    public LZGT_ItemID(Item item, int metaData) {
        this.item = item;
        this.metaData = metaData;
    }

    public LZGT_ItemID(Item item) {
        this.item = item;
        this.metaData = 0;
    }

    public LZGT_ItemID() {}

    public static LZGT_ItemID create(ItemStack itemStack) {
        return new LZGT_ItemID(itemStack.getItem(), itemStack.getItemDamage(), itemStack.getTagCompound());
    }

    public static LZGT_ItemID createNoNBT(ItemStack itemStack) {
        return new LZGT_ItemID(itemStack.getItem(), itemStack.getItemDamage());
    }

    public static LZGT_ItemID createAsWildcard(ItemStack itemStack) {
        return new LZGT_ItemID(itemStack.getItem(), 32767);
    }

    public ItemStack getItemStack() {
        return new ItemStack(this.item, 1, this.metaData);
    }

    public ItemStack getItemStack(int amount) {
        return new ItemStack(this.item, amount, this.metaData);
    }

    public ItemStack getItemStackWithNBT() {
        ItemStack itemStack = new ItemStack(this.item, 1, this.metaData);
        itemStack.setTagCompound(this.nbt);
        return itemStack;
    }

    public ItemStack getItemStackWithNBT(int amount) {
        ItemStack itemStack = new ItemStack(this.item, amount, this.metaData);
        itemStack.setTagCompound(this.nbt);
        return itemStack;
    }

    public boolean isWildcard() {
        return this.metaData == 32767;
    }

    public LZGT_ItemID setItem(Item item) {
        this.item = item;
        return this;
    }

    public LZGT_ItemID setMetaData(int metaData) {
        this.metaData = metaData;
        return this;
    }

    public LZGT_ItemID setNbt(NBTTagCompound nbt) {
        this.nbt = nbt;
        return this;
    }

    protected Item item() {
        return this.item;
    }

    protected int metaData() {
        return this.metaData;
    }

    protected @Nullable NBTTagCompound nbt() {
        return this.nbt;
    }

    protected @Nullable NBTTagCompound getNBT() {
        return this.nbt;
    }

    protected Item getItem() {
        return this.item;
    }

    protected int getMetaData() {
        return this.metaData;
    }

    public boolean equalItemStack(ItemStack itemStack) {
        return this.equals(this.isWildcard() ? createAsWildcard(itemStack) : createNoNBT(itemStack));
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof LZGT_ItemID)) {
            return false;
        } else {
            LZGT_ItemID lzgtItemID = (LZGT_ItemID) o;
            return this.metaData == lzgtItemID.metaData && Objects.equals(this.item, lzgtItemID.item)
                && Objects.equals(this.nbt, lzgtItemID.nbt);
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[] { this.item, this.metaData, this.nbt });
    }
}
