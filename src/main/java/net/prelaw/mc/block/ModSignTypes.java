package net.prelaw.mc.block;

import net.minecraft.util.SignType;
import net.prelaw.mc.mixin.SignTypeAccessor;

public class ModSignTypes {
    public static final SignType PINK_SAKURA =
            SignTypeAccessor.registerNew(SignTypeAccessor.newSignType("pink_sakura"));
}
