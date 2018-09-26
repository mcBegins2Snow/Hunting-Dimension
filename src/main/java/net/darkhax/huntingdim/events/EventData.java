package net.darkhax.huntingdim.events;

import net.darkhax.huntingdim.HuntingDimension;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants.NBT;

public class EventData {

    private final String name;
    private final String type;
    private final int startMonth;
    private final int startDay;
    private final int endMonth;
    private final int endDay;
    private final ItemStack[] items;

    public EventData (NBTTagCompound tag) {

        this.name = tag.getString("EventName");
        this.type = tag.getString("EventType");

        this.startMonth = tag.getInteger("StartMonth");
        this.startDay = tag.getInteger("StartDay");
        this.endMonth = tag.getInteger("EndMonth");
        this.endDay = tag.getInteger("EndDay");

        final NBTTagList list = tag.getTagList("ItemContents", NBT.TAG_COMPOUND);

        this.items = new ItemStack[list.tagCount()];

        for (int i = 0; i < list.tagCount(); i++) {

            this.items[0] = new ItemStack(list.getCompoundTagAt(i));
        }

        HuntingDimension.LOG.info("Loaded event {} with {} items.", this.name, this.items.length);
    }
}
