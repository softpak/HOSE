package net.minecraft.server;

public class DifficultyDamageScaler {

    private final EnumDifficulty a;
    private final float b;

    public DifficultyDamageScaler(EnumDifficulty enumdifficulty, long i, long j, float f) {
        this.a = enumdifficulty;
        this.b = this.a(enumdifficulty, i, j, f);
    }

    public float c() {
        return this.b < 2.0F ? 0.0F : (this.b > 4.0F ? 1.0F : (this.b - 2.0F) / 2.0F);
    }

    private float a(EnumDifficulty enumdifficulty, long i, long j, float f) {
        if (enumdifficulty == EnumDifficulty.PEACEFUL) {
            return 0.0F;
        } else {
            boolean flag = enumdifficulty == EnumDifficulty.HARD;
            float f1 = 0.75F;
            float f2 = MathHelper.a(((float) i + -72000.0F) / 1440000.0F, 0.0F, 1.0F) * 0.25F;

            f1 += f2;
            float f3 = 0.0F;

            f3 += MathHelper.a((float) j / 3600000.0F, 0.0F, 1.0F) * (flag ? 1.0F : 0.75F);
            f3 += MathHelper.a(f * 0.25F, 0.0F, f2);
            if (enumdifficulty == EnumDifficulty.EASY) {
                f3 *= 0.5F;
            }

            f1 += f3;
            return (float) enumdifficulty.a() * f1;
        }
    }
}
