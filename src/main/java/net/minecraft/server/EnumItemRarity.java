package net.minecraft.server;

public enum EnumItemRarity {

    COMMON(EnumChatFormat.WHITE, "Common"), UNCOMMON(EnumChatFormat.YELLOW, "Uncommon"), RARE(EnumChatFormat.AQUA, "Rare"), EPIC(EnumChatFormat.LIGHT_PURPLE, "Epic");

    public final EnumChatFormat e;
    public final String f;

    private EnumItemRarity(EnumChatFormat enumchatformat, String s) {
        this.e = enumchatformat;
        this.f = s;
    }
}
